package edu.andrew.kursach.dao.receiptsOfPoliclinic.interfaces;

import edu.andrew.kursach.model.ReceiptsOfDoctors;
import edu.andrew.kursach.model.ReceiptsOfPoliclinic;

import java.util.List;

public interface IReceiptsOfPoliclinicDao {
    ReceiptsOfPoliclinic save(ReceiptsOfPoliclinic receiptsOfPoliclinic);
    ReceiptsOfPoliclinic get(String id);
    List<ReceiptsOfPoliclinic> getAll();
    ReceiptsOfPoliclinic edit(ReceiptsOfPoliclinic receiptsOfPoliclinic);
    ReceiptsOfPoliclinic delete(String id);
}
