package edu.andrew.kursach.dao.disease.impls;

import edu.andrew.kursach.dao.disease.interfaces.IDiseaseDao;
import edu.andrew.kursach.dataSet.DataSet;
import edu.andrew.kursach.model.Diseases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DiseaseDaoImplFake implements IDiseaseDao {

    @Autowired
    DataSet dataSet;

    @Override
    public Diseases save(Diseases diseases) {
        dataSet.getDiseases().add(diseases);
        return diseases;
    }

    @Override
    public Diseases get(String id) {
        return null;
    }

    @Override
    public List<Diseases> getAll() {
        return this.dataSet.getDiseases();
    }

    @Override
    public Diseases edit(Diseases disease) {
        return null;
    }

    @Override
    public Diseases delete(String id) {
        return null;
    }
}
