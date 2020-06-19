package edu.andrew.kursach.controller.web;

import edu.andrew.kursach.form.SearchForm;
import edu.andrew.kursach.form.VisitForm;
import edu.andrew.kursach.model.*;
import edu.andrew.kursach.service.doctor.impls.DoctorServiceMongoImpl;
import edu.andrew.kursach.service.patient.impls.PatientServiceMongoImpl;
import edu.andrew.kursach.service.visit.impls.VisitServiceMongoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/visit")
@CrossOrigin("*")
public class VisitWEBController {
    @Autowired
    VisitServiceMongoImpl service;

    @Autowired
    PatientServiceMongoImpl patientService;

    @Autowired
    DoctorServiceMongoImpl doctorService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showAll(Model model) {
        List<Visit> list = service.getAll();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("visits", list);
        return "visitList";
    }
    @PostMapping(value = "/list")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Visit> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("visits", list);
        return "visitList";
    }

    @RequestMapping(value = "/list/sorted", method = RequestMethod.GET)
    public String showSorted(Model model) {
        List<Visit> visits = service.getAll();
        List<Visit> sorted = service.sortByPatient(visits);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("visits", sorted);
        return "visitList";
    }

    @RequestMapping(value = "/list/sorted", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Visit> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("visits", list);
        return "visitList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("visits", service.getAll());
        return "redirect:/web/visit/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        VisitForm visitForm = new VisitForm();

        Map<String, String> patientMap = patientService.getAll().stream()
                .collect(Collectors.toMap(Patient::getId, Patient::getFIO));

        Map<String, String> doctorMap = doctorService.getAll().stream()
                .collect(Collectors.toMap(Doctor::getId, Doctor::getFIO));

        List<String> mpatientList = patientService.getAll().stream()
                .map(Patient::getFIO).collect(Collectors.toList());

        List<String> doctorList = doctorService.getAll().stream()
                .map(Doctor::getFIO).collect(Collectors.toList());

        model.addAttribute("patient", patientMap);
        model.addAttribute("patientL", mpatientList);
        model.addAttribute("doctor", doctorMap);
        model.addAttribute("doctorL", doctorList);
        model.addAttribute("visitForm", visitForm);
        return "visitAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("visitForm") @Valid VisitForm visitForm) {
        Visit visit = new Visit();
        visit.setId(null);
        Patient patient = patientService.getAll().stream()
                .filter(item -> item.getFIO().equals(visitForm.getPatient()) )
                .findFirst().orElse(new Patient());
        visit.setPatient(patient);
        Doctor doctor = doctorService.getAll().stream()
                .filter(item -> item.getFIO().equals(visitForm.getDoctor()) )
                .findFirst().orElse(new Doctor());
        visit.setDoctor(doctor);
        visit.setFirstOrSecondVisit(visitForm.getFirstOrSecondVisit());
        visit.setAnamnez(visitForm.getAnamnez());
        visit.setDiagnoz(visitForm.getDiagnoz());
        visit.setTreatment(visitForm.getTreatment());
        visit.setCostOfSpendedMedicine(visitForm.getCostOfSpendedMedicine());
        visit.setCostOfSpendedMaterials(visitForm.getCostOfSpendedMaterials());
        visit.setCostOfServices(visitForm.getCostOfServices());
        service.save(visit);
        model.addAttribute("visits", service.getAll());
        return "redirect:/web/visit/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        VisitForm visitForm = new VisitForm();
        Visit visit = service.get(id);
        List<String> patientList = patientService.getAll().stream()
                .map(Patient::getFIO).collect(Collectors.toList());

        List<String> doctorList = doctorService.getAll().stream()
                .map(Doctor::getFIO).collect(Collectors.toList());

        visitForm.setPatient(visit.getPatient().getFIO());
        visitForm.setDoctor(visit.getDoctor().getFIO());
        visitForm.setFirstOrSecondVisit(visit.getFirstOrSecondVisit());
        visitForm.setAnamnez(visit.getAnamnez());
        visitForm.setDiagnoz(visit.getDiagnoz());
        visitForm.setTreatment(visit.getTreatment());
        visitForm.setCostOfSpendedMedicine(visit.getCostOfSpendedMedicine());
        visitForm.setCostOfSpendedMaterials(visit.getCostOfSpendedMaterials());
        visitForm.setCostOfServices(visit.getCostOfServices());

        model.addAttribute("patientL",patientList);
        model.addAttribute("doctorL", doctorList);
        model.addAttribute("visitForm", visitForm);
        return "visitEdit";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("visitForm") @Valid VisitForm visitForm) {

        Patient patient = patientService.getAll().stream()
                .filter(item -> item.getFIO().equals(visitForm.getPatient()) )
                .findFirst().orElse(new Patient());

        Doctor doctor = doctorService.getAll().stream()
                .filter(item -> item.getFIO().equals(visitForm.getDoctor()) )
                .findFirst().orElse(new Doctor());

        Visit visitEdited = new Visit();
        visitEdited.setId(id);
        visitEdited.setPatient(patient);
        visitEdited.setDoctor(doctor);
        visitEdited.setFirstOrSecondVisit(visitForm.getFirstOrSecondVisit());
        visitEdited.setAnamnez(visitForm.getAnamnez());
        visitEdited.setDiagnoz(visitForm.getDiagnoz());
        visitEdited.setTreatment(visitForm.getTreatment());
        visitEdited.setCostOfSpendedMedicine(visitForm.getCostOfSpendedMedicine());
        visitEdited.setCostOfSpendedMaterials(visitForm.getCostOfSpendedMaterials());
        visitEdited.setCostOfServices(visitForm.getCostOfServices());
        service.edit(visitEdited);
        model.addAttribute("visits", service.getAll());
        return "redirect:/web/visit/list";
    }

}
