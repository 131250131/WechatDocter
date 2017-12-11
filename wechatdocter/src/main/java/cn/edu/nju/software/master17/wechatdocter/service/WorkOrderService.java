package cn.edu.nju.software.master17.wechatdocter.service;

import cn.edu.nju.software.master17.wechatdocter.models.WorkOrder;
import cn.edu.nju.software.master17.wechatdocter.web.data.ChatVO;
import cn.edu.nju.software.master17.wechatdocter.web.data.PhotoVO;
import cn.edu.nju.software.master17.wechatdocter.web.data.WorkOrderVO;

import java.util.ArrayList;

/**
 *
 * @author csc
 * @date 2017/12/7
 */

public interface WorkOrderService {
    WorkOrderVO newWorkOrder(WorkOrderVO workOrderVO);

    WorkOrderVO removeWorkOrder(WorkOrderVO workOrderVO);

    WorkOrderVO updateWorkOrder(WorkOrderVO workOrderVO);

    ArrayList<WorkOrderVO> getAllWorkOrderByUserId(Long userId);

    ArrayList<WorkOrderVO> getAllWorkOrderOfDocter();

    WorkOrderVO getWorkOrderById(Long workOrderId);

    ArrayList<WorkOrderVO> getAllWorkOrderOfDocter(String lastChat);

}
