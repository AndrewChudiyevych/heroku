package edu.andrew.kursach.controller.api;

import edu.andrew.kursach.model.Archive;
import edu.andrew.kursach.service.archive.impls.ArchiveServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/archive")
public class ArchiveAPIController {
    @Autowired
    ArchiveServiceImpl service;

    @RequestMapping("/list")
    List<Archive> getAll(){
        return service.getAll();
    }

    @RequestMapping("get/{id}")
    Archive getById(@PathVariable("id") String id){
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Archive create (@RequestBody Archive archive) {
        return service.save(archive);
    }

    @RequestMapping("/delete/{id}")
    Archive delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}
