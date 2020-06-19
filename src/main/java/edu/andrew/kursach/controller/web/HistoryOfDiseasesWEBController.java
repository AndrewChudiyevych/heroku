package edu.andrew.kursach.controller.web;

import edu.andrew.kursach.form.HistoryOfDiseasesForm;
import edu.andrew.kursach.form.SearchForm;
import edu.andrew.kursach.model.*;
import edu.andrew.kursach.service.disease.impls.DiseaseServiceMongoImpl;
import edu.andrew.kursach.service.doctor.impls.DoctorServiceMongoImpl;
import edu.andrew.kursach.service.hostoryOfDiseases.impls.HistoryOfDiseasesServiceMongoImpl;
import edu.andrew.kursach.service.patient.impls.PatientServiceMongoImpl;
import edu.andrew.kursach.service.patientSpendingCard.impls.PatientSpendingCardServiceMongoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/historyofdiseases")
@CrossOrigin("*")
public class HistoryOfDiseasesWEBController {
    @Autowired
    HistoryOfDiseasesServiceMongoImpl service;

    @Autowired
    DiseaseServiceMongoImpl diseaseService;

    @Autowired
    PatientServiceMongoImpl patientService;

    @Autowired
    DoctorServiceMongoImpl doctorService;

    @Autowired
    PatientSpendingCardServiceMongoImpl patientSpendingCardService;



    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showAll(Model model) {
        List<HistoryOfDiseases> list = service.getAll();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("historyofdiseases", list);
        return "historyofdiseaseList";
    }
    @PostMapping(value = "/list")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<HistoryOfDiseases> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("historyofdiseases", list);
        return "historyofdiseaseList";
    }

    @RequestMapping(value = "/list/sorted", method = RequestMethod.GET)
    public String showSorted(Model model) {
        List<HistoryOfDiseases> historyOfDiseases = service.getAll();
        List<HistoryOfDiseases> sorted = service.sortByPatientFio(historyOfDiseases);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("historyofdiseases", sorted);
        return "historyofdiseaseList";
    }

    @RequestMapping(value = "/list/sorted", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm")  SearchForm searchForm) {
        String word = searchForm.getString();
        List<HistoryOfDiseases> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("historyofdiseases", list);
        return "historyofdiseaseList";
    }
    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("historyofdiseases", service.getAll());
        return "redirect:/web/historyofdiseases/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        HistoryOfDiseasesForm historyOfDiseasesForm = new HistoryOfDiseasesForm();

        Map<String, String> diseaseMap = diseaseService.getAll().stream()
                .collect(Collectors.toMap(Diseases::getId, Diseases::getNameOfDisease));

        Map<String, String> patientMap = patientService.getAll().stream()
                .collect(Collectors.toMap(Patient::getId, Patient::getFIO));

        Map<String, String> doctorMap = doctorService.getAll().stream()
                .collect(Collectors.toMap(Doctor::getId, Doctor::getFIO));

        Map<String, String> patientSpendingCardMap = patientSpendingCardService.getAll().stream()
                .collect(Collectors.toMap(PatientSpendingCard::getId, PatientSpendingCard::getNumber));

        List<String> diseaseList = diseaseService.getAll().stream()
                .map(Diseases::getNameOfDisease).collect(Collectors.toList());

        List<String> patientList = patientService.getAll().stream()
                .map(Patient::getFIO).collect(Collectors.toList());

        List<String> doctorList = doctorService.getAll().stream()
                .map(Doctor::getFIO).collect(Collectors.toList());

        List<String> patientSpendingCardList = patientSpendingCardService.getAll().stream()
                .map(PatientSpendingCard::getNumber).collect(Collectors.toList());

        model.addAttribute("disease", diseaseMap);
        model.addAttribute("diseaseL", diseaseList);
        model.addAttribute("patient", patientMap);
        model.addAttribute("patientL", patientList);
        model.addAttribute("doctor", doctorMap);
        model.addAttribute("doctorL", doctorList);
        model.addAttribute("spendingCard", patientSpendingCardMap);
        model.addAttribute("spendingCardL", patientSpendingCardList);
        model.addAttribute("historyOfDiseasesForm", historyOfDiseasesForm);
        return "historyOfDiseaseAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("historyOfDiseasesForm") @Valid HistoryOfDiseasesForm historyOfDiseasesForm) {
        HistoryOfDiseases historyOfDiseases = new HistoryOfDiseases();
        historyOfDiseases.setIdOfHistoryOfDiseases(null);
        Diseases diseases = diseaseService.getAll().stream()
                .filter(item -> item.getNameOfDisease().equals(historyOfDiseasesForm.getDisease()) )
                .findFirst().orElse(new Diseases());
        historyOfDiseases.setDisease(diseases);
        Patient patient = patientService.getAll().stream()
                .filter(item -> item.getFIO().equals(historyOfDiseasesForm.getPatient()) )
                .findFirst().orElse(new Patient());
        historyOfDiseases.setPatient(patient);
        Doctor doctor = doctorService.getAll().stream()
                .filter(item -> item.getFIO().equals(historyOfDiseasesForm.getDoctor()) )
                .findFirst().orElse(new Doctor());
        historyOfDiseases.setDoctor(doctor);
        historyOfDiseases.setBeginOfDesease(historyOfDiseasesForm.getBeginOfDesease());
        historyOfDiseases.setEndOfDisease(historyOfDiseasesForm.getEndOfDisease());
        historyOfDiseases.setStatus(historyOfDiseasesForm.getStatus());
        historyOfDiseases.setSpendedMoneyOnDesease(historyOfDiseasesForm.getSpendedMoneyOnDesease());
        PatientSpendingCard patientSpendingCard = patientSpendingCardService.getAll().stream()
                .filter(item -> item.getNumber().equals(historyOfDiseasesForm.getSpendingCard()) )
                .findFirst().orElse(new PatientSpendingCard());
        historyOfDiseases.setSpendingCard(patientSpendingCard);
        service.save(historyOfDiseases);
        model.addAttribute("historyofdiseases", service.getAll());
        return "redirect:/web/historyofdiseases/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        HistoryOfDiseasesForm historyOfDiseasesForm = new HistoryOfDiseasesForm();
        HistoryOfDiseases historyOfDiseases = service.get(id);
        List<String> diseaseList = diseaseService.getAll().stream()
                .map(Diseases::getNameOfDisease).collect(Collectors.toList());

        List<String> patientList = patientService.getAll().stream()
                .map(Patient::getFIO).collect(Collectors.toList());

        List<String> doctorList = doctorService.getAll().stream()
                .map(Doctor::getFIO).collect(Collectors.toList());

        List<String> patientSpendingCardList = patientSpendingCardService.getAll().stream()
                .map(PatientSpendingCard::getNumber).collect(Collectors.toList());

        historyOfDiseasesForm.setDisease(historyOfDiseases.getDisease().getNameOfDisease());
        historyOfDiseasesForm.setPatient(historyOfDiseases.getPatient().getFIO());
        historyOfDiseasesForm.setDoctor(historyOfDiseases.getDoctor().getFIO());
        historyOfDiseasesForm.setBeginOfDesease(historyOfDiseases.getBeginOfDesease());
        historyOfDiseasesForm.setEndOfDisease(historyOfDiseases.getEndOfDisease());
        historyOfDiseasesForm.setStatus(historyOfDiseases.getStatus());
        historyOfDiseasesForm.setSpendedMoneyOnDesease(historyOfDiseases.getSpendedMoneyOnDesease());
        historyOfDiseasesForm.setSpendingCard(historyOfDiseases.getSpendingCard().getNumber());

        model.addAttribute("diseaseL", diseaseList);
        model.addAttribute("patientL", patientList);
        model.addAttribute("doctorL", doctorList);
        model.addAttribute("spendingCardL", patientSpendingCardList);
        model.addAttribute("historyOfDiseasesForm", historyOfDiseasesForm);
        return "historyOfDiseaseEdit";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("historyOfDiseasesForm") @Valid HistoryOfDiseasesForm historyOfDiseasesForm) {

        Diseases diseases = diseaseService.getAll().stream()
                .filter(item -> item.getNameOfDisease().equals(historyOfDiseasesForm.getDisease()) )
                .findFirst().orElse(new Diseases());
        Patient patient = patientService.getAll().stream()
                .filter(item -> item.getFIO().equals(historyOfDiseasesForm.getPatient()) )
                .findFirst().orElse(new Patient());
        Doctor doctor = doctorService.getAll().stream()
                .filter(item -> item.getFIO().equals(historyOfDiseasesForm.getDoctor()) )
                .findFirst().orElse(new Doctor());
        PatientSpendingCard patientSpendingCard = patientSpendingCardService.getAll().stream()
                .filter(item -> item.getNumber().equals(historyOfDiseasesForm.getSpendingCard()) )
                .findFirst().orElse(new PatientSpendingCard());

        HistoryOfDiseases historyOfDiseasesEdited = new HistoryOfDiseases();
        historyOfDiseasesEdited.setIdOfHistoryOfDiseases(id);
        historyOfDiseasesEdited.setDisease(diseases);
        historyOfDiseasesEdited.setPatient(patient);
        historyOfDiseasesEdited.setDoctor(doctor);
        historyOfDiseasesEdited.setBeginOfDesease(historyOfDiseasesForm.getBeginOfDesease());
        historyOfDiseasesEdited.setEndOfDisease(historyOfDiseasesForm.getEndOfDisease());
        historyOfDiseasesEdited.setStatus(historyOfDiseasesForm.getStatus());
        historyOfDiseasesEdited.setSpendedMoneyOnDesease(historyOfDiseasesForm.getSpendedMoneyOnDesease());
        historyOfDiseasesEdited.setSpendingCard(patientSpendingCard);
        service.edit(historyOfDiseasesEdited);
        model.addAttribute("historyofdiseases", service.getAll());
        return "redirect:/web/historyofdiseases/list";
    }
}
