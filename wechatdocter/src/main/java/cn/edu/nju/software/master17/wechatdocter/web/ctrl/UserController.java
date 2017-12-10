package cn.edu.nju.software.master17.wechatdocter.web.ctrl;

import cn.edu.nju.software.master17.wechatdocter.service.UserService;
import cn.edu.nju.software.master17.wechatdocter.web.data.UserVO;
import cn.edu.nju.software.master17.wechatdocter.web.exception.HttpBadParamsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

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

    @RequestMapping(value = "/user/openId/", method = RequestMethod.POST)
    public UserVO saveUserVO(@RequestBody @NotNull UserVO userVO) {
        if(!userVO.getOpenId().isEmpty()) {
            return userService.saveUser(userVO);
        }else {
            throw new HttpBadParamsException("OpenId can't be empty!");
        }
    }

}
