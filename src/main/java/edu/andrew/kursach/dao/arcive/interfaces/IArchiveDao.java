package edu.andrew.kursach.dao.arcive.interfaces;

import edu.andrew.kursach.model.Archive;

import java.util.List;

public interface IArchiveDao {
    Archive save(Archive archive);
    Archive get(String id);
    List<Archive> getAll();
    Archive edit(Archive archive);
    Archive delete(String id);
}
