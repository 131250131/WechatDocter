package cn.edu.nju.software.master17.wechatdocter.models;

import com.sun.org.glassfish.external.statistics.TimeStatistic;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 *
 * @author csc
 * @date 2017/12/6
 */

@Entity
@Data
@Table(name = "chat")
public class Chat {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name  = "workorder_id")
    private Long workOrderId;

    @Column(name = "description")
    private String description;

    @Column(name = "create_time")
    private Timestamp createTime;

    @Column(name = "sequence_id")
    private Integer sequenceId;

    @Column(name = "type")
    private Integer type;

}
