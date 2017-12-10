package cn.edu.nju.software.master17.wechatdocter.models;

import lombok.Data;

import javax.persistence.*;

/**
 *
 * @author csc
 * @date 2017/12/8
 */

@Entity
@Data
@Table(name = "photo2chat")
public class Photo2Chat {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "photo_id")
    private Long photoId;

    @Column(name = "chat_id")
    private Long chatId;

    @Column(name = "is_active")
    private Boolean active;

}
