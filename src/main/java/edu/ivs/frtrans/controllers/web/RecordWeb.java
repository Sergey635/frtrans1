package edu.ivs.frtrans.controllers.web;


import edu.ivs.frtrans.data.FakeData;
import edu.ivs.frtrans.forms.RecordForms;
import edu.ivs.frtrans.forms.SearchForm;
import edu.ivs.frtrans.model.Build;
import edu.ivs.frtrans.model.Drivers;
import edu.ivs.frtrans.model.Record;
import edu.ivs.frtrans.service.drivers.impls.CrudDriversMongoImpl;
import edu.ivs.frtrans.service.drivers.impls.DriverServiceImpl;
import edu.ivs.frtrans.service.record.impls.ServiceRecordMongoImpl;
import edu.ivs.frtrans.service.route.impls.CrudRouteMongoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/record")
public class RecordWeb {

    @Autowired
    ServiceRecordMongoImpl service;

    @Autowired
    CrudDriversMongoImpl driversMongo;

    @Autowired
    FakeData fakeData;

    Build standart = new Build("1", "build1", LocalDateTime.now(), LocalDateTime.now());

    @RequestMapping("/all")
    String  getAll(Model model) {
        model.addAttribute("records", service.getAll());
        return "recordsTable";
    }

    @PostMapping("/all")
    String getAll(Model model, @ModelAttribute("search") SearchForm form) {
        String name = form.getName();
        model.addAttribute("records", service.getByName(name));
        SearchForm search = new SearchForm();
        model.addAttribute("search", search);
        return "recordsTable";
    }

    @RequestMapping("/delete/{id}")
    String deleteById(@PathVariable("id") String id) {
        service.delete(id);

        return "redirect:/web/record/all";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model) {
        List<String> drivers = driversMongo.getAll()
                .stream().map(client -> client.getName() + " " + client.getPhone())
                .collect(Collectors.toList());

        Map<String, String> driversMap = new HashMap<>();
        for (Drivers drivers1: driversMongo.getAll()){
            driversMap.put(drivers1.getId(), drivers1.getName() + " " + drivers1.getPhone());
        }

        RecordForms recordForms = new RecordForms();
        model.addAttribute("form", recordForms);
        model.addAttribute("drivers", driversMap);
        return "recordsAddForm";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("form") RecordForms recordForms, Model model) {
        Record record = new Record();
        record.setName(recordForms.getName());
        record.setDescription(recordForms.getDescription());

        String startAsString = recordForms.getStart();
        LocalDate startAsDate = LocalDate.parse(startAsString);
        LocalDateTime startAsDateTime = startAsDate.atTime(0,0,0);
        record.setStart(startAsDateTime);

        record.setFinish(LocalDate.parse(recordForms.getFinish()).atTime(0,0,0));
        String driversId = recordForms.getDrivers();
        Drivers drivers = driversMongo.get(driversId);
        record.setDrivers(drivers);
        record.setBuild(standart);

        service.create(record);
        return "redirect:/web/record/all";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(Model model, @PathVariable("id") String id) {
        Record record = service.get(id);
        RecordForms recordForms = new RecordForms();
        recordForms.setName(record.getName());
        recordForms.setDescription(record.getDescription());
        recordForms.setFinish(record.getFinish().toLocalDate().toString());
        recordForms.setStart(record.getStart().toLocalDate().toString());
        List<String> drivers = driversMongo.getAll()
                .stream().map(client -> client.getName())
                .collect(Collectors.toList());
        String driversName = recordForms.getDrivers();
        Drivers drivers1 = driversMongo.getByName(driversName).get(0);
        drivers.remove(driversName);
        drivers.add(0,driversName);
        record.setDrivers(drivers1);
        // recordForm.setBuild(record.getBuild());
        model.addAttribute("form", recordForms);
        model.addAttribute("drivers", drivers);
        return "updateRecords";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(Model model, @ModelAttribute ("form") RecordForms recordForms
            , @PathVariable("id") String id) {
        Record record = service.get(id);
        record.setName(recordForms.getName());
        record.setDescription(recordForms.getDescription());
        record.setFinish(LocalDate.parse(recordForms.getStart()).atTime(0, 0, 0));
        record.setStart(LocalDate.parse(recordForms.getStart()).atTime(0,0,0));
        String driversName = recordForms.getDrivers();
        Drivers drivers = driversMongo.getByName(driversName).get(0);
        record.setDrivers(drivers);
        service.update(record);
        return "redirect:/web/record/all";
    }

    @RequestMapping("/renew")
    String  renew(Model model) {
        model.addAttribute("records", fakeData.renewRecords());
        return "recordsTable";}
}
