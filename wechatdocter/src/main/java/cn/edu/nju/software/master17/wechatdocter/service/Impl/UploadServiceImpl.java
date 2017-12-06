package cn.edu.nju.software.master17.wechatdocter.service.Impl;

import cn.edu.nju.software.master17.wechatdocter.dao.PhotoDao;
import cn.edu.nju.software.master17.wechatdocter.models.Photo;
import cn.edu.nju.software.master17.wechatdocter.service.UploadService;
import cn.edu.nju.software.master17.wechatdocter.web.data.PhotoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

@Service
public class UploadServiceImpl implements UploadService {

    @Autowired
    private PhotoDao photoDao;

    @Override
    public PhotoVO uploadImage(MultipartFile file,Long userId,Long categoryId) {
        if(!file.isEmpty()) {
            String name = file.getOriginalFilename();
            String uuid = UUID.randomUUID().toString();
            Photo photo = new Photo();
            try {
                String path = "/home/tongue/" + uuid + "_" + name;
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File(path)));
                out.write(file.getBytes());
                out.flush();
                out.close();

                //save to database
                photo.setUrl(path);
                photo.setUserId(userId);
                photo.setCategoryId(categoryId);
                Photo newPhoto = photoDao.save(photo);

                PhotoVO photoVO = new PhotoVO();
                photoVO.setId(newPhoto.getId());
                photoVO.setUrl(newPhoto.getUrl());
                photoVO.setCategoryId(newPhoto.getCategoryId());
                return photoVO;
            } catch (Exception e) {
                e.printStackTrace();
                throw new IllegalArgumentException();
            }
        }else {
            throw new IllegalArgumentException();
        }
    }
}
