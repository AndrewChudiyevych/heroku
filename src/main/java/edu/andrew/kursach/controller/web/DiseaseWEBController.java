package edu.andrew.kursach.controller.web;


import edu.andrew.kursach.form.DiseaseForm;
import edu.andrew.kursach.form.SearchForm;
import edu.andrew.kursach.model.Diseases;
import edu.andrew.kursach.service.disease.impls.DiseaseServiceMongoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/web/disease")
@CrossOrigin("*")
public class DiseaseWEBController {
    @Autowired
    DiseaseServiceMongoImpl service;


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showAll(Model model) {
        List<Diseases> list = service.getAll();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("diseases", list);
        return "diseaseList";
    }
    @PostMapping(value = "/list")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Diseases> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("diseases", list);
        return "diseaseList";
    }

    @RequestMapping(value = "/list/sorted", method = RequestMethod.GET)
    public String showSorted(Model model) {
        List<Diseases> diseases = service.getAll();
        List<Diseases> sorted = service.sortByNameOfDisease(diseases);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("diseases", sorted);
        return "diseaseList";
    }

    @RequestMapping(value = "/list/sorted", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Diseases> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("diseases", list);
        return "diseaseList";
    }
    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("diseases", service.getAll());
        return "redirect:/web/disease/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        DiseaseForm diseaseForm = new DiseaseForm();
        model.addAttribute("diseaseForm",diseaseForm);
        return "diseaseAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model,  @ModelAttribute("diseaseForm") @Valid DiseaseForm diseaseForm) {
        Diseases diseases = new Diseases();
        diseases.setNameOfDisease(diseaseForm.getNameOfDisease());
        diseases.setMedicine(diseaseForm.getMedicine());
        diseases.setMaterials(diseaseForm.getMaterials());
        service.save(diseases);
        model.addAttribute("diseases", service.getAll());
        return "redirect:/web/disease/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        Diseases diseases = service.get(id);
        DiseaseForm diseaseForm = new DiseaseForm();
        diseaseForm.setNameOfDisease(diseases.getNameOfDisease());
        diseaseForm.setMedicine(diseases.getMedicine());
        diseaseForm.setMaterials(diseases.getMaterials());
        model.addAttribute("diseaseForm",diseaseForm);
        return "diseaseEdit";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("diseaseForm") @Valid DiseaseForm diseaseForm) {
        Diseases diseases = new Diseases();
        diseases.setId(id);
        diseases.setNameOfDisease(diseaseForm.getNameOfDisease());
        diseases.setMedicine(diseaseForm.getMedicine());
        diseases.setMaterials(diseaseForm.getMaterials());
        service.save(diseases);
        model.addAttribute("diseases", service.getAll());
        return "redirect:/web/disease/list";
    }

}
