package cn.edu.nju.software.master17.wechatdocter.web.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    @RequestMapping(value = "/api/test/getSession", method = RequestMethod.GET)
    public String getSession() {
        return "test successful";
    }

}
