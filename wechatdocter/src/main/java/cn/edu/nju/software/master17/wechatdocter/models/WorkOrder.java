package cn.edu.nju.software.master17.wechatdocter.models;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 *
 * @author csc
 * @date 2017/12/7
 */
@Entity
@Data
@Table(name = "workorder")
public class WorkOrder {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "description")
    private String description;

    @Column(name = "create_time")
    private Timestamp createTime;

    @Column(name = "update_time")
    private Timestamp updateTime;

    // 我暂时没有考虑工单的已读未读
    // 表结构方面还差一个照片和工单的关系表

}
