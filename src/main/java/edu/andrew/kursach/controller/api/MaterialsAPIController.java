package edu.andrew.kursach.controller.api;

import edu.andrew.kursach.model.Materials;
import edu.andrew.kursach.service.material.impls.MaterialServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/material")
public class MaterialsAPIController {
    @Autowired
    MaterialServiceImpl service;

    @RequestMapping("/list")
    List<Materials> getAll(){
        return service.getAll();
    }

    @RequestMapping("get/{id}")
    Materials getById(@PathVariable("id") String id){
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Materials create (@RequestBody Materials materials) {
        return service.save(materials);
    }

    @RequestMapping("/delete/{id}")
    Materials delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}
