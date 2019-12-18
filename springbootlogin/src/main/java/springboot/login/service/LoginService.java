package springboot.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.login.dao.LoginDao;
import springboot.login.bean.User;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    private LoginDao loginDao;

    public int verifyLogin(User user) {

        List<User> userList = loginDao.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (userList.size() > 0)
            return userList.get(0).gettypes();
        else {
            return -1;
        }
    }


    public User findUser(User user) {

        List<User> userList = loginDao.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (userList.size() > 0)
            return userList.get(0);
        else {
            return new User();
        }
    }

    public void adduser(User user) {
        loginDao.save(user);
    }

    public void deluser(long id) {
        loginDao.deleteById(id);
    }

    public void upduser(User user) {
        User upUser = user;
//        upUser.setUsername(user.getUsername());
//        upUser.setPassword(user.getPassword());
//        upUser.settypes(user.gettypes());
        loginDao.save(upUser);
    }

    public Iterable<User> getAll() {
        return loginDao.findAll();
    }


}
