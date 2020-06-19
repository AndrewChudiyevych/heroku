package edu.andrew.kursach.service.disease.impls;

import edu.andrew.kursach.dao.disease.impls.DiseaseDaoImplFake;
import edu.andrew.kursach.model.Diseases;
import edu.andrew.kursach.service.disease.interfaces.IDiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class DiseaseServiceImpl implements IDiseaseService {

    @Autowired
    DiseaseDaoImplFake dao;

    @PostConstruct
    void init() {
        List<Diseases> list = dao.getAll();
        //repository.saveAll(list);
    }

    @Override
    public Diseases save(Diseases diseases) {
        return null;
    }

    @Override
    public Diseases get(String id) {
        return dao.getAll().stream().filter(item -> item.getId().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public List<Diseases> getAll() {
        return dao.getAll();
    }

    @Override
    public Diseases edit(Diseases diseases) {
        return null;
    }

    @Override
    public Diseases delete(String id) {
        Diseases diseases = this.get(id);
        dao.getAll().remove(diseases);
        return diseases;
    }
}
