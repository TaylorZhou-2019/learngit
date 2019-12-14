package springboot.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.login.bean.DangerList;
import springboot.login.bean.DangerList;
import springboot.login.dao.DangerListDao;

import java.util.Optional;

@Service
public class DangerListService {

    @Autowired
    private DangerListDao DangerListDao;

    public Iterable<DangerList> getAll() {
        return DangerListDao.findAll();
    }

    public void adddanger(DangerList danger) {
        DangerListDao.save(danger);
    }

    public void deldanger(long id) {
        DangerListDao.deleteById(id);
    }

}
