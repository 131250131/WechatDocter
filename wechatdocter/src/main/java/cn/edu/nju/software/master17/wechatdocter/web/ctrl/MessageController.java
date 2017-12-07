package cn.edu.nju.software.master17.wechatdocter.web.ctrl;

import cn.edu.nju.software.master17.wechatdocter.service.ChatService;
import cn.edu.nju.software.master17.wechatdocter.service.WorkOrderService;
import cn.edu.nju.software.master17.wechatdocter.web.data.ChatVO;
import cn.edu.nju.software.master17.wechatdocter.web.data.WorkOrderVO;
import cn.edu.nju.software.master17.wechatdocter.web.exception.HttpBadParamsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;

/**
 *
 * @author csc
 * @date 2017/12/7
 */

@RestController
public class MessageController {

    @Autowired
    private WorkOrderService workOrderService;

    @Autowired
    private ChatService chatService;

    @RequestMapping(value = "/message/chat", method = RequestMethod.POST)
    public ChatVO addChat2WorkOrder(@RequestBody @NotNull ChatVO chatVO) {
        ChatVO result = null;
        if(chatVO.getWorkOrderId()!=null) {
           result = this.chatService.addChat2WorkOrder(chatVO);
        }else{
            throw new HttpBadParamsException("workorderId can't be empty");
        }
        return result;
    }

    @RequestMapping(value = "/message/workorder", method = RequestMethod.POST)
    public WorkOrderVO createWorkOrder(@RequestBody @NotNull WorkOrderVO workOrderVO) {
        WorkOrderVO result = null;
        if (workOrderVO.getPatientId()!=null && workOrderVO.getType()!=null) {
            result = workOrderService.newWorkOrder(workOrderVO);
        }else {
            throw new HttpBadParamsException("patientId can't be empty");
        }
        return result;
    }

    @RequestMapping(value = "/message/workorder/{workorderId}", method = RequestMethod.GET)
    public WorkOrderVO getWorkOrderDetail(@PathVariable("workorderId") Long workOrderId) {
        WorkOrderVO result = null;
        if(workOrderId!=null) {
            result = workOrderService.getWorkOrderById(workOrderId);
        }else {
            throw new HttpBadParamsException("workorderId can't be empty");
        }
        return result;
    }

    @RequestMapping(value = "/message/workorders/patient/{patientId}", method = RequestMethod.GET)
    public ArrayList<WorkOrderVO> getWorkOrderOfPatient(@PathVariable("patientId") Long patientId) {
        ArrayList<WorkOrderVO> result = null;
        if(patientId!=null) {
            result = workOrderService.getAllWorkOrderByUserId(patientId);
        }else {
            throw new HttpBadParamsException("patientId can't be empty");
        }
        return result;
    }

    @RequestMapping(value = "message/workorders/docter", method = RequestMethod.GET)
    public ArrayList<WorkOrderVO> getAllWorkOrderOfDocter() {
        ArrayList<WorkOrderVO> result = null;
        result = workOrderService.getAllWorkOrderOfDocter();
        return result;
    }








}
