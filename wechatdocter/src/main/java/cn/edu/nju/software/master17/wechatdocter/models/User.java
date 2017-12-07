package cn.edu.nju.software.master17.wechatdocter.models;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by csc on 2017/12/8.
 */
@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "sex")
    private boolean sex;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "password")
    private String password;

    @Column(name = "history")
    private String history;

    @Column(name = "openId")
    private String openId;

    @Column(name = "recent")
    private String recent;


}
