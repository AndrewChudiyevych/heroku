package edu.andrew.kursach.controller.web;

import edu.andrew.kursach.form.SearchForm;
import edu.andrew.kursach.form.VisitsOfClinicForm;
import edu.andrew.kursach.model.VisitsOfClinic;
import edu.andrew.kursach.service.visitsOfClinic.impls.VisitsOfClinicServiceMongoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/web/visitofclinic")
@CrossOrigin("*")
public class VisitsOfClinicWEBController {
    @Autowired
    VisitsOfClinicServiceMongoImpl service;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showAll(Model model) {
        List<VisitsOfClinic> list = service.getAll();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("visitsofclinic", list);
        return "visitofclinicList";
    }
    @PostMapping(value = "/list")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<VisitsOfClinic> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("visitsofclinic", list);
        return "visitofclinicList";
    }

    @RequestMapping(value = "/list/sorted", method = RequestMethod.GET)
    public String showSorted(Model model) {
        List<VisitsOfClinic> visitsOfClinics = service.getAll();
        List<VisitsOfClinic> sorted = service.sortByMonth(visitsOfClinics);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("visitsofclinic", sorted);
        return "visitofclinicList";
    }

    @RequestMapping(value = "/list/sorted", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<VisitsOfClinic> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("visitsofclinic", list);
        return "visitofclinicList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("visitsofclinic", service.getAll());
        return "redirect:/web/visitofclinic/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        VisitsOfClinicForm visitsOfClinicForm = new VisitsOfClinicForm();
        model.addAttribute("visitsOfClinicForm",visitsOfClinicForm);
        return "visitOfClinicAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model,  @ModelAttribute("visitsOfClinicForm") @Valid VisitsOfClinicForm visitsOfClinicForm) {
        VisitsOfClinic visitsOfClinic = new VisitsOfClinic();
        visitsOfClinic.setPatientsPerDay(visitsOfClinicForm.getPatientsPerDay());
        visitsOfClinic.setPatientsPerMonth(visitsOfClinicForm.getPatientsPerMonth());
        visitsOfClinic.setDay(visitsOfClinicForm.getDay());
        visitsOfClinic.setMonth(visitsOfClinicForm.getMonth());
        service.save(visitsOfClinic);
        model.addAttribute("visitsofclinic", service.getAll());
        return "redirect:/web/visitofclinic/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        VisitsOfClinic visitsOfClinic = service.get(id);
        VisitsOfClinicForm visitsOfClinicForm = new VisitsOfClinicForm();
        visitsOfClinicForm.setPatientsPerDay(visitsOfClinic.getPatientsPerDay());
        visitsOfClinicForm.setPatientsPerMonth(visitsOfClinic.getPatientsPerMonth());
        visitsOfClinicForm.setDay(visitsOfClinic.getDay());
        visitsOfClinicForm.setMonth(visitsOfClinic.getMonth());
        model.addAttribute("visitsOfClinicForm",visitsOfClinicForm);
        return "visitOfClinicEdit";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("doctorForm") @Valid VisitsOfClinicForm visitsOfClinicForm) {
        VisitsOfClinic visitsOfClinic = new VisitsOfClinic();
        visitsOfClinic.setId(id);
        visitsOfClinic.setPatientsPerDay(visitsOfClinicForm.getPatientsPerDay());
        visitsOfClinic.setPatientsPerMonth(visitsOfClinicForm.getPatientsPerMonth());
        visitsOfClinic.setDay(visitsOfClinicForm.getDay());
        visitsOfClinic.setMonth(visitsOfClinicForm.getMonth());
        service.save(visitsOfClinic);
        model.addAttribute("visitsofclinic", service.getAll());
        return "redirect:/web/visitofclinic/list";
    }
}
