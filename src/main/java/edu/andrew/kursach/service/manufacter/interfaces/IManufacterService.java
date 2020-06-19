package edu.andrew.kursach.service.manufacter.interfaces;

import edu.andrew.kursach.model.Manufacter;

import java.util.List;

public interface IManufacterService {
    Manufacter save(Manufacter manufacter);
    Manufacter get(String id);
    List<Manufacter> getAll();
    Manufacter edit(Manufacter manufacter);
    Manufacter delete(String id);
}
