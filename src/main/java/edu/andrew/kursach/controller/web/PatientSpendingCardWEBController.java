package edu.andrew.kursach.controller.web;

import edu.andrew.kursach.form.*;
import edu.andrew.kursach.model.*;
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
@RequestMapping("/web/patientspendingcard")
@CrossOrigin("*")
public class PatientSpendingCardWEBController {
    @Autowired
    PatientSpendingCardServiceMongoImpl service;

    @Autowired
    PatientServiceMongoImpl patientService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showAll(Model model) {
        List<PatientSpendingCard> list = service.getAll();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("patientspendingcards", list);
        return "patientspendingcardList";
    }
    @PostMapping(value = "/list")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<PatientSpendingCard> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("patientspendingcards", list);
        return "patientspendingcardList";
    }

    @RequestMapping(value = "/list/sorted", method = RequestMethod.GET)
    public String showSorted(Model model) {
        List<PatientSpendingCard> patientSpendingCards = service.getAll();
        List<PatientSpendingCard> sorted = service.sortByNumber(patientSpendingCards);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("patientspendingcards", sorted);
        return "patientspendingcardList";
    }

    @RequestMapping(value = "/list/sorted", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<PatientSpendingCard> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("patientspendingcards", list);
        return "patientspendingcardList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("patientspendingcards", service.getAll());
        return "redirect:/web/patientspendingcard/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        PatientSpendingCardForm patientSpendingCardForm = new PatientSpendingCardForm();

        Map<String, String> patientMap = patientService.getAll().stream()
                .collect(Collectors.toMap(Patient::getId, Patient::getFIO));

        List<String> patientList = patientService.getAll().stream()
                .map(Patient::getFIO).collect(Collectors.toList());

        model.addAttribute("patient", patientMap);
        model.addAttribute("patientL", patientList);
        model.addAttribute("patientSpendingCardForm", patientSpendingCardForm);
        return "patientSpendingCardAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("patientSpendingCardForm") @Valid PatientSpendingCardForm patientSpendingCardForm) {
        PatientSpendingCard patientSpendingCard = new PatientSpendingCard();
        patientSpendingCard.setId(null);
        Patient patient = patientService.getAll().stream()
                .filter(item -> item.getFIO().equals(patientSpendingCardForm.getPatient()) )
                .findFirst().orElse(new Patient());
        patientSpendingCard.setPatient(patient);
        patientSpendingCard.setNumber(patientSpendingCardForm.getNumber());
        patientSpendingCard.setSpendPerDay(patientSpendingCardForm.getSpendPerDay());
        patientSpendingCard.setSpendPerMonth(patientSpendingCardForm.getSpendPerMonth());
        patientSpendingCard.setDay(patientSpendingCardForm.getDay());
        patientSpendingCard.setMonth(patientSpendingCardForm.getMonth());
        service.save(patientSpendingCard);
        model.addAttribute("patientspendingcards", service.getAll());
        return "redirect:/web/patientspendingcard/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        PatientSpendingCardForm patientSpendingCardForm = new PatientSpendingCardForm();
        PatientSpendingCard patientSpendingCard = service.get(id);
        List<String> patientList = patientService.getAll().stream()
                .map(Patient::getFIO).collect(Collectors.toList());

        patientSpendingCardForm.setPatient(patientSpendingCard.getPatient().getFIO());
        patientSpendingCardForm.setNumber(patientSpendingCard.getNumber());
        patientSpendingCardForm.setSpendPerDay(patientSpendingCard.getSpendPerDay());
        patientSpendingCardForm.setSpendPerMonth(patientSpendingCard.getSpendPerMonth());
        patientSpendingCardForm.setDay(patientSpendingCard.getDay());
        patientSpendingCardForm.setMonth(patientSpendingCard.getMonth());


        model.addAttribute("patientL", patientList);
        model.addAttribute("patientSpendingCardForm", patientSpendingCardForm);
        return "patientSpendingCardEdit";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("patientSpendingCardForm") @Valid PatientSpendingCardForm patientSpendingCardForm) {

        Patient patient = patientService.getAll().stream()
                .filter(item -> item.getFIO().equals(patientSpendingCardForm.getPatient()) )
                .findFirst().orElse(new Patient());


        PatientSpendingCard patientSpendingCardEdited = new PatientSpendingCard();
        patientSpendingCardEdited.setId(id);
        patientSpendingCardEdited.setPatient(patient);
        patientSpendingCardEdited.setNumber(patientSpendingCardForm.getNumber());
        patientSpendingCardEdited.setSpendPerDay(patientSpendingCardForm.getSpendPerDay());
        patientSpendingCardEdited.setSpendPerMonth(patientSpendingCardForm.getSpendPerMonth());
        patientSpendingCardEdited.setDay(patientSpendingCardForm.getDay());
        patientSpendingCardEdited.setMonth(patientSpendingCardForm.getMonth());
        service.edit(patientSpendingCardEdited);
        model.addAttribute("patientspendingcards", service.getAll());
        return "redirect:/web/patientspendingcard/list";
    }

}
