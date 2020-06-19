package edu.andrew.kursach.dao.manufacter.interfaces;


import edu.andrew.kursach.model.Manufacter;

import java.util.List;

public interface IManufacterDao {
    Manufacter save(Manufacter manufacter);
    Manufacter get(String id);
    List<Manufacter> getAll();
    Manufacter edit(Manufacter manufacter);
    Manufacter delete(String id);
}
