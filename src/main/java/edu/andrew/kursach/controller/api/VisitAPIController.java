package edu.andrew.kursach.controller.api;


import edu.andrew.kursach.model.Visit;
import edu.andrew.kursach.service.visit.impls.VisitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visit")
public class VisitAPIController {
    @Autowired
    VisitServiceImpl service;

    @RequestMapping("/list")
    List<Visit> getAll(){
        return service.getAll();
    }

    @RequestMapping("get/{id}")
    Visit getById(@PathVariable("id") String id){
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Visit create (@RequestBody Visit visit) {
        return service.save(visit);
    }

    @RequestMapping("/delete/{id}")
    Visit delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}
