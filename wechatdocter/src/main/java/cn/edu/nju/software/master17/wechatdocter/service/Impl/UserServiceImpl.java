package cn.edu.nju.software.master17.wechatdocter.service.Impl;

import cn.edu.nju.software.master17.wechatdocter.dao.UserDao;
import cn.edu.nju.software.master17.wechatdocter.models.User;
import cn.edu.nju.software.master17.wechatdocter.service.UserService;
import cn.edu.nju.software.master17.wechatdocter.web.data.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author csc
 * @date 2017/12/9
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public UserVO getUserByOpenId(String openId) {
        User user = userDao.findByOpenId(openId);
        UserVO userVO = new UserVO();
        userVO.setPatientId(user.getId());
        userVO.setOpenId(user.getOpenId());
        userVO.setName(user.getName());
        userVO.setAge(user.getAge());
        userVO.setSex(user.isSex()?"male":"female");
        userVO.setMobile(user.getMobile());
        userVO.setHistory(user.getHistory());
        return userVO;
    }
}
