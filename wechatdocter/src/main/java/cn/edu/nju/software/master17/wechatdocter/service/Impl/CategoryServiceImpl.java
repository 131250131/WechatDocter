package cn.edu.nju.software.master17.wechatdocter.service.Impl;

import cn.edu.nju.software.master17.wechatdocter.dao.CategoryDao;
import cn.edu.nju.software.master17.wechatdocter.models.Category;
import cn.edu.nju.software.master17.wechatdocter.service.CategoryService;
import cn.edu.nju.software.master17.wechatdocter.web.data.CategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;


@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public CategoryVO getCategoryById(Long nodeId) {
        Category categoryRoot = categoryDao.findById(nodeId);
        return wrap(categoryRoot);
    }

    @Override
    public CategoryVO addCategory(Long pid, String nodeName) {
        Category category = new Category();
        category.setPid(pid);
        category.setNodeName(nodeName);
        return wrap(categoryDao.save(category));
    }

    @Override
    public CategoryVO updateCategory(Long id, String newName) {
        Category category = categoryDao.findById(id);
        category.setNodeName(newName);
        return wrap(categoryDao.save(category));
    }

    @Override
    public CategoryVO deleteCategory(Long id) {
        Category category = categoryDao.findById(id);
        ArrayList<Category> categories = categoryDao.findByPid(id);
        if(categories != null && categories.size() != 0) {
            throw new IllegalArgumentException("该分类下有子分类，无法删除");
        }
        categoryDao.delete(id);
        return wrap(category);
    }

    private CategoryVO wrap(Category category){
        CategoryVO categoryVO = new CategoryVO();
        categoryVO.setId(category.getId());
        categoryVO.setNodeName(category.getNodeName());
        ArrayList<Category> categories = categoryDao.findByPid(category.getId());
        if(categories == null){
            categoryVO.setChildren(null);
        }else {
            ArrayList<CategoryVO> categoryVOS = new ArrayList<>();
            categories.forEach(ca -> {
                categoryVOS.add(wrap(ca));
            });
            categoryVO.setChildren(categoryVOS);
        }
        return categoryVO;
    }
}
