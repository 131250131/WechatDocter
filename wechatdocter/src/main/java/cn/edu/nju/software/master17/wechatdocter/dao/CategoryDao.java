package cn.edu.nju.software.master17.wechatdocter.dao;

import cn.edu.nju.software.master17.wechatdocter.models.Category;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface CategoryDao extends CrudRepository<Category,Long>{

    List<Category> findByPid(Long pid);
}
