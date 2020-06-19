package edu.andrew.kursach.service.receiptsOfPoliclinic.impls;

import edu.andrew.kursach.dao.receiptsOfPoliclinic.impls.ReceiptsOfPoliclinicDaoImplFake;
import edu.andrew.kursach.model.ReceiptsOfPoliclinic;
import edu.andrew.kursach.service.receiptsOfPoliclinic.interfaces.IReceiptsOfPoliclinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class ReceiptsOfPoliclinicServiceImpl implements IReceiptsOfPoliclinicService {

    @Autowired
    ReceiptsOfPoliclinicDaoImplFake dao;

    @PostConstruct
    void init() {
        List<ReceiptsOfPoliclinic> list = dao.getAll();
        //repository.saveAll(list);
    }
    @Override
    public ReceiptsOfPoliclinic save(ReceiptsOfPoliclinic receiptsOfPoliclinic) {
        return null;
    }

    @Override
    public ReceiptsOfPoliclinic get(String id) {
        return dao.getAll().stream().filter(item -> item.getId().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public List<ReceiptsOfPoliclinic> getAll() {
        return dao.getAll();
    }

    @Override
    public ReceiptsOfPoliclinic edit(ReceiptsOfPoliclinic receiptsOfPoliclinic) {
        return null;
    }

    @Override
    public ReceiptsOfPoliclinic delete(String id) {
        ReceiptsOfPoliclinic receiptsOfPoliclinic = this.get(id);
        dao.getAll().remove(receiptsOfPoliclinic);
        return receiptsOfPoliclinic;
    }
}
