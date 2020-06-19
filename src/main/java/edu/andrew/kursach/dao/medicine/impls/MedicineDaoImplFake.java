package edu.andrew.kursach.dao.medicine.impls;

import edu.andrew.kursach.dao.medicine.interfaces.IMedicineDao;
import edu.andrew.kursach.dataSet.DataSet;
import edu.andrew.kursach.model.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MedicineDaoImplFake implements IMedicineDao {
    @Autowired
    DataSet dataSet;

    @Override
    public Medicine save(Medicine medicine) {
        dataSet.getMedicines().add(medicine);
        return medicine;
    }

    @Override
    public Medicine get(String id) {
        return null;
    }

    @Override
    public List<Medicine> getAll() {
        return this.dataSet.getMedicines();
    }

    @Override
    public Medicine edit(Medicine medicine) {
        return null;
    }

    @Override
    public Medicine delete(String id) {
        return null;
    }
}
