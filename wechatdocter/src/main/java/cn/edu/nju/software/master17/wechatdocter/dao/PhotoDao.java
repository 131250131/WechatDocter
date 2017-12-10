package cn.edu.nju.software.master17.wechatdocter.dao;

import cn.edu.nju.software.master17.wechatdocter.models.Photo;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface PhotoDao extends CrudRepository<Photo,Long> {

    Photo findById(Long id);

}
