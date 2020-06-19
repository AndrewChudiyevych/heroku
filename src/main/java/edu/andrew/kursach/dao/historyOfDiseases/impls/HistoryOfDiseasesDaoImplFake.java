package edu.andrew.kursach.dao.historyOfDiseases.impls;

import edu.andrew.kursach.dao.historyOfDiseases.interfaces.IHistoryOfDiseasesDao;
import edu.andrew.kursach.dataSet.DataSet;
import edu.andrew.kursach.model.HistoryOfDiseases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HistoryOfDiseasesDaoImplFake implements IHistoryOfDiseasesDao {

    @Autowired
    DataSet dataSet;

    @Override
    public HistoryOfDiseases save(HistoryOfDiseases historyOfDiseases) {
        dataSet.getHistoryOfDiseases().add(historyOfDiseases);
        return historyOfDiseases;
    }

    @Override
    public HistoryOfDiseases get(String id) {
        return null;
    }

    @Override
    public List<HistoryOfDiseases> getAll() {
        return this.dataSet.getHistoryOfDiseases();
    }

    @Override
    public HistoryOfDiseases edit(HistoryOfDiseases historyOfDiseases) {
        return null;
    }

    @Override
    public HistoryOfDiseases delete(String id) {
        return null;
    }
}
