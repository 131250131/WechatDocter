package cn.edu.nju.software.master17.wechatdocter.web.ctrl;

import cn.edu.nju.software.master17.wechatdocter.service.UserService;
import cn.edu.nju.software.master17.wechatdocter.web.data.UserVO;
import cn.edu.nju.software.master17.wechatdocter.web.exception.HttpBadParamsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author csc
 * @date 2017/12/9
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/openId/{openId}", method = RequestMethod.GET)
    public UserVO getUserVO(@PathVariable("openId") String openId) {
        if(!openId.isEmpty()) {
            return userService.getUserByOpenId(openId);
        }else {
            throw new HttpBadParamsException("OpenId can't be empty!");
        }
    }
}
