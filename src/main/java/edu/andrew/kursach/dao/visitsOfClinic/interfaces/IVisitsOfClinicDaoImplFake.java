package edu.andrew.kursach.dao.visitsOfClinic.interfaces;

import edu.andrew.kursach.model.VisitsOfClinic;

import java.util.List;

public interface IVisitsOfClinicDaoImplFake {
    VisitsOfClinic save(VisitsOfClinic visitsOfClinic);
    VisitsOfClinic get(String id);
    List<VisitsOfClinic> getAll();
    VisitsOfClinic edit(VisitsOfClinic visitsOfClinic);
    VisitsOfClinic delete(String id);
}
