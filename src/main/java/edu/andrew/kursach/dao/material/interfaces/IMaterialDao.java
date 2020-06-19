package edu.andrew.kursach.dao.material.interfaces;

import edu.andrew.kursach.model.Materials;

import java.util.List;

public interface IMaterialDao {
    Materials save(Materials materials);
    Materials get(String id);
    List<Materials> getAll();
    Materials edit(Materials materials);
    Materials delete(String id);
}
