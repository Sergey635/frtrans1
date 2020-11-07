package edu.ivs.frtrans.controllers.web;

import edu.ivs.frtrans.forms.DriversForms;
import edu.ivs.frtrans.model.Drivers;
import edu.ivs.frtrans.service.drivers.impls.CrudDriversMongoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/web/drivers")
    public class DriverWeb {
    @Autowired
    CrudDriversMongoImpl service;

    @RequestMapping("/get/all")
    String getAll(Model model) {

        model.addAttribute("drivers", service.getAll());
        return "driversTable";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model) {
        DriversForms driversForms = new DriversForms();
        model.addAttribute("form", driversForms);
        return "driversAddForm";
    }

    @RequestMapping("/delete/{id}")
    String deleteById(@PathVariable("id") String id) {
        service.delete(id);
        return "redirect:/web/drivers/get/all";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("form") DriversForms form, Model model) {
        System.out.println(form);
        Drivers drivers = new Drivers();
        drivers.setName(form.getName());
        drivers.setDescription(form.getDescription());
        service.create(drivers);
        return "redirect:/web/drivers/get/all";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(Model model, @PathVariable("id") String id) {
        Drivers drivers = service.get(id);
        DriversForms driversForms = new DriversForms();
        driversForms.setId(drivers.getId());
        driversForms.setName(drivers.getName());
        driversForms.setDescription(drivers.getDescription());
        model.addAttribute("form", driversForms);
        return "updateDrivers";
    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(Model model, @ModelAttribute ("form") DriversForms form, @PathVariable("id") String id) {
        Drivers drivers = service.get(id);
        drivers.setName(form.getName());
        drivers.setDescription(form.getDescription());
        service.update(drivers);
        return "redirect:/web/drivers/get/all";
    }
}

