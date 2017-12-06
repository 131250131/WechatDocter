package cn.edu.nju.software.master17.wechatdocter.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "photo")
public class Photo {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "photo_url")
    private String url;

    @Column(name = "category_id")
    private Long categoryId;
}
