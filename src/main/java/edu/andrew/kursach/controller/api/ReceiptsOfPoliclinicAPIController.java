package edu.andrew.kursach.controller.api;

import edu.andrew.kursach.model.ReceiptsOfPoliclinic;
import edu.andrew.kursach.service.receiptsOfPoliclinic.impls.ReceiptsOfPoliclinicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/receiptsofpoliclinic")
public class ReceiptsOfPoliclinicAPIController {
    @Autowired
    ReceiptsOfPoliclinicServiceImpl service;

    @RequestMapping("/list")
    List<ReceiptsOfPoliclinic> getAll(){
        return service.getAll();
    }

    @RequestMapping("get/{id}")
    ReceiptsOfPoliclinic getById(@PathVariable("id") String id){
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    ReceiptsOfPoliclinic create (@RequestBody ReceiptsOfPoliclinic receiptsOfPoliclinic) {
        return service.save(receiptsOfPoliclinic);
    }

    @RequestMapping("/delete/{id}")
    ReceiptsOfPoliclinic delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}
