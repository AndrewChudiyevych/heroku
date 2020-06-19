package edu.andrew.kursach.controller.web;

import edu.andrew.kursach.form.PatientForm;
import edu.andrew.kursach.form.SearchForm;
import edu.andrew.kursach.model.Patient;
import edu.andrew.kursach.service.patient.impls.PatientServiceMongoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/web/patient")
@CrossOrigin("*")
public class PatientWEBController {

    @Autowired
    PatientServiceMongoImpl service;


    //@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showAll(Model model) {
        List<Patient> list = service.getAll();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("patients", list);
        return "patientList";
    }

    @PostMapping(value = "/list")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Patient> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("patients", list);
        return "patientList";
    }

    @RequestMapping(value = "/list/sorted", method = RequestMethod.GET)
    public String showSorted(Model model) {
        List<Patient> patients = service.getAll();
        List<Patient> sorted = service.sortByFIO(patients);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("patients", sorted);
        return "patientList";
    }

    @RequestMapping(value = "/list/sorted", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Patient> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("patients", list);
        return "patientList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("patients", service.getAll());
        return "redirect:/web/patient/list";
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        PatientForm patientForm = new PatientForm();
        model.addAttribute("patientForm",patientForm);
        return "patientAdd";
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("patientForm") @Valid PatientForm patientForm) {
            Patient patient = new Patient();
            patient.setMedicalHistoryNumber(patientForm.getMedicalHistoryNumber());
            patient.setFIO(patientForm.getFIO());
            patient.setAdress(patientForm.getAdress());
            patient.setPhoneNumber(patientForm.getPhoneNumber());
            service.save(patient);
        model.addAttribute("patients", service.getAll());
        return "redirect:/web/patient/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        Patient patient = service.get(id);
        PatientForm patientForm = new PatientForm();
        patientForm.setMedicalHistoryNumber(patient.getMedicalHistoryNumber());
        patientForm.setFIO(patient.getFIO());
        patientForm.setAdress(patient.getAdress());
        patientForm.setPhoneNumber(patient.getPhoneNumber());
        model.addAttribute("patientForm",patientForm);
        return "patientEdit";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("patientForm") @Valid PatientForm patientForm) {
        Patient patient = new Patient();
        patient.setId(id);
        patient.setMedicalHistoryNumber(patientForm.getMedicalHistoryNumber());
        patient.setFIO(patientForm.getFIO());
        patient.setAdress(patientForm.getAdress());
        patient.setPhoneNumber(patientForm.getPhoneNumber());
        service.save(patient);
        model.addAttribute("patients", service.getAll());
        return "redirect:/web/patient/list";
    }



}
