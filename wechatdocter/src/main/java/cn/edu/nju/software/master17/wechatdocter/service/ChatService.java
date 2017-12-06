package cn.edu.nju.software.master17.wechatdocter.service;

import cn.edu.nju.software.master17.wechatdocter.web.data.ChatVO;

import java.util.ArrayList;

/**
 *
 * @author csc
 * @date 2017/12/7
 */
public interface ChatService {

    ChatVO addChat2WorkOrder(ChatVO chatVO);
    ArrayList<ChatVO> getChatsByWorkOrderId(Long workOrderId);

}
