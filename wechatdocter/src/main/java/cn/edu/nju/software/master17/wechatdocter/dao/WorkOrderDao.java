package cn.edu.nju.software.master17.wechatdocter.dao;

import cn.edu.nju.software.master17.wechatdocter.models.WorkOrder;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;

/**
 *
 * @author csc
 * @date 2017/12/7
 */

@Transactional
public interface WorkOrderDao extends CrudRepository<WorkOrder, Long>{

    ArrayList<WorkOrder> findByUserId(Long userId);

    WorkOrder findById(Long id);

    ArrayList<WorkOrder> findByLastChat(String lastChat);

}
