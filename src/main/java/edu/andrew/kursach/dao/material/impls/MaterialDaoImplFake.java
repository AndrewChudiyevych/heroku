package edu.andrew.kursach.dao.material.impls;

import edu.andrew.kursach.dao.material.interfaces.IMaterialDao;
import edu.andrew.kursach.dataSet.DataSet;
import edu.andrew.kursach.model.Materials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MaterialDaoImplFake implements IMaterialDao {
    @Autowired
    DataSet dataSet;

    @Override
    public Materials save(Materials materials) {
        dataSet.getMaterials().add(materials);
        return materials;
    }

    @Override
    public Materials get(String id) {
        return null;
    }

    @Override
    public List<Materials> getAll() {
        return this.dataSet.getMaterials();
    }

    @Override
    public Materials edit(Materials materials) {
        return null;
    }

    @Override
    public Materials delete(String id) {
        return null;
    }
}
