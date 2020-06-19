package edu.andrew.kursach.service.archive.impls;

import edu.andrew.kursach.dao.arcive.impls.ArchiveDaoImplFake;
import edu.andrew.kursach.model.Archive;
import edu.andrew.kursach.service.archive.interfaces.IArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class ArchiveServiceImpl implements IArchiveService {
    @Autowired
    ArchiveDaoImplFake dao;

    @PostConstruct
    void init() {
        List<Archive> list = dao.getAll();
        //repository.saveAll(list);
    }

    @Override
    public Archive save(Archive archive) {
        return null;
    }

    @Override
    public Archive get(String id) {
        return dao.getAll().stream().filter(item -> item.getIdOfHistoryOfDisease().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public List<Archive> getAll() {
        return dao.getAll();
    }

    @Override
    public Archive edit(Archive archive) {
        return null;
    }

    @Override
    public Archive delete(String id) {
        Archive archive = this.get(id);
        dao.getAll().remove(archive);
        return archive;
    }
}
