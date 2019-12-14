package springboot.login.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springboot.login.bean.Record;

import java.util.List;

@Repository
public interface RecordDao extends CrudRepository<Record , Long> {

  public List<Record> findByUsername(String name);

}
