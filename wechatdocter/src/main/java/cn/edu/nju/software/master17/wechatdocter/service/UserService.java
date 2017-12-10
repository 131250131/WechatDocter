package cn.edu.nju.software.master17.wechatdocter.service;

import cn.edu.nju.software.master17.wechatdocter.web.data.UserVO;

/**
 *
 * @author csc
 * @date 2017/12/9
 */
public interface UserService {

    UserVO getUserByOpenId(String openId);
    UserVO saveUser(UserVO userVO);

}
