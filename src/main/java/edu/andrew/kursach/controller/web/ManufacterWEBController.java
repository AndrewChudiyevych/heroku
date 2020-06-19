package edu.andrew.kursach.controller.web;


import edu.andrew.kursach.form.ManufacterForm;
import edu.andrew.kursach.form.SearchForm;
import edu.andrew.kursach.model.Manufacter;
import edu.andrew.kursach.service.manufacter.impls.ManufacterServiceMongoImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/web/manufacter")
@CrossOrigin("*")
public class ManufacterWEBController {

    @Autowired
    ManufacterServiceMongoImpls service;


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showAll(Model model) {
        List<Manufacter> list = service.getAll();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("manufacters", list);
        return "manufacterList";
    }
    @PostMapping(value = "/list")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Manufacter> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("manufacters", list);
        return "manufacterList";
    }

    @RequestMapping(value = "/list/sorted", method = RequestMethod.GET)
    public String showSorted(Model model) {
        List<Manufacter> manufacters = service.getAll();
        List<Manufacter> sorted = service.sortByName(manufacters);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("manufacters", sorted);
        return "manufacterList";
    }

    @RequestMapping(value = "/list/sorted", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Manufacter> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("manufacters", list);
        return "manufacterList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("manufacters", service.getAll());
        return "redirect:/web/manufacter/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        ManufacterForm manufacterForm = new ManufacterForm();
        model.addAttribute("manufacterForm",manufacterForm);
        return "manufacterAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model,  @ModelAttribute("manufacterForm") @Valid ManufacterForm manufacterForm) {
        Manufacter manufacter = new Manufacter();
        manufacter.setName(manufacterForm.getName());
        manufacter.setTypeOfProduction(manufacterForm.getTypeOfProduction());
        service.save(manufacter);
        model.addAttribute("manufacters", service.getAll());
        return "redirect:/web/manufacter/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        Manufacter manufacter = service.get(id);
        ManufacterForm manufacterForm = new ManufacterForm();
        manufacterForm.setName(manufacter.getName());
        manufacterForm.setTypeOfProduction(manufacter.getTypeOfProduction());
        model.addAttribute("manufacterForm",manufacterForm);
        return "manufacterEdit";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("manufacterForm") @Valid ManufacterForm manufacterForm) {
        Manufacter manufacter = new Manufacter();
        manufacter.setId(id);
        manufacter.setName(manufacterForm.getName());
        manufacter.setTypeOfProduction(manufacterForm.getTypeOfProduction());
        service.save(manufacter);
        model.addAttribute("manufacters", service.getAll());
        return "redirect:/web/manufacter/list";
    }

}
