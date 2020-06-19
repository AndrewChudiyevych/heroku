package edu.andrew.kursach.dao.visitsOfClinic.impls;

import edu.andrew.kursach.dao.visitsOfClinic.interfaces.IVisitsOfClinicDaoImplFake;
import edu.andrew.kursach.dataSet.DataSet;
import edu.andrew.kursach.model.VisitsOfClinic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VisitsOfClinicDaoImplFake implements IVisitsOfClinicDaoImplFake {
    @Autowired
    DataSet dataSet;

    @Override
    public VisitsOfClinic save(VisitsOfClinic visitsOfClinic) {
        dataSet.getVisitsOfClinics().add(visitsOfClinic);
        return visitsOfClinic;
    }

    @Override
    public VisitsOfClinic get(String id) {
        return null;
    }

    @Override
    public List<VisitsOfClinic> getAll() {
        return this.dataSet.getVisitsOfClinics();
    }

    @Override
    public VisitsOfClinic edit(VisitsOfClinic visitsOfClinic) {
        return null;
    }

    @Override
    public VisitsOfClinic delete(String id) {
        return null;
    }
}
