package edu.andrew.kursach.service.visitsOfClinic.impls;

import edu.andrew.kursach.dao.visitsOfClinic.impls.VisitsOfClinicDaoImplFake;
import edu.andrew.kursach.model.VisitsOfClinic;
import edu.andrew.kursach.service.visitsOfClinic.interfaces.IVisitsOfClinic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class VisitsOfClinicServiceImpl implements IVisitsOfClinic {

    @Autowired
    VisitsOfClinicDaoImplFake dao;

    @PostConstruct
    void init() {
        List<VisitsOfClinic> list = dao.getAll();
        //repository.saveAll(list);
    }

    @Override
    public VisitsOfClinic save(VisitsOfClinic visitsOfClinic) {
        return null;
    }

    @Override
    public VisitsOfClinic get(String id) {
        return dao.getAll().stream().filter(item -> item.getId().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public List<VisitsOfClinic> getAll() {
        return dao.getAll();
    }

    @Override
    public VisitsOfClinic edit(VisitsOfClinic visitsOfClinic) {
        return null;
    }

    @Override
    public VisitsOfClinic delete(String id) {
        VisitsOfClinic visitsOfClinic = this.get(id);
        dao.getAll().remove(visitsOfClinic);
        return visitsOfClinic;
    }
}
