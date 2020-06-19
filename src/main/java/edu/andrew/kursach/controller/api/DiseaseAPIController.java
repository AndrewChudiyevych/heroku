package edu.andrew.kursach.controller.api;


import edu.andrew.kursach.model.Diseases;
import edu.andrew.kursach.service.disease.impls.DiseaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disease")
public class DiseaseAPIController {
    @Autowired
    DiseaseServiceImpl service;

    @RequestMapping("/list")
    List<Diseases> getAll(){
        return service.getAll();
    }


    @RequestMapping("get/{id}")
    Diseases getById(@PathVariable("id") String id){
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Diseases create (@RequestBody Diseases diseases) {
        return service.save(diseases);
    }

    @RequestMapping("/delete/{id}")
    Diseases delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}
