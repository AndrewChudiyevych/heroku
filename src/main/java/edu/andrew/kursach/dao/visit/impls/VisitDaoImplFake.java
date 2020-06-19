package edu.andrew.kursach.dao.visit.impls;

import edu.andrew.kursach.dao.visit.interfaces.IVisitDaoImplFake;
import edu.andrew.kursach.dataSet.DataSet;
import edu.andrew.kursach.model.Visit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VisitDaoImplFake implements IVisitDaoImplFake {
    @Autowired
    DataSet dataSet;

    @Override
    public Visit save(Visit visit) {
        dataSet.getVisits().add(visit);
        return visit;
    }

    @Override
    public Visit get(String id) {
        return null;
    }

    @Override
    public List<Visit> getAll() {
        return this.dataSet.getVisits();
    }

    @Override
    public Visit edit(Visit visit) {
        return null;
    }

    @Override
    public Visit delete(String id) {
        return null;
    }
}
