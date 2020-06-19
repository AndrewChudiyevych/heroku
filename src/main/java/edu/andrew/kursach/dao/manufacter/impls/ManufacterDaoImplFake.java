package edu.andrew.kursach.dao.manufacter.impls;

import edu.andrew.kursach.dao.manufacter.interfaces.IManufacterDao;
import edu.andrew.kursach.dataSet.DataSet;
import edu.andrew.kursach.model.Manufacter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManufacterDaoImplFake implements IManufacterDao {
    @Autowired
    DataSet dataSet;

    @Override
    public Manufacter save(Manufacter manufacter) {
        dataSet.getManufacters().add(manufacter);
        return manufacter;
    }

    @Override
    public Manufacter get(String id) {
        return null;
    }

    @Override
    public List<Manufacter> getAll() {
        return this.dataSet.getManufacters();
    }

    @Override
    public Manufacter edit(Manufacter manufacter) {
        return null;
    }

    @Override
    public Manufacter delete(String id) {
        return null;
    }
}
