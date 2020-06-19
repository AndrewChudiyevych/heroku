package edu.andrew.kursach.service.hostoryOfDiseases.interfaces;

import edu.andrew.kursach.model.HistoryOfDiseases;

import java.util.List;

public interface IHistoryOfDiseasesService {
    HistoryOfDiseases save(HistoryOfDiseases historyOfDiseases);
    HistoryOfDiseases get(String id);
    List<HistoryOfDiseases> getAll();
    HistoryOfDiseases edit(HistoryOfDiseases historyOfDiseases);
    HistoryOfDiseases delete(String id);
}
