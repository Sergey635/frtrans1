package edu.ivs.frtrans.controllers.rest;

import edu.ivs.frtrans.model.Drivers;
import edu.ivs.frtrans.model.Route;
import edu.ivs.frtrans.service.route.impls.RouteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routes")
public class RouteRestController {
    @Autowired
    RouteServiceImpl service;

    @RequestMapping("/get/all")
    List<Route> getAll() {
        return service.getAll();
    }

    @RequestMapping("/delete/{id}")
    Route deleteById(@PathVariable("id") String id) {
        return service.delete(id);
    }

    @RequestMapping("/get/{id}")
    Route getById(@PathVariable("id") String id){
        return service.get(id);
    }

    @PostMapping("/create")
    Route create(@RequestBody Route route) {
        return service.create(route);
    }

    @PutMapping("/update")
    Route update(@RequestBody Route route) {
        return service.update(route);
    }

}
