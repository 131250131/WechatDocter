package cn.edu.nju.software.master17.wechatdocter.service;

import cn.edu.nju.software.master17.wechatdocter.web.data.PhotoVO;
import org.springframework.web.multipart.MultipartFile;


public interface UploadService {
    PhotoVO uploadImage(MultipartFile file,Long userId,Long categoryId);
}
