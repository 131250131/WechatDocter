package cn.edu.nju.software.master17.wechatdocter.dao;

import cn.edu.nju.software.master17.wechatdocter.models.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 *
 * @author csc
 * @date 2017/12/8
 */
@Transactional
public interface UserDao extends CrudRepository<User, Long>{

    User findByOpenId(String openId);
    User findById(Long id);

}
