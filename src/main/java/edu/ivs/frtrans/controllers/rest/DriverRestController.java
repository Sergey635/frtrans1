package edu.ivs.frtrans.controllers.rest;

import edu.ivs.frtrans.model.Drivers;
import edu.ivs.frtrans.service.drivers.impls.DriverServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Driver;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/drivers")
public class DriverRestController {
    @Autowired
    DriverServiceImpl service;

    @RequestMapping("/get/all")
    List<Drivers> getAll() {
        return service.getAll();
    }

    @RequestMapping("/delete/{id}")
    Drivers deleteById(@PathVariable("id") String id) {
        return service.delete(id);
    }

    @RequestMapping("/get/{id}")
    Drivers getById(@PathVariable("id") String id){
        return service.get(id);
    }

    @PostMapping("/create")
    Drivers create(@RequestBody Drivers drivers) {
        return service.create(drivers);
    }

    @PutMapping("/update")
    Drivers update(@RequestBody Drivers drivers) {
        return service.update(drivers);
    }
}
