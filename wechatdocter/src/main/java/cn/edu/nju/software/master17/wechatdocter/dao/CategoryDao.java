package cn.edu.nju.software.master17.wechatdocter.dao;

import cn.edu.nju.software.master17.wechatdocter.models.Category;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Transactional
public interface CategoryDao extends CrudRepository<Category,Long>{

    ArrayList<Category> findByPid(Long pid);

    Category findById(Long categoryId);
}
