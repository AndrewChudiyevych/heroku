package edu.andrew.kursach.service.archive.interfaces;

import edu.andrew.kursach.model.Archive;

import java.util.List;

public interface IArchiveService {
    Archive save(Archive archive);
    Archive get(String id);
    List<Archive> getAll();
    Archive edit(Archive archive);
    Archive delete(String id);
}
