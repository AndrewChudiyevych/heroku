package edu.andrew.kursach.controller.api;

import edu.andrew.kursach.model.Patient;
import edu.andrew.kursach.service.patient.impls.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
public class PatientAPIController {
    @Autowired
    PatientServiceImpl service;

    @RequestMapping("list")
    List<Patient> getAll(){
        return service.getAll();
    }

    @RequestMapping("/get/{id}")
    Patient getById(@PathVariable("id") String id){
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Patient create(@RequestBody Patient patient) {
        return service.save(patient);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    Patient edit(@RequestBody Patient patient) {
        return service.save(patient);
    }

    @RequestMapping("/delete/{id}")
    Patient delete(@PathVariable("id") String id) {
        return service.delete(id);
    }

}
