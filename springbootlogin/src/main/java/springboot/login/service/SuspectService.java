package springboot.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.login.bean.Record;
import springboot.login.bean.Suspect;

import springboot.login.bean.User;
import springboot.login.dao.SuspectDao;

@Service
public class SuspectService {

    @Autowired
    private SuspectDao SuspectDao;

    public Iterable<Suspect> getAll() {
        return SuspectDao.findAll();
    }

    public void addsuspect(Suspect suspect) {
        SuspectDao.save(suspect);
    }

    public void delsuspect(long id) {
        SuspectDao.deleteById(id);
    }

}
