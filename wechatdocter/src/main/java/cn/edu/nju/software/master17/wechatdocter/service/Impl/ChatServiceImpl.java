package cn.edu.nju.software.master17.wechatdocter.service.Impl;

import cn.edu.nju.software.master17.wechatdocter.dao.ChatDao;
import cn.edu.nju.software.master17.wechatdocter.service.ChatService;
import cn.edu.nju.software.master17.wechatdocter.web.data.ChatVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 *
 * @author csc
 * @date 2017/12/7
 */

@Service
public class ChatServiceImpl implements ChatService{
    @Autowired
    private ChatDao chatDao;

    @Override
    public ChatVO addChat2WorkOrder(ChatVO chatVO) {
        return null;
    }

    @Override
    public ArrayList<ChatVO> getChatsByWorkOrderId(Long workOrderId) {
        return null;
    }
}
