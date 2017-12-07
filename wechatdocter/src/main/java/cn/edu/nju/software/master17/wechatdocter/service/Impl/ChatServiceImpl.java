package cn.edu.nju.software.master17.wechatdocter.service.Impl;

import cn.edu.nju.software.master17.wechatdocter.dao.ChatDao;
import cn.edu.nju.software.master17.wechatdocter.dao.WorkOrderDao;
import cn.edu.nju.software.master17.wechatdocter.models.Chat;
import cn.edu.nju.software.master17.wechatdocter.service.ChatService;
import cn.edu.nju.software.master17.wechatdocter.web.data.ChatVO;
import cn.edu.nju.software.master17.wechatdocter.web.data.WorkOrderVO;
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
        return result;
    }

    @Override
    public ArrayList<ChatVO> getChatsByWorkOrderId(Long workOrderId) {
        ArrayList<ChatVO> result = new ArrayList<ChatVO>();
        return result;
    }


    private int calculateSequenceIdForChat(Long workOrderId) {
        return chatDao.findByWorkOrderId(workOrderId).size()+1;
    }

    private Long getUserIdByWorkOrderId(Long workOrderId) {
        return workOrderDao.findById(workOrderId).getUserId();
    }
}
