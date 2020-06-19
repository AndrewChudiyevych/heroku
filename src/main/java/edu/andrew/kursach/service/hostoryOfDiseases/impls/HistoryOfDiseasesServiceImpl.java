package edu.andrew.kursach.service.hostoryOfDiseases.impls;

import edu.andrew.kursach.dao.historyOfDiseases.impls.HistoryOfDiseasesDaoImplFake;
import edu.andrew.kursach.model.HistoryOfDiseases;
import edu.andrew.kursach.service.hostoryOfDiseases.interfaces.IHistoryOfDiseasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class HistoryOfDiseasesServiceImpl implements IHistoryOfDiseasesService {
    @Autowired
    HistoryOfDiseasesDaoImplFake dao;

    @PostConstruct
    void init() {
        List<HistoryOfDiseases> list = dao.getAll();
        //repository.saveAll(list);
    }

    @Override
    public HistoryOfDiseases save(HistoryOfDiseases historyOfDiseases) {
        return null;
    }

    @Override
    public HistoryOfDiseases get(String id) {
        return dao.getAll().stream().filter(item -> item.getIdOfHistoryOfDiseases().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public List<HistoryOfDiseases> getAll() {
        return dao.getAll();
    }

    @Override
    public HistoryOfDiseases edit(HistoryOfDiseases historyOfDiseases) {
        return null;
    }

    @Override
    public HistoryOfDiseases delete(String id) {
        HistoryOfDiseases historyOfDiseases = this.get(id);
        dao.getAll().remove(historyOfDiseases);
        return historyOfDiseases;
    }
}
