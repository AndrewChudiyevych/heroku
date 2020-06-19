package edu.andrew.kursach.controller.api;

import edu.andrew.kursach.model.Manufacter;
import edu.andrew.kursach.service.manufacter.impls.ManufacterServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/manufacter")
public class ManufacterAPIController {
    @Autowired
    ManufacterServiceImpls service;

    @RequestMapping("/list")
    List<Manufacter> getAll(){
        return service.getAll();
    }

    @RequestMapping("get/{id}")
    Manufacter getById(@PathVariable("id") String id){
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Manufacter create (@RequestBody Manufacter manufacter) {
        return service.save(manufacter);
    }

    @RequestMapping("/delete/{id}")
    Manufacter delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}
