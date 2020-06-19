package edu.andrew.kursach.controller.web;

import edu.andrew.kursach.form.MedicineForm;
import edu.andrew.kursach.form.SearchForm;
import edu.andrew.kursach.model.Diseases;
import edu.andrew.kursach.model.Manufacter;
import edu.andrew.kursach.model.Medicine;
import edu.andrew.kursach.service.disease.impls.DiseaseServiceMongoImpl;
import edu.andrew.kursach.service.manufacter.impls.ManufacterServiceMongoImpls;
import edu.andrew.kursach.service.medicine.impls.MedicineServiceMongoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/medicine")
@CrossOrigin("*")
public class MedicineWEBController {
    @Autowired
    MedicineServiceMongoImpl service;

    @Autowired
    ManufacterServiceMongoImpls manufacterService;

    @Autowired
    DiseaseServiceMongoImpl diseaseService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showAll(Model model) {
        List<Medicine> list = service.getAll();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("medicines", list);
        return "medicineList";
    }
    @PostMapping(value = "/list")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Medicine> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("medicines", list);
        return "medicineList";
    }

    @RequestMapping(value = "/list/sorted", method = RequestMethod.GET)
    public String showSorted(Model model) {
        List<Medicine> medicines = service.getAll();
        List<Medicine> sorted = service.sortByNameOfMedicine(medicines);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("medicines", sorted);
        return "medicineList";
    }

    @RequestMapping(value = "/list/sorted", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Medicine> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("medicines", list);
        return "medicineList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("medicines", service.getAll());
        return "redirect:/web/medicine/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        MedicineForm medicineForm = new MedicineForm();

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
        model.addAttribute("medicineForm", medicineForm);
        return "medicineAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("medicineForm") @Valid MedicineForm medicineForm) {
        Medicine medicine = new Medicine();
        medicine.setId(null);
        Manufacter manufacter = manufacterService.getAll().stream()
                .filter(item -> item.getName().equals(medicineForm.getManufacter()) )
                .findFirst().orElse(new Manufacter());
        medicine.setManufacter(manufacter);
        medicine.setPrice(medicineForm.getPrice());
        medicine.setTypeOfMedicine(medicineForm.getTypeOfMedicine());
        medicine.setNameOfMedicine(medicineForm.getNameOfMedicine());
        Diseases diseases = diseaseService.getAll().stream()
                .filter(item -> item.getNameOfDisease().equals(medicineForm.getDisiase()) )
                .findFirst().orElse(new Diseases());
        medicine.setDisiase(diseases);
        service.save(medicine);
        model.addAttribute("medicines", service.getAll());
        return "redirect:/web/medicine/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        MedicineForm medicineForm = new MedicineForm();
        Medicine medicine = service.get(id);
        List<String> manufacterList = manufacterService.getAll().stream()
                .map(Manufacter::getName).collect(Collectors.toList());

        medicineForm.setManufacter(medicine.getManufacter().getName());
        medicineForm.setPrice(medicine.getPrice());
        medicineForm.setTypeOfMedicine(medicine.getTypeOfMedicine());
        medicineForm.setNameOfMedicine(medicine.getNameOfMedicine());

        List<String> diseaseList = diseaseService.getAll().stream()
                .map(Diseases::getNameOfDisease).collect(Collectors.toList());
        medicineForm.setDisiase(medicine.getDisiase().getNameOfDisease());

        model.addAttribute("manufacterL", manufacterList);
        model.addAttribute("disiaseL", diseaseList);
        model.addAttribute("medicineForm", medicineForm);
        return "medicineEdit";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("medicineForm") @Valid MedicineForm medicineForm) {
        Manufacter manufacter = manufacterService.getAll().stream()
                .filter(item -> item.getName().equals(medicineForm.getManufacter()) )
                .findFirst().orElse(new Manufacter());
        Diseases diseases = diseaseService.getAll().stream()
                .filter(item -> item.getNameOfDisease().equals(medicineForm.getDisiase()) )
                .findFirst().orElse(new Diseases());
        Medicine medicineEdited = new Medicine();
        medicineEdited.setId(id);
        medicineEdited.setManufacter(manufacter);
        medicineEdited.setPrice(medicineForm.getPrice());
        medicineEdited.setTypeOfMedicine(medicineForm.getTypeOfMedicine());
        medicineEdited.setNameOfMedicine(medicineForm.getNameOfMedicine());
        medicineEdited.setDisiase(diseases);
        service.edit(medicineEdited);
        model.addAttribute("medicines", service.getAll());
        return "redirect:/web/medicine/list";
    }

}


