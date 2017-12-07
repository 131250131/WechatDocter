package cn.edu.nju.software.master17.wechatdocter.dao;

import cn.edu.nju.software.master17.wechatdocter.models.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by csc on 2017/12/8.
 */
public interface UserDao extends CrudRepository<User, Long>{
}
