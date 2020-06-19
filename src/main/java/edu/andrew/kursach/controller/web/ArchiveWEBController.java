package edu.andrew.kursach.controller.web;

import edu.andrew.kursach.form.ArchiveForm;
import edu.andrew.kursach.form.SearchForm;
import edu.andrew.kursach.model.*;
import edu.andrew.kursach.service.archive.impls.ArchiveServiceMongoImpl;
import edu.andrew.kursach.service.disease.impls.DiseaseServiceMongoImpl;
import edu.andrew.kursach.service.doctor.impls.DoctorServiceMongoImpl;
import edu.andrew.kursach.service.patient.impls.PatientServiceMongoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/archive")
@CrossOrigin("*")
public class ArchiveWEBController {
    @Autowired
    ArchiveServiceMongoImpl service;

    @Autowired
    DoctorServiceMongoImpl doctorServie;

    @Autowired
    PatientServiceMongoImpl patientService;

    @Autowired
    DiseaseServiceMongoImpl diseaseService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showAll(Model model) {
        List<Archive> list = service.getAll();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("archives", list);
        return "archiveList";
    }
    @PostMapping(value = "/list")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Archive> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("archives", list);
        return "archiveList";
    }

    @RequestMapping(value = "/list/sorted", method = RequestMethod.GET)
    public String showSorted(Model model) {
        List<Archive> archives = service.getAll();
        List<Archive> sorted = service.sortByPatientFio(archives);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("archives", sorted);
        return "archiveList";
    }

    @RequestMapping(value = "/list/sorted", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Archive> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("archives", list);
        return "archiveList";
    }



    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("archives", service.getAll());
        return "redirect:/web/archive/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        ArchiveForm archiveForm = new ArchiveForm();

        Map<String, String> doctorMap = doctorServie.getAll().stream()
                .collect(Collectors.toMap(Doctor::getId, Doctor::getFIO));

        Map<String, String> patientMap = patientService.getAll().stream()
                .collect(Collectors.toMap(Patient::getId, Patient::getFIO));

        Map<String, String> diseaseMap = diseaseService.getAll().stream()
                .collect(Collectors.toMap(Diseases::getId, Diseases::getNameOfDisease));

        List<String> doctorList = doctorServie.getAll().stream()
                .map(Doctor::getFIO).collect(Collectors.toList());

        List<String> patientList = patientService.getAll().stream()
                .map(Patient::getFIO).collect(Collectors.toList());

        List<String> diseaseList = diseaseService.getAll().stream()
                .map(Diseases::getNameOfDisease).collect(Collectors.toList());

        model.addAttribute("doctor", doctorMap);
        model.addAttribute("doctorL", doctorList);
        model.addAttribute("patient", patientMap);
        model.addAttribute("patientL", patientList);
        model.addAttribute("disease", diseaseMap);
        model.addAttribute("diseaseL", diseaseList);
        model.addAttribute("archiveForm", archiveForm);
        return "archiveAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("archiveForm") @Valid ArchiveForm archiveForm) {
        Archive archive = new Archive();
        archive.setIdOfHistoryOfDisease(null);
        archive.setBeginningOfTreatment(archiveForm.getBeginningOfTreatment());
        archive.setEndOfTreatment(archiveForm.getEndOfTreatment());
        Doctor doctor = doctorServie.getAll().stream()
                .filter(item -> item.getFIO().equals(archiveForm.getDoctor()) )
                .findFirst().orElse(new Doctor());
        archive.setDoctor(doctor);
        Patient patient = patientService.getAll().stream()
                .filter(item -> item.getFIO().equals(archiveForm.getPatient()) )
                .findFirst().orElse(new Patient());
        archive.setPatient(patient);
        Diseases diseases = diseaseService.getAll().stream()
                .filter(item -> item.getNameOfDisease().equals(archiveForm.getDisease()) )
                .findFirst().orElse(new Diseases());
        archive.setDisease(diseases);
        service.save(archive);
        model.addAttribute("archives", service.getAll());
        return "redirect:/web/archive/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        ArchiveForm archiveForm = new ArchiveForm();
        Archive archive = service.get(id);
        List<String> doctorList = doctorServie.getAll().stream()
                .map(Doctor::getFIO).collect(Collectors.toList());

        List<String> patientList = patientService.getAll().stream()
                .map(Patient::getFIO).collect(Collectors.toList());

        List<String> diseaseList = diseaseService.getAll().stream()
                .map(Diseases::getNameOfDisease).collect(Collectors.toList());

        archiveForm.setBeginningOfTreatment(archive.getBeginningOfTreatment());
        archiveForm.setEndOfTreatment(archive.getEndOfTreatment());
        archiveForm.setDoctor(archive.getDoctor().getFIO());
        archiveForm.setPatient(archive.getPatient().getFIO());
        archiveForm.setPatient(archive.getDisease().getNameOfDisease());


        model.addAttribute("doctorL", doctorList);
        model.addAttribute("patientL", patientList);
        model.addAttribute("diseaseL", diseaseList);
        model.addAttribute("archiveForm", archiveForm);
        return "archiveEdit";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("archiveForm") @Valid ArchiveForm archiveForm) {
        Doctor doctor = doctorServie.getAll().stream()
                .filter(item -> item.getFIO().equals(archiveForm.getDoctor()) )
                .findFirst().orElse(new Doctor());

        Patient patient = patientService.getAll().stream()
                .filter(item -> item.getFIO().equals(archiveForm.getPatient()) )
                .findFirst().orElse(new Patient());

        Diseases diseases = diseaseService.getAll().stream()
                .filter(item -> item.getNameOfDisease().equals(archiveForm.getDisease()) )
                .findFirst().orElse(new Diseases());

        Archive archiveEdited = new Archive();
        archiveEdited.setIdOfHistoryOfDisease(id);
        archiveEdited.setBeginningOfTreatment(archiveForm.getBeginningOfTreatment());
        archiveEdited.setEndOfTreatment(archiveForm.getEndOfTreatment());
        archiveEdited.setDoctor(doctor);
        archiveEdited.setPatient(patient);
        archiveEdited.setDisease(diseases);
        service.edit(archiveEdited);
        model.addAttribute("archives", service.getAll());
        return "redirect:/web/archive/list";
    }


}
