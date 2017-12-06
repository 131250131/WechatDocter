package cn.edu.nju.software.master17.wechatdocter.web.ctrl;


import cn.edu.nju.software.master17.wechatdocter.service.UploadService;
import cn.edu.nju.software.master17.wechatdocter.web.data.PhotoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public PhotoVO uploadImage(@RequestParam("file") MultipartFile file,
                               @RequestParam("uid") Long userId,
                               @RequestParam("categoryId") Long categoryId){
        return uploadService.uploadImage(file, userId, categoryId);
    }
}
