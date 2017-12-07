package cn.edu.nju.software.master17.wechatdocter.web.ctrl;

import cn.edu.nju.software.master17.wechatdocter.models.WorkOrder;
import cn.edu.nju.software.master17.wechatdocter.service.ChatService;
import cn.edu.nju.software.master17.wechatdocter.service.WorkOrderService;
import cn.edu.nju.software.master17.wechatdocter.web.data.ChatVO;
import cn.edu.nju.software.master17.wechatdocter.web.data.WorkOrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.Request;

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
    public ChatVO addChat2WorkOrder() {

        return null;
    }

    @RequestMapping(value = "/message/chat", method = RequestMethod.GET)
    public ArrayList<ChatVO> getChatsOfWorkOrder() {

        return null;
    }

    @RequestMapping(value = "/message/workorder", method = RequestMethod.POST)
    public WorkOrderVO createWorkOrder() {
        return null;
    }

    @RequestMapping(value = "/message/workorder/patient", method = RequestMethod.GET)
    public WorkOrderVO getWorkOrderOfPatient() {
        return null;
    }

    @RequestMapping(value = "message/workorder/docter", method = RequestMethod.GET)
    public ArrayList<WorkOrderVO> getAllWorkOrderOfDocter() {
        return null;
    }








}
