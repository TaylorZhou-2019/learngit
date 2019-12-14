package springboot.login.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springboot.login.bean.Suspect;

@Repository
public interface SuspectDao extends CrudRepository<Suspect , Long> {

}
