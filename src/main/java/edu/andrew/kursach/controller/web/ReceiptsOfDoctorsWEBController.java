package edu.andrew.kursach.controller.web;

import edu.andrew.kursach.form.ReceiptsOfDoctorsForm;
import edu.andrew.kursach.form.SearchForm;
import edu.andrew.kursach.model.*;
import edu.andrew.kursach.service.doctor.impls.DoctorServiceMongoImpl;
import edu.andrew.kursach.service.receiptsOfDoctors.impls.ReceiptsOfDoctorsServiceMongoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/receiptsofdoctors")
@CrossOrigin("*")
public class ReceiptsOfDoctorsWEBController {
    @Autowired
    ReceiptsOfDoctorsServiceMongoImpl service;

    @Autowired
    DoctorServiceMongoImpl doctorService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showAll(Model model) {
        List<ReceiptsOfDoctors> list = service.getAll();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("receiptsofdoctors", list);
        return "receiptofdoctorList";
    }
    @PostMapping(value = "/list")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<ReceiptsOfDoctors> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("receiptsofdoctors", list);
        return "receiptofdoctorList";
    }

    @RequestMapping(value = "/list/sorted", method = RequestMethod.GET)
    public String showSorted(Model model) {
        List<ReceiptsOfDoctors> receiptsOfDoctors = service.getAll();
        List<ReceiptsOfDoctors> sorted = service.sortByDoctorFIO(receiptsOfDoctors);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("receiptsofdoctors", sorted);
        return "receiptofdoctorList";
    }

    @RequestMapping(value = "/list/sorted", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<ReceiptsOfDoctors> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("receiptsofdoctors", list);
        return "receiptofdoctorList";
    }

    @RequestMapping("/delete/{doctor}")
    String delete(Model model,
                  @PathVariable("doctor") String id) {
        service.delete(id);
        model.addAttribute("receiptsofdoctors", service.getAll());
        return "redirect:/web/receiptsofdoctors/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        ReceiptsOfDoctorsForm receiptsOfDoctorsForm = new ReceiptsOfDoctorsForm();

        Map<String, String> doctorMap = doctorService.getAll().stream()
                .collect(Collectors.toMap(Doctor::getId, Doctor::getFIO));

        List<String> doctorList = doctorService.getAll().stream()
                .map(Doctor::getFIO).collect(Collectors.toList());

        model.addAttribute("doctor", doctorMap);
        model.addAttribute("doctorL", doctorList);
        model.addAttribute("receiptsOfDoctorsForm", receiptsOfDoctorsForm);
        return "receiptOfDoctorAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("receiptsOfDoctorsForm") @Valid ReceiptsOfDoctorsForm receiptsOfDoctorsForm) {
        ReceiptsOfDoctors receiptsOfDoctors = new ReceiptsOfDoctors();
        receiptsOfDoctors.setId(null);
        Doctor doctor = doctorService.getAll().stream()
                .filter(item -> item.getFIO().equals(receiptsOfDoctorsForm.getDoctor()) )
                .findFirst().orElse(new Doctor());
        receiptsOfDoctors.setDoctor(doctor);
        receiptsOfDoctors.setInADay(receiptsOfDoctorsForm.getInADay());
        receiptsOfDoctors.setInAMounth(receiptsOfDoctorsForm.getInAMounth());
        receiptsOfDoctors.setDay(receiptsOfDoctorsForm.getDay());
        receiptsOfDoctors.setMonth(receiptsOfDoctorsForm.getMonth());
        service.save(receiptsOfDoctors);
        model.addAttribute("receiptsofdoctors", service.getAll());
        return "redirect:/web/receiptsofdoctors/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        ReceiptsOfDoctorsForm receiptsOfDoctorsForm = new ReceiptsOfDoctorsForm();
        ReceiptsOfDoctors receiptsOfDoctors = service.get(id);
        List<String> doctorList = doctorService.getAll().stream()
                .map(Doctor::getFIO).collect(Collectors.toList());

        receiptsOfDoctorsForm.setDoctor(receiptsOfDoctors.getDoctor().getFIO());
        receiptsOfDoctorsForm.setInADay(receiptsOfDoctors.getInADay());
        receiptsOfDoctorsForm.setInAMounth(receiptsOfDoctors.getInAMounth());
        receiptsOfDoctorsForm.setDay(receiptsOfDoctors.getDay());
        receiptsOfDoctorsForm.setMonth(receiptsOfDoctors.getMonth());

        model.addAttribute("doctorL", doctorList);
        model.addAttribute("receiptsOfDoctorsForm", receiptsOfDoctorsForm);
        return "receiptOfDoctorEdit";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("receiptsOfDoctorsForm") @Valid ReceiptsOfDoctorsForm receiptsOfDoctorsForm) {

        Doctor doctor = doctorService.getAll().stream()
                .filter(item -> item.getFIO().equals(receiptsOfDoctorsForm.getDoctor()) )
                .findFirst().orElse(new Doctor());

        ReceiptsOfDoctors receiptsOfDoctorsEdited = new ReceiptsOfDoctors();
        receiptsOfDoctorsEdited.setId(id);
        receiptsOfDoctorsEdited.setDoctor(doctor);
        receiptsOfDoctorsEdited.setInADay(receiptsOfDoctorsForm.getInADay());
        receiptsOfDoctorsEdited.setInAMounth(receiptsOfDoctorsForm.getInAMounth());
        receiptsOfDoctorsEdited.setDay(receiptsOfDoctorsForm.getDay());
        receiptsOfDoctorsEdited.setMonth(receiptsOfDoctorsForm.getMonth());
        service.edit(receiptsOfDoctorsEdited);
        model.addAttribute("receiptsofdoctors", service.getAll());
        return "redirect:/web/receiptsofdoctors/list";
    }

}
