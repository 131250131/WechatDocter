package cn.edu.nju.software.master17.wechatdocter.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "node_name")
    private String nodeName;

    @Column(name = "pid")
    private Long pid;
}
