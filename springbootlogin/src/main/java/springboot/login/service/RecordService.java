package springboot.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.login.bean.Record;
import springboot.login.dao.RecordDao;

import java.util.List;

@Service
public class RecordService {

    @Autowired
    private RecordDao RecordDao;

    public Iterable<Record> getAll() {
        return RecordDao.findAll();
    }

    public void addrecord(Record record) {
        RecordDao.save(record);
    }

    public void delrecord(long id) {
        RecordDao.deleteById(id);
    }

}
