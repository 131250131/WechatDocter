package cn.edu.nju.software.master17.wechatdocter.service.Impl;

import cn.edu.nju.software.master17.wechatdocter.dao.WorkOrderDao;
import cn.edu.nju.software.master17.wechatdocter.models.WorkOrder;
import cn.edu.nju.software.master17.wechatdocter.service.WorkOrderService;
import cn.edu.nju.software.master17.wechatdocter.web.data.WorkOrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by csc on 2017/12/7.
 */
@Service
public class WorkOrderServiceImpl implements WorkOrderService {

    @Autowired
    private WorkOrderDao workOrderDao;

    @Override
    public WorkOrderVO newWorkOrder(WorkOrderVO workOrderVO) {
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
