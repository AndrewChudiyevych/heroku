package edu.andrew.kursach.controller.web;


import edu.andrew.kursach.form.MaterialForm;
import edu.andrew.kursach.form.SearchForm;
import edu.andrew.kursach.model.Diseases;
import edu.andrew.kursach.model.Manufacter;
import edu.andrew.kursach.model.Materials;
import edu.andrew.kursach.service.disease.impls.DiseaseServiceMongoImpl;
import edu.andrew.kursach.service.manufacter.impls.ManufacterServiceMongoImpls;
import edu.andrew.kursach.service.material.impls.MaterialServiceMongoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/material")
@CrossOrigin("*")
public class MaterialsWEBController {
    @Autowired
    MaterialServiceMongoImpl service;

    @Autowired
    ManufacterServiceMongoImpls manufacterService;

    @Autowired
    DiseaseServiceMongoImpl diseaseService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showAll(Model model) {
        List<Materials> list = service.getAll();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("materials", list);
        return "materialList";
    }
    @PostMapping(value = "/list")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Materials> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("materials", list);
        return "materialList";
    }

    @RequestMapping(value = "/list/sorted", method = RequestMethod.GET)
    public String showSorted(Model model) {
        List<Materials> materials = service.getAll();
        List<Materials> sorted = service.sortByNameOfMaterial(materials);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("materials", sorted);
        return "materialList";
    }

    @RequestMapping(value = "/list/sorted", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Materials> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("materials", list);
        return "materialList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("materials", service.getAll());
        return "redirect:/web/material/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        MaterialForm materialForm = new MaterialForm();

        Map<String, String> manufacterMap = manufacterService.getAll().stream()
                .collect(Collectors.toMap(Manufacter::getId, Manufacter::getName));

        Map<String, String> diseaseMap = diseaseService.getAll().stream()
                .collect(Collectors.toMap(Diseases::getId, Diseases::getNameOfDisease));

        List<String> manufacterList = manufacterService.getAll().stream()
                .map(Manufacter::getName).collect(Collectors.toList());

        List<String> diseaseList = diseaseService.getAll().stream()
                .map(Diseases::getNameOfDisease).collect(Collectors.toList());

        model.addAttribute("manufacter", manufacterMap);
        model.addAttribute("manufacterL", manufacterList);
        model.addAttribute("disease", diseaseMap);
        model.addAttribute("disiaseL", diseaseList);
        model.addAttribute("materialForm", materialForm);
        return "materialsAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("materialForm") @Valid MaterialForm materialForm) {
        Materials materials = new Materials();
        materials.setId(null);
        Manufacter manufacter = manufacterService.getAll().stream()
                .filter(item -> item.getName().equals(materialForm.getManufacter()) )
                .findFirst().orElse(new Manufacter());
        materials.setManufacter(manufacter);
        materials.setPrice(materialForm.getPrice());
        materials.setTypeOfMaterial(materialForm.getTypeOfMaterial());
        materials.setNameOfMaterial(materialForm.getNameOfMaterial());
        Diseases diseases = diseaseService.getAll().stream()
                .filter(item -> item.getNameOfDisease().equals(materialForm.getDisease()) )
                .findFirst().orElse(new Diseases());
        materials.setDisease(diseases);
        service.save(materials);
        model.addAttribute("materials", service.getAll());
        return "redirect:/web/material/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        MaterialForm materialForm = new MaterialForm();
        Materials materials = service.get(id);
        List<String> manufacterList = manufacterService.getAll().stream()
                .map(Manufacter::getName).collect(Collectors.toList());

        List<String> diseaseList = diseaseService.getAll().stream()
                .map(Diseases::getNameOfDisease).collect(Collectors.toList());

        materialForm.setManufacter(materials.getManufacter().getName());
        materialForm.setPrice(materials.getPrice());
        materialForm.setTypeOfMaterial(materials.getTypeOfMaterial());
        materialForm.setNameOfMaterial(materials.getNameOfMaterial());
        materialForm.setDisease(materials.getDisease().getNameOfDisease());

        model.addAttribute("manufacterL", manufacterList);
        model.addAttribute("disiaseL", diseaseList);
        model.addAttribute("materialForm", materialForm);
        return "materialsEdit";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("materialForm") @Valid MaterialForm materialForm) {
        Manufacter manufacter = manufacterService.getAll().stream()
                .filter(item -> item.getName().equals(materialForm.getManufacter()) )
                .findFirst().orElse(new Manufacter());
        Diseases diseases = diseaseService.getAll().stream()
                .filter(item -> item.getNameOfDisease().equals(materialForm.getDisease()) )
                .findFirst().orElse(new Diseases());
        Materials materialsEdited = new Materials();
        materialsEdited.setId(id);
        materialsEdited.setManufacter(manufacter);
        materialsEdited.setPrice(materialForm.getPrice());
        materialsEdited.setTypeOfMaterial(materialForm.getTypeOfMaterial());
        materialsEdited.setNameOfMaterial(materialForm.getNameOfMaterial());
        materialsEdited.setDisease(diseases);
        service.edit(materialsEdited);
        model.addAttribute("materials", service.getAll());
        return "redirect:/web/material/list";
    }

}
