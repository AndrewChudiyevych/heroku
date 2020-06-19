package edu.andrew.kursach.dao.historyOfDiseases.interfaces;

import edu.andrew.kursach.model.HistoryOfDiseases;

import java.util.List;

public interface IHistoryOfDiseasesDao {
    HistoryOfDiseases save(HistoryOfDiseases historyOfDiseases);
    HistoryOfDiseases get(String id);
    List<HistoryOfDiseases> getAll();
    HistoryOfDiseases edit(HistoryOfDiseases historyOfDiseases);
    HistoryOfDiseases delete(String id);
}
