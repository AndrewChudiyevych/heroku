package edu.andrew.kursach.controller.api;


import edu.andrew.kursach.model.HistoryOfDiseases;
import edu.andrew.kursach.service.hostoryOfDiseases.impls.HistoryOfDiseasesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historyofdiseases")
public class HistoryOfDiseasesAPIController {
    @Autowired
    HistoryOfDiseasesServiceImpl service;

    @RequestMapping("/list")
    List<HistoryOfDiseases> getAll(){
        return service.getAll();
    }

    @RequestMapping("get/{id}")
    HistoryOfDiseases getById(@PathVariable("id") String id){
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    HistoryOfDiseases create (@RequestBody HistoryOfDiseases historyOfDiseases) {
        return service.save(historyOfDiseases);
    }

    @RequestMapping("/delete/{id}")
    HistoryOfDiseases delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}
