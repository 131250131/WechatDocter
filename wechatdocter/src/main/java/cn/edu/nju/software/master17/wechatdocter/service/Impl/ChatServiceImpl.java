package cn.edu.nju.software.master17.wechatdocter.service.Impl;

import cn.edu.nju.software.master17.wechatdocter.dao.ChatDao;
import cn.edu.nju.software.master17.wechatdocter.dao.Photo2ChatDao;
import cn.edu.nju.software.master17.wechatdocter.dao.PhotoDao;
import cn.edu.nju.software.master17.wechatdocter.dao.WorkOrderDao;
import cn.edu.nju.software.master17.wechatdocter.models.Chat;
import cn.edu.nju.software.master17.wechatdocter.models.Photo;
import cn.edu.nju.software.master17.wechatdocter.models.Photo2Chat;
import cn.edu.nju.software.master17.wechatdocter.service.ChatService;
import cn.edu.nju.software.master17.wechatdocter.web.data.ChatVO;
import cn.edu.nju.software.master17.wechatdocter.web.data.PhotoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author csc
 * @date 2017/12/7
 */

@Service
public class ChatServiceImpl implements ChatService{
    @Autowired
    private ChatDao chatDao;

    @Autowired
    private WorkOrderDao workOrderDao;

    @Autowired
    private PhotoDao photoDao;

    @Autowired
    private Photo2ChatDao photo2ChatDao;

    @Override
    public ChatVO addChat2WorkOrder(ChatVO chatVO) {
        ChatVO result = new ChatVO();
        Chat chat =  new Chat();
        Integer chatType = chatVO.getType().equals("inquiry")?1:0; // bad design
        chat.setType(chatType);
        chat.setDescription(chatVO.getDescription());
        chat.setWorkOrderId(chatVO.getWorkOrderId());
        chat.setCreateTime(new Timestamp(System.currentTimeMillis()));
        chat.setSequenceId(calculateSequenceIdForChat(chatVO.getWorkOrderId()));
        chat = chatDao.save(chat);
        result.setPatientId(getUserIdByWorkOrderId(chat.getWorkOrderId()));
        result.setDescription(chat.getDescription());
        result.setSequenceId(chat.getSequenceId());
        result.setType(chatVO.getType());
        result.setWorkOrderId(chat.getWorkOrderId());
        result.setChatId(chat.getId());
        for (PhotoVO photoVO: chatVO.getPhotos()){
            Photo2Chat photo2Chat = new Photo2Chat();
            photo2Chat.setActive(true);
            photo2Chat.setChatId(chat.getId());
            photo2Chat.setPhotoId(photoVO.getId());
            photo2ChatDao.save(photo2Chat);
        }
        result.setPhotos(chatVO.getPhotos());
        return result;
    }

    @Override
    public ArrayList<ChatVO> getChatsByWorkOrderId(Long workOrderId) {
        ArrayList<ChatVO> result = new ArrayList<ChatVO>();
        ArrayList<Chat> chats = chatDao.findByWorkOrderId(workOrderId);
        for(Chat chat: chats) {
            ChatVO chatVO = new ChatVO();
            chatVO.setDescription(chat.getDescription());
            chatVO.setWorkOrderId(chat.getWorkOrderId());
            chatVO.setSequenceId(chat.getSequenceId());
            chatVO.setChatId(chat.getId());
            chatVO.setPhotos(getPhotoVOByChatId(chat.getId()));
            chatVO.setType(chat.getType()==1?"inquiry":"diagnostic");
        }
        return result;
    }

    // photos need to be checked
    @Override
    public ChatVO updateChat(ChatVO chatVO) {
        ChatVO result = new ChatVO();
        Chat chat = new Chat();
        chat.setSequenceId(chatVO.getSequenceId());
        chat.setCreateTime(chatVO.getTime());
        chat.setWorkOrderId(chatVO.getWorkOrderId());
        chat.setDescription(chatVO.getDescription());
        chat.setType(chatVO.getType().equals("inquiry")?1:0);
        chat.setId(chatVO.getChatId());
        chat = chatDao.save(chat);
        for(Photo2Chat photo2Chat: photo2ChatDao.findByChatId(chat.getId())) {
            photo2Chat.setActive(false);
            photo2ChatDao.save(photo2Chat);
        }
        for(PhotoVO photoVO: chatVO.getPhotos()) {
            Photo2Chat photo2Chat = photo2ChatDao.findByPhotoIdAndChatId(photoVO.getId(), chat.getId());
            if(photo2Chat==null) {
                photo2Chat.setActive(true);
                photo2ChatDao.save(photo2Chat);
            } else {
                Photo2Chat newChat2Photo = new Photo2Chat();
                newChat2Photo.setActive(true);
                newChat2Photo.setPhotoId(photoVO.getId());
                newChat2Photo.setChatId(chat.getId());
                photo2ChatDao.save(newChat2Photo);
            }
        }
        result.setPatientId(getUserIdByWorkOrderId(chat.getWorkOrderId()));
        result.setDescription(chat.getDescription());
        result.setSequenceId(chat.getSequenceId());
        result.setType(chatVO.getType());
        result.setWorkOrderId(chat.getWorkOrderId());
        result.setChatId(chat.getId());
        return result;
    }

    @Override
    public PhotoVO updatePhoto(PhotoVO photoVO) {
        Photo photo = photoDao.findById(photoVO.getId());
        photo.setCategoryId(photoVO.getCategoryId());
        photoDao.save(photo);
        return photoVO;
    }

    private ArrayList<PhotoVO> getPhotoVOByChatId(Long chatId) {
        ArrayList<PhotoVO> result = new ArrayList<PhotoVO>();
        ArrayList<Photo2Chat> photo2Chats = photo2ChatDao.findByChatId(chatId);
        for(Photo2Chat photo2Chat: photo2Chats) {
            PhotoVO photoVO = new PhotoVO();
            Photo photo = photoDao.findOne(photo2Chat.getPhotoId());
            photoVO.setCategoryId(photo.getCategoryId());
            photoVO.setId(photo.getId());
            photoVO.setUrl(photo.getUrl());
            result.add(photoVO);
        }
        return result;
    }


    private int calculateSequenceIdForChat(Long workOrderId) {
        return chatDao.findByWorkOrderId(workOrderId).size()+1;
    }

    private Long getUserIdByWorkOrderId(Long workOrderId) {
        return workOrderDao.findById(workOrderId).getUserId();
    }
}
