package edu.andrew.kursach.service.medicine.impls;

import edu.andrew.kursach.dao.medicine.impls.MedicineDaoImplFake;
import edu.andrew.kursach.model.Medicine;
import edu.andrew.kursach.service.medicine.interfaces.IMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class MedicineServiceImpl implements IMedicineService {

    @Autowired
    MedicineDaoImplFake dao;

    @PostConstruct
    void init() {
        List<Medicine> list = dao.getAll();
        //repository.saveAll(list);
    }

    @Override
    public Medicine save(Medicine medicine) {
        return null;
    }

    @Override
    public Medicine get(String id) {
        return dao.getAll().stream().filter(item -> item.getId().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public List<Medicine> getAll() {
        return dao.getAll();
    }

    @Override
    public Medicine edit(Medicine medicine) {
        return null;
    }

    @Override
    public Medicine delete(String id) {
        Medicine medicine = this.get(id);
        dao.getAll().remove(medicine);
        return medicine;
    }
}
