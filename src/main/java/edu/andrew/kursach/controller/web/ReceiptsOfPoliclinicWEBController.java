package edu.andrew.kursach.controller.web;

import edu.andrew.kursach.form.ReceiptsOfPoliclinicForm;
import edu.andrew.kursach.form.SearchForm;
import edu.andrew.kursach.model.ReceiptsOfPoliclinic;
import edu.andrew.kursach.service.receiptsOfPoliclinic.impls.ReceiptsOfPoliclinicServiceMongoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/web/receiptsofpoliclinic")
@CrossOrigin("*")
public class ReceiptsOfPoliclinicWEBController {
    @Autowired
    ReceiptsOfPoliclinicServiceMongoImpl service;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showAll(Model model) {
        List<ReceiptsOfPoliclinic> list = service.getAll();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("receiptsofpoliclinic", list);
        return "receiptofpoliclinicList";
    }
    @PostMapping(value = "/list")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<ReceiptsOfPoliclinic> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("receiptsofpoliclinic", list);
        return "receiptofpoliclinicList";
    }

    @RequestMapping(value = "/list/sorted", method = RequestMethod.GET)
    public String showSorted(Model model) {
        List<ReceiptsOfPoliclinic> receiptsOfPoliclinics = service.getAll();
        List<ReceiptsOfPoliclinic> sorted = service.sortByMonth(receiptsOfPoliclinics);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("receiptsofpoliclinic", sorted);
        return "receiptofpoliclinicList";
    }

    @RequestMapping(value = "/list/sorted", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<ReceiptsOfPoliclinic> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("receiptsofpoliclinic", list);
        return "receiptofpoliclinicList";
    }

    @RequestMapping("/delete/{day}")
    String delete(Model model,
                  @PathVariable("day") String day) {
        service.delete(day);
        model.addAttribute("receiptsofpoliclinic", service.getAll());
        return "redirect:/web/receiptsofpoliclinic/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        ReceiptsOfPoliclinicForm receiptsOfPoliclinicForm = new ReceiptsOfPoliclinicForm();
        model.addAttribute("receiptsOfPoliclinicForm",receiptsOfPoliclinicForm);
        return "receiptOfPoliclinicAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model,  @ModelAttribute("receiptOfPoliclinicForm") @Valid ReceiptsOfPoliclinicForm receiptsOfPoliclinicForm) {
        ReceiptsOfPoliclinic receiptsOfPoliclinic = new ReceiptsOfPoliclinic();
        receiptsOfPoliclinic.setInADay(receiptsOfPoliclinicForm.getInADay());
        receiptsOfPoliclinic.setInAMounth(receiptsOfPoliclinicForm.getInAMounth());
        receiptsOfPoliclinic.setDay(receiptsOfPoliclinicForm.getDay());
        receiptsOfPoliclinic.setMonth(receiptsOfPoliclinicForm.getMonth());
        service.save(receiptsOfPoliclinic);
        model.addAttribute("receiptsofpoliclinic", service.getAll());
        return "redirect:/web/receiptsofpoliclinic/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        ReceiptsOfPoliclinic receiptsOfPoliclinic = service.get(id);
        ReceiptsOfPoliclinicForm receiptsOfPoliclinicForm = new ReceiptsOfPoliclinicForm();
        receiptsOfPoliclinicForm.setInADay(receiptsOfPoliclinic.getInADay());
        receiptsOfPoliclinicForm.setInAMounth(receiptsOfPoliclinic.getInAMounth());
        receiptsOfPoliclinicForm.setDay(receiptsOfPoliclinic.getDay());
        receiptsOfPoliclinicForm.setMonth(receiptsOfPoliclinic.getMonth());
        model.addAttribute("receiptsOfPoliclinicForm",receiptsOfPoliclinicForm);
        return "receiptOfPoliclinicEdit";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("receiptsOfPoliclinicForm") @Valid ReceiptsOfPoliclinicForm receiptsOfPoliclinicForm) {
        ReceiptsOfPoliclinic receiptsOfPoliclinic = new ReceiptsOfPoliclinic();
        receiptsOfPoliclinic.setId(id);
        receiptsOfPoliclinic.setInADay(receiptsOfPoliclinicForm.getInADay());
        receiptsOfPoliclinic.setInAMounth(receiptsOfPoliclinicForm.getInAMounth());
        receiptsOfPoliclinic.setDay(receiptsOfPoliclinicForm.getDay());
        receiptsOfPoliclinic.setMonth(receiptsOfPoliclinicForm.getMonth());
        service.save(receiptsOfPoliclinic);
        model.addAttribute("receiptsofpoliclinic", service.getAll());
        return "redirect:/web/receiptsofpoliclinic/list";
    }
}
