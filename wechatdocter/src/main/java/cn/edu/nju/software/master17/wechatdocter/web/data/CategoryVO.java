package cn.edu.nju.software.master17.wechatdocter.web.data;

import lombok.Data;

import java.util.ArrayList;

@Data
public class CategoryVO {
    private Long id;
    private String nodeName;
    private ArrayList<CategoryVO> children;
}
