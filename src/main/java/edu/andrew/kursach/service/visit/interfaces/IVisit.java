package edu.andrew.kursach.service.visit.interfaces;

import edu.andrew.kursach.model.Visit;

import java.util.List;

public interface IVisit {
    Visit save(Visit visit);
    Visit get(String id);
    List<Visit> getAll();
    Visit edit(Visit visit);
    Visit delete(String id);
}
