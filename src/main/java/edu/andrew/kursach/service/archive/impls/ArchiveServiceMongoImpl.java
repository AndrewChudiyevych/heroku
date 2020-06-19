package edu.andrew.kursach.service.archive.impls;

import edu.andrew.kursach.dao.repository.ArchiveRepository;
import edu.andrew.kursach.model.Archive;
import edu.andrew.kursach.model.Diseases;
import edu.andrew.kursach.model.Doctor;
import edu.andrew.kursach.model.Patient;
import edu.andrew.kursach.service.archive.interfaces.IArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ArchiveServiceMongoImpl implements IArchiveService {
    @Autowired
    ArchiveRepository repository;

    @PostConstruct
    void init() {
        List<Archive> archives = new ArrayList<>(Arrays.asList(
                new Archive("1","sefs","dadad",
                        (new Doctor("1","dada","assda","sfsfs","afafa",'2')),
                        (new Patient("1", '2', "dadadad", "adadad", "+3242242")),
                        (new Diseases("1", "dsfs", "sadad", "asdad"))),
                new Archive("2","sefs","dadad",
                        (new Doctor("2","dada","assda","sfsfs","afafa",'2')),
                        (new Patient("2", '2', "dadadad", "adadad", "+3242242")),
                        (new Diseases("2", "dsfs", "sadad", "asdad")))
        ));
        repository.saveAll(archives);
    }


    @Override
    public Archive save(Archive archive) {
        return repository.save(archive);
    }

    @Override
    public Archive get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Archive> getAll() {
        return repository.findAll();
    }

    @Override
    public Archive edit(Archive archive) {
        return repository.save(archive);
    }

    @Override
    public Archive delete(String id) {
        Archive archive = this.get(id);
        repository.deleteById(id);
        return archive;
    }

    public List<Archive> search(String word) {
        return this.getAll().stream()
                .filter(archive -> archive.getIdOfHistoryOfDisease()
                        .toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Archive> sortByPatientFio(List<Archive> archives){

        Collections.sort(archives, new ArchiveServiceMongoImpl.ArchivePatientFioComparator());

        return archives;
    }

    private class ArchivePatientFioComparator implements Comparator<Archive> {
        public int compare(Archive a1, Archive a2) {
            return a1.getPatient().getFIO()
                    .compareTo(a2.getPatient().getFIO());
        }
    }

}
