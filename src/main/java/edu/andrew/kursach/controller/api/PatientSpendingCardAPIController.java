package edu.andrew.kursach.controller.api;

import edu.andrew.kursach.model.PatientSpendingCard;
import edu.andrew.kursach.service.patientSpendingCard.impls.PatientSpendingCardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patientspendingcard")
public class PatientSpendingCardAPIController {
    @Autowired
    PatientSpendingCardServiceImpl service;

    @RequestMapping("/list")
    List<PatientSpendingCard> getAll(){
        return service.getAll();
    }

    @RequestMapping("get/{id}")
    PatientSpendingCard getById(@PathVariable("id") String id){
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    PatientSpendingCard create (@RequestBody PatientSpendingCard patientSpendingCard) {
        return service.save(patientSpendingCard);
    }

    @RequestMapping("/delete/{id}")
    PatientSpendingCard delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}
