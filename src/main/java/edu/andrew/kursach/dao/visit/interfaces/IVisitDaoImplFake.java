package edu.andrew.kursach.dao.visit.interfaces;

import edu.andrew.kursach.model.Visit;

import java.util.List;

public interface IVisitDaoImplFake {
    Visit save(Visit visit);
    Visit get(String id);
    List<Visit> getAll();
    Visit edit(Visit visit);
    Visit delete(String id);
}
