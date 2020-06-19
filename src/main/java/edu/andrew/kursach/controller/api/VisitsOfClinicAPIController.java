package edu.andrew.kursach.controller.api;

import edu.andrew.kursach.model.VisitsOfClinic;
import edu.andrew.kursach.service.visitsOfClinic.impls.VisitsOfClinicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visitofclinic")
public class VisitsOfClinicAPIController {
    @Autowired
    VisitsOfClinicServiceImpl service;

    @RequestMapping("/list")
    List<VisitsOfClinic> getAll(){
        return service.getAll();
    }

    @RequestMapping("get/{id}")
    VisitsOfClinic getById(@PathVariable("id") String id){
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    VisitsOfClinic create (@RequestBody VisitsOfClinic visitsOfClinic) {
        return service.save(visitsOfClinic);
    }

    @RequestMapping("/delete/{id}")
    VisitsOfClinic delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}
