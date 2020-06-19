package edu.andrew.kursach.service.receiptsOfDoctors.impls;

import edu.andrew.kursach.dao.receiptsOfDoctors.impls.ReceiptsOfDoctorsDaoImplFake;
import edu.andrew.kursach.model.ReceiptsOfDoctors;
import edu.andrew.kursach.service.receiptsOfDoctors.interfaces.IReceiptsOfDoctorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class ReceiptsOfDoctorsServiceImpl implements IReceiptsOfDoctorsService {

    @Autowired
    ReceiptsOfDoctorsDaoImplFake dao;

    @PostConstruct
    void init() {
        List<ReceiptsOfDoctors> list = dao.getAll();
        //repository.saveAll(list);
    }

    @Override
    public ReceiptsOfDoctors save(ReceiptsOfDoctors receiptsOfDoctors) {
        return null;
    }

    @Override
    public ReceiptsOfDoctors get(String id) {
        return dao.getAll().stream().filter(item -> item.getDoctor().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public List<ReceiptsOfDoctors> getAll() {
        return dao.getAll();
    }

    @Override
    public ReceiptsOfDoctors edit(ReceiptsOfDoctors receiptsOfDoctors) {
        return null;
    }

    @Override
    public ReceiptsOfDoctors delete(String id) {
        ReceiptsOfDoctors receiptsOfDoctors = this.get(id);
        dao.getAll().remove(receiptsOfDoctors);
        return receiptsOfDoctors;
    }
}
