package springboot.login.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springboot.login.bean.DangerList;

import java.util.List;

@Repository
public interface DangerListDao extends CrudRepository<DangerList , Long> {

  public List<DangerList> findByUsername(String name);

}
