package edu.ivs.frtrans.controllers.web;

import edu.ivs.frtrans.forms.DriversForms;
import edu.ivs.frtrans.forms.RoutesForms;
import edu.ivs.frtrans.model.Drivers;
import edu.ivs.frtrans.model.Route;
import edu.ivs.frtrans.service.route.impls.RouteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("web/routes")
public class RoutesWeb {
@Autowired
    RouteServiceImpl service;
    @RequestMapping("/get/all")
    String getAll(Model model) {

        model.addAttribute("routes", service.getAll());
        return "routesTable";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model) {
        RoutesForms routesForms = new RoutesForms();
        model.addAttribute("form", routesForms);
        return "routesAddForm";
    }

    @RequestMapping("/delete/{id}")
    String deleteById(@PathVariable("id") String id) {
        service.delete(id);
        return "redirect:/web/routes/get/all";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("form") RoutesForms form, Model model) {
        Route route = new Route();
        route.setName(form.getName());
        route.setDistance(form.getDistance());
        route.setDaysOnTheRoad(form.getDaysOnTheRoad());
        route.setDescription(form.getDescription());
        service.create(route);
        return "redirect:/web/routes/get/all";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(Model model, @PathVariable("id") String id) {
        Route route = service.get(id);
        RoutesForms routesForms = new RoutesForms();
        routesForms.setId(route.getId());
        routesForms.setName(route.getName());
        route.setDistance(route.getDistance());
        route.setDaysOnTheRoad(route.getDaysOnTheRoad());
        routesForms.setDescription(route.getDescription());
        model.addAttribute("form", routesForms);
        return "updateRoutes";
    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(Model model, @ModelAttribute ("form") RoutesForms form
            , @PathVariable("id") String id) {
        Route route = service.get(id);
        route.setName(form.getName());
        route.setDistance(form.getDistance());
        route.setDaysOnTheRoad(form.getDaysOnTheRoad());
        route.setDescription(form.getDescription());
        service.update(route);
        return "redirect:/web/routes/get/all";
    }
}
