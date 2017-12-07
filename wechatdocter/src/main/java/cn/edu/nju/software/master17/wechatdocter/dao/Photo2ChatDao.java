package cn.edu.nju.software.master17.wechatdocter.dao;

import cn.edu.nju.software.master17.wechatdocter.models.Photo2Chat;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;

/**
 *
 * @author csc
 * @date 2017/12/8
 */
@Transactional
public interface Photo2ChatDao extends CrudRepository<Photo2Chat, Long>{
    ArrayList<Photo2Chat> findByChatId(Long chatId);
}
