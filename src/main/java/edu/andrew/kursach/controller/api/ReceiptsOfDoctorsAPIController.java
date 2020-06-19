package edu.andrew.kursach.controller.api;

import edu.andrew.kursach.model.ReceiptsOfDoctors;
import edu.andrew.kursach.service.receiptsOfDoctors.impls.ReceiptsOfDoctorsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/receiptsofdoctors")
public class ReceiptsOfDoctorsAPIController {
    @Autowired
    ReceiptsOfDoctorsServiceImpl service;

    @RequestMapping("/list")
    List<ReceiptsOfDoctors> getAll(){
        return service.getAll();
    }

    @RequestMapping("get/{id}")
    ReceiptsOfDoctors getById(@PathVariable("id") String id){
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    ReceiptsOfDoctors create (@RequestBody ReceiptsOfDoctors receiptsOfDoctors) {
        return service.save(receiptsOfDoctors);
    }

    @RequestMapping("/delete/{id}")
    ReceiptsOfDoctors delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}
