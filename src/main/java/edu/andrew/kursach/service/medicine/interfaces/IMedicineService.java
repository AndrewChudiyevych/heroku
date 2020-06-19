package edu.andrew.kursach.service.medicine.interfaces;

import edu.andrew.kursach.model.Medicine;

import java.util.List;

public interface IMedicineService {
    Medicine save(Medicine medicine);
    Medicine get(String id);
    List<Medicine> getAll();
    Medicine edit(Medicine medicine);
    Medicine delete(String id);
}
