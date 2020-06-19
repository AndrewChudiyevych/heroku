package edu.andrew.kursach.controller.api;

import edu.andrew.kursach.model.Medicine;
import edu.andrew.kursach.service.medicine.impls.MedicineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicine")
public class MedicineAPIController {
    @Autowired
    MedicineServiceImpl service;

    @RequestMapping("/list")
    List<Medicine> getAll(){
        return service.getAll();
    }

    @RequestMapping("get/{id}")
    Medicine getById(@PathVariable("id") String id){
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Medicine create (@RequestBody Medicine medicine) {
        return service.save(medicine);
    }

    @RequestMapping("/delete/{id}")
    Medicine delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}
