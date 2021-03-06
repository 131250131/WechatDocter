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
public class ChatVO {
    private String description;
    private Long chatId;
    private Long workOrderId;
    private Long patientId;
    private Integer sequenceId;
    private ArrayList<PhotoVO> photos = new ArrayList<>();
    private Timestamp time;
    private String type;
}
