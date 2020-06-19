package edu.andrew.kursach.service.material.impls;

import edu.andrew.kursach.dao.material.impls.MaterialDaoImplFake;
import edu.andrew.kursach.model.Materials;
import edu.andrew.kursach.service.material.interfaces.IMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class MaterialServiceImpl implements IMaterialService {
    @Autowired
    MaterialDaoImplFake dao;

    @PostConstruct
    void init() {
        List<Materials> list = dao.getAll();
        //repository.saveAll(list);
    }
    @Override
    public Materials save(Materials materials) {
        return null;
    }

    @Override
    public Materials get(String id) {
        return dao.getAll().stream().filter(item -> item.getId().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public List<Materials> getAll() {
        return dao.getAll();
    }

    @Override
    public Materials edit(Materials materials) {
        return null;
    }

    @Override
    public Materials delete(String id) {
        Materials materials = this.get(id);
        dao.getAll().remove(materials);
        return materials;
    }
}
