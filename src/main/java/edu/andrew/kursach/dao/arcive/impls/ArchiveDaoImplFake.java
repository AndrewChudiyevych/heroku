package edu.andrew.kursach.dao.arcive.impls;

import edu.andrew.kursach.dao.arcive.interfaces.IArchiveDao;
import edu.andrew.kursach.dataSet.DataSet;
import edu.andrew.kursach.model.Archive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArchiveDaoImplFake implements IArchiveDao {

    @Autowired
    DataSet dataSet;

    @Override
    public Archive save(Archive archive) {
        dataSet.getArchives().add(archive);
        return archive;
    }

    @Override
    public Archive get(String id) {
        return null;
    }

    @Override
    public List<Archive> getAll() {
        return this.dataSet.getArchives();
    }

    @Override
    public Archive edit(Archive archive) {
        return null;
    }

    @Override
    public Archive delete(String id) {
        return null;
    }
}
