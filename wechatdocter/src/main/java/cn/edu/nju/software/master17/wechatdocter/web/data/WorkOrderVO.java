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
    private String description;
    private Integer type;
    private ArrayList<PhotoVO> photos;
    private Timestamp time;
    private Long userId;

}
