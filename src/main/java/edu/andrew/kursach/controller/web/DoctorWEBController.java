package edu.andrew.kursach.controller.web;


import edu.andrew.kursach.form.DoctorForm;
import edu.andrew.kursach.form.SearchForm;
import edu.andrew.kursach.model.Doctor;
import edu.andrew.kursach.service.doctor.impls.DoctorServiceMongoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/web/doctor")
@CrossOrigin("*")
public class DoctorWEBController {

    @Autowired
    DoctorServiceMongoImpl service;


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showAll(Model model) {
        List<Doctor> list = service.getAll();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("doctors", list);
        return "doctorList";
    }

    @PostMapping(value = "/list")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Doctor> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("doctors", list);
        return "doctorList";
    }

    @RequestMapping(value = "/list/sorted", method = RequestMethod.GET)
    public String showSorted(Model model) {
        List<Doctor> doctors = service.getAll();
        List<Doctor> sorted = service.sortByFIO(doctors);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("doctors", sorted);
        return "doctorList";
    }

    @RequestMapping(value = "/list/sorted", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Doctor> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("doctors", list);
        return "doctorList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("doctors", service.getAll());
        return "redirect:/web/doctor/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        DoctorForm doctorForm = new DoctorForm();
        model.addAttribute("doctorForm", doctorForm);
        return "doctorAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("doctorForm") @Valid DoctorForm doctorForm) {
        Doctor doctor = new Doctor();
        doctor.setFIO(doctorForm.getFIO());
        doctor.setSpeciality(doctorForm.getSpeciality());
        doctor.setAdress(doctorForm.getAdress());
        doctor.setPhoneNumber(doctorForm.getPhoneNumber());
        doctor.setCostPerSession(doctorForm.getCostPerSession());
        service.save(doctor);
        model.addAttribute("doctors", service.getAll());
        return "redirect:/web/doctor/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        Doctor doctor = service.get(id);
        DoctorForm doctorForm = new DoctorForm();
        doctorForm.setFIO(doctor.getFIO());
        doctorForm.setSpeciality(doctor.getSpeciality());
        doctorForm.setAdress(doctor.getAdress());
        doctorForm.setPhoneNumber(doctor.getPhoneNumber());
        doctorForm.setCostPerSession(doctor.getCostPerSession());
        model.addAttribute("doctorForm", doctorForm);
        return "doctorEdit";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("doctorForm") @Valid DoctorForm doctorForm) {
        Doctor doctor = new Doctor();
        doctor.setId(id);
        doctor.setFIO(doctorForm.getFIO());
        doctor.setSpeciality(doctorForm.getSpeciality());
        doctor.setAdress(doctorForm.getAdress());
        doctor.setPhoneNumber(doctorForm.getPhoneNumber());
        doctor.setCostPerSession(doctorForm.getCostPerSession());
        service.save(doctor);
        model.addAttribute("doctors", service.getAll());
        return "redirect:/web/doctor/list";
    }

}


