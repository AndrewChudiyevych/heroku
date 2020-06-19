package edu.andrew.kursach.dao.receiptsOfDoctors.impls;

import edu.andrew.kursach.dao.receiptsOfDoctors.interfaces.IReceiptsOfDoctorsDao;
import edu.andrew.kursach.dataSet.DataSet;
import edu.andrew.kursach.model.ReceiptsOfDoctors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReceiptsOfDoctorsDaoImplFake implements IReceiptsOfDoctorsDao {

    @Autowired
    DataSet dataSet;

    @Override
    public ReceiptsOfDoctors save(ReceiptsOfDoctors receiptsOfDoctors) {
        dataSet.getReceiptsOfDoctors().add(receiptsOfDoctors);
        return receiptsOfDoctors;
    }

    @Override
    public ReceiptsOfDoctors get(String id) {
        return null;
    }

    @Override
    public List<ReceiptsOfDoctors> getAll() {
        return this.dataSet.getReceiptsOfDoctors();
    }

    @Override
    public ReceiptsOfDoctors edit(ReceiptsOfDoctors receiptsOfDoctors) {
        return null;
    }

    @Override
    public ReceiptsOfDoctors delete(String id) {
        return null;
    }
}
