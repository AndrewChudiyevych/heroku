package edu.andrew.kursach.service.disease.interfaces;

import edu.andrew.kursach.model.Diseases;

import java.util.List;

public interface IDiseaseService {
    Diseases save(Diseases diseases);
    Diseases get(String id);
    List<Diseases> getAll();
    Diseases edit(Diseases diseases);
    Diseases delete(String id);
}
