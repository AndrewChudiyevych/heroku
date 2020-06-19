package edu.andrew.kursach.service.receiptsOfDoctors.interfaces;

import edu.andrew.kursach.model.ReceiptsOfDoctors;

import java.util.List;

public interface IReceiptsOfDoctorsService {
    ReceiptsOfDoctors save(ReceiptsOfDoctors receiptsOfDoctors);
    ReceiptsOfDoctors get(String id);
    List<ReceiptsOfDoctors> getAll();
    ReceiptsOfDoctors edit(ReceiptsOfDoctors receiptsOfDoctors);
    ReceiptsOfDoctors delete(String id);
}
