package edu.andrew.kursach.service.visit.impls;

import edu.andrew.kursach.dao.visit.impls.VisitDaoImplFake;
import edu.andrew.kursach.model.Visit;
import edu.andrew.kursach.service.visit.interfaces.IVisit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class VisitServiceImpl implements IVisit {

    @Autowired
    VisitDaoImplFake dao;

    @PostConstruct
    void init() {
        List<Visit> list = dao.getAll();
        //repository.saveAll(list);
    }

    @Override
    public Visit save(Visit visit) {
        return null;
    }

    @Override
    public Visit get(String id) {
        return dao.getAll().stream().filter(item -> item.getId().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public List<Visit> getAll() {
        return dao.getAll();
    }

    @Override
    public Visit edit(Visit visit) {
        return null;
    }

    @Override
    public Visit delete(String id) {
        Visit visit = this.get(id);
        dao.getAll().remove(visit);
        return visit;
    }
}
