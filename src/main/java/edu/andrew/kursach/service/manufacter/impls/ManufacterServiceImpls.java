package edu.andrew.kursach.service.manufacter.impls;

import edu.andrew.kursach.dao.manufacter.impls.ManufacterDaoImplFake;
import edu.andrew.kursach.model.Manufacter;
import edu.andrew.kursach.service.manufacter.interfaces.IManufacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class ManufacterServiceImpls implements IManufacterService {

    @Autowired
    ManufacterDaoImplFake dao;

    @PostConstruct
    void init() {
        List<Manufacter> list = dao.getAll();
        //repository.saveAll(list);
    }

    @Override
    public Manufacter save(Manufacter manufacter) {
        return null;
    }

    @Override
    public Manufacter get(String id) {
        return dao.getAll().stream().filter(item -> item.getId().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public List<Manufacter> getAll() {
        return dao.getAll();
    }

    @Override
    public Manufacter edit(Manufacter manufacter) {
        return null;
    }

    @Override
    public Manufacter delete(String id) {
        Manufacter manufacter = this.get(id);
        dao.getAll().remove(manufacter);
        return manufacter;
    }
}
