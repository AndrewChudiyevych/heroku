package edu.andrew.kursach.dao.disease.interfaces;

import edu.andrew.kursach.model.Diseases;

import java.util.List;

public interface IDiseaseDao {
    Diseases save(Diseases disease);
    Diseases get(String id);
    List<Diseases> getAll();
    Diseases edit(Diseases disease);
    Diseases delete(String id);
}
