package cn.edu.nju.software.master17.wechatdocter.service;

import cn.edu.nju.software.master17.wechatdocter.web.data.CategoryVO;

import java.util.ArrayList;

public interface CategoryService {
    CategoryVO getCategoryById(Long nodeId);

    CategoryVO addCategory(Long pid,String nodeName);

    CategoryVO updateCategory(Long id,String newName);

    CategoryVO deleteCategory(Long id);
}
