package edu.andrew.kursach.controller.api;

import edu.andrew.kursach.model.Doctor;
import edu.andrew.kursach.service.doctor.impls.DoctorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctor")
public class DoctorAPIController {
    @Autowired
    DoctorServiceImpl service;

    @RequestMapping("/list")
    List<Doctor> getAll(){
        return service.getAll();
    }

    @RequestMapping("get/{id}")
    Doctor getById(@PathVariable("id") String id){
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Doctor create (@RequestBody Doctor doctor) {
        return service.save(doctor);
    }

    @RequestMapping("/delete/{id}")
    Doctor delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}
