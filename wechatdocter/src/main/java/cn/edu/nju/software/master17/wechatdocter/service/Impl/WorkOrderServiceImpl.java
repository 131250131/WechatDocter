package cn.edu.nju.software.master17.wechatdocter.service.Impl;

import cn.edu.nju.software.master17.wechatdocter.dao.WorkOrderDao;
import cn.edu.nju.software.master17.wechatdocter.models.Photo;
import cn.edu.nju.software.master17.wechatdocter.models.WorkOrder;
import cn.edu.nju.software.master17.wechatdocter.service.ChatService;
import cn.edu.nju.software.master17.wechatdocter.service.WorkOrderService;
import cn.edu.nju.software.master17.wechatdocter.web.data.ChatVO;
import cn.edu.nju.software.master17.wechatdocter.web.data.PhotoVO;
import cn.edu.nju.software.master17.wechatdocter.web.data.WorkOrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author csc
 * @date 2017/12/7
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
        workOrder.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        workOrder.setUserId(workOrderVO.getPatientId());
        workOrder.setDescription(workOrderVO.getDescription());
        workOrder = workOrderDao.save(workOrder);
        ArrayList<ChatVO> inputChats = workOrderVO.getChats();
        ArrayList<ChatVO> outputChats  = new ArrayList<ChatVO>();
        for(ChatVO chatVO: inputChats) {
            chatVO.setWorkOrderId(workOrder.getId());
            chatVO = chatService.addChat2WorkOrder(chatVO);
            outputChats.add(chatVO);
        }
        workOrderVO.setLastChat("patient");
        workOrderVO.setChats(outputChats);
        workOrderVO.setDescription(workOrder.getDescription());
        workOrderVO.setPatientId(workOrder.getUserId());
        workOrderVO.setWorkOrderId(workOrder.getId());
        workOrderVO.setTime(workOrder.getUpdateTime());
        return workOrderVO;
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
        ArrayList<WorkOrderVO> result = new ArrayList<WorkOrderVO>();
        Iterable<WorkOrder> iterable =  workOrderDao.findByUserId(userId);
        for(WorkOrder workOrder: iterable) {
            WorkOrderVO workOrderVO =  workOrder2WorkOrderVO(workOrder);
            result.add(workOrderVO);
        }
        return result;
    }

    @Override
    public ArrayList<WorkOrderVO> getAllWorkOrderOfDocter() {
        ArrayList<WorkOrderVO> result = new ArrayList<WorkOrderVO>();
        Iterable<WorkOrder> iterable =  workOrderDao.findAll();
        for(WorkOrder workOrder: iterable) {
            WorkOrderVO workOrderVO = workOrder2WorkOrderVO(workOrder);
            result.add(workOrderVO);
        }
        return result;
    }

    @Override
    public WorkOrderVO getWorkOrderById(Long workOrderId) {
        WorkOrderVO result = new WorkOrderVO();
        WorkOrder workOrder = workOrderDao.findById(workOrderId);
        result = workOrder2WorkOrderVO(workOrder);
        result.setChats(chatService.getChatsByWorkOrderId(workOrderId));
        return result;
    }

    @Override
    public ArrayList<WorkOrderVO> getAllWorkOrderOfDocter(String lastChat) {
        ArrayList<WorkOrderVO> result = new ArrayList<WorkOrderVO>();
        Iterable<WorkOrder> iterable =  workOrderDao.findByLastChat(lastChat);
        for(WorkOrder workOrder: iterable) {
            WorkOrderVO workOrderVO = workOrder2WorkOrderVO(workOrder);
            result.add(workOrderVO);
        }
        return result;
    }

    private WorkOrderVO workOrder2WorkOrderVO(WorkOrder workOrder) {
        WorkOrderVO workOrderVO =  new WorkOrderVO();
        workOrderVO.setTime(workOrder.getUpdateTime());
        workOrderVO.setPatientId(workOrder.getUserId());
        workOrderVO.setWorkOrderId(workOrder.getId());
        workOrderVO.setDescription(workOrder.getDescription());
        workOrderVO.setLastChat(workOrder.getLastChat());
        return workOrderVO;
    }
}
