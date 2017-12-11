package cn.edu.nju.software.master17.wechatdocter.web.data;

import lombok.Data;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author csc
 * @date 2017/12/7
 */
@Data
public class WorkOrderVO {

    private Long workOrderId;
    private ArrayList<ChatVO> chats;
    private Timestamp time;
    private Long patientId;
    private String description;
    private String lastChat;

}
