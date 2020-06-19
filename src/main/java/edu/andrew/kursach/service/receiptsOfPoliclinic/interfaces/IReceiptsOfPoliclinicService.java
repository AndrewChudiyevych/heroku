package edu.andrew.kursach.service.receiptsOfPoliclinic.interfaces;

import edu.andrew.kursach.model.ReceiptsOfPoliclinic;

import java.util.List;

public interface IReceiptsOfPoliclinicService {
    ReceiptsOfPoliclinic save(ReceiptsOfPoliclinic receiptsOfPoliclinic);
    ReceiptsOfPoliclinic get(String id);
    List<ReceiptsOfPoliclinic> getAll();
    ReceiptsOfPoliclinic edit(ReceiptsOfPoliclinic receiptsOfPoliclinic);
    ReceiptsOfPoliclinic delete(String id);
}
