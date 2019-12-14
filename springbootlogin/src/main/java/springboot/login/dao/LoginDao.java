package springboot.login.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springboot.login.bean.User;
import java.util.List;

@Repository
public interface LoginDao extends CrudRepository<User , Long> {

  public List<User> findByUsernameAndPassword(String name,String password);

}
