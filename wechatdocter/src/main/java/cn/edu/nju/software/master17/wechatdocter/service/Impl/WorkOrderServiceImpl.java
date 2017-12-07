package cn.edu.nju.software.master17.wechatdocter.service.Impl;

import cn.edu.nju.software.master17.wechatdocter.dao.WorkOrderDao;
import cn.edu.nju.software.master17.wechatdocter.models.Chat;
import cn.edu.nju.software.master17.wechatdocter.models.WorkOrder;
import cn.edu.nju.software.master17.wechatdocter.service.ChatService;
import cn.edu.nju.software.master17.wechatdocter.service.WorkOrderService;
import cn.edu.nju.software.master17.wechatdocter.web.data.ChatVO;
import cn.edu.nju.software.master17.wechatdocter.web.data.WorkOrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Created by csc on 2017/12/7.
 */
@Service
public class WorkOrderServiceImpl implements WorkOrderService {

    @Autowired
    private WorkOrderDao workOrderDao;

    @Autowired
    private ChatService chatService;

    @Override
    public WorkOrderVO newWorkOrder(WorkOrderVO workOrderVO) {
        WorkOrder workOrder = new WorkOrder();
        workOrder.setCreateTime(new Timestamp(System.currentTimeMillis()));
        workOrder.setDescription(workOrderVO.getDescription());
        workOrder.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        workOrder.setUserId(workOrderVO.getPatientId());
        workOrder = workOrderDao.save(workOrder);
        ChatVO chatVO = new ChatVO();
        chatVO.setWorkOrderId(workOrder.getId());
        chatVO.setType(workOrderVO.getType());
        chatVO.setDescription(workOrderVO.getDescription());
        chatVO = chatService.addChat2WorkOrder(chatVO);




        return null;
    }

    @Override
    public WorkOrderVO removeWorkOrder(WorkOrderVO workOrderVO) {
        return null;
    }

    @Override
    public WorkOrderVO updateWorkOrder(WorkOrderVO workOrderVO) {
        return null;
    }

    @Override
    public ArrayList<WorkOrderVO> getAllWorkOrderByUserId(Long userId) {
        return null;
    }

    @Override
    public ArrayList<WorkOrderVO> getAllWorkOrderOfDocter() {

        return null;
    }

    @Override
    public WorkOrderVO getWorkOrderById(Long workOrderId) {
        return null;
    }
}
