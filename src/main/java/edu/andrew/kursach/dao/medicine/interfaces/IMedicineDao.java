package edu.andrew.kursach.dao.medicine.interfaces;

import edu.andrew.kursach.model.Medicine;

import java.util.List;

public interface IMedicineDao {
    Medicine save(Medicine medicine);
    Medicine get(String id);
    List<Medicine> getAll();
    Medicine edit(Medicine medicine);
    Medicine delete(String id);
}
