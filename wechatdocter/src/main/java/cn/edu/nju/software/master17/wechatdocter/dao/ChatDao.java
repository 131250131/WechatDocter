package cn.edu.nju.software.master17.wechatdocter.dao;

import cn.edu.nju.software.master17.wechatdocter.models.Chat;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;

/**
 *
 * @author csc
 * @date 2017/12/7
 */
@Transactional
public interface ChatDao extends CrudRepository<Chat, Long>{

    ArrayList<Chat> findByWorkOrderId(Long workOrderId);

}
