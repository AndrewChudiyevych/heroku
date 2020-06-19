package edu.andrew.kursach.dao.receiptsOfPoliclinic.impls;

import edu.andrew.kursach.dao.receiptsOfPoliclinic.interfaces.IReceiptsOfPoliclinicDao;
import edu.andrew.kursach.dataSet.DataSet;
import edu.andrew.kursach.model.ReceiptsOfPoliclinic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReceiptsOfPoliclinicDaoImplFake implements IReceiptsOfPoliclinicDao {

    @Autowired
    DataSet dataSet;

    @Override
    public ReceiptsOfPoliclinic save(ReceiptsOfPoliclinic receiptsOfPoliclinic) {
        dataSet.getReceiptsOfPoliclinics().add(receiptsOfPoliclinic);
        return receiptsOfPoliclinic;
    }

    @Override
    public ReceiptsOfPoliclinic get(String id) {
        return null;
    }

    @Override
    public List<ReceiptsOfPoliclinic> getAll() {
        return this.dataSet.getReceiptsOfPoliclinics();
    }

    @Override
    public ReceiptsOfPoliclinic edit(ReceiptsOfPoliclinic receiptsOfPoliclinic) {
        return null;
    }

    @Override
    public ReceiptsOfPoliclinic delete(String id) {
        return null;
    }
}
