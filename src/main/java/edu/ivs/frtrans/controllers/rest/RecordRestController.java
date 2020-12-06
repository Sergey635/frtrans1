package edu.ivs.frtrans.controllers.rest;

import edu.ivs.frtrans.model.Record;
import edu.ivs.frtrans.service.record.impls.ServiceRecordMongoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/record")
public class RecordRestController {

    @Autowired
    ServiceRecordMongoImpl service;


    @RequestMapping("get/all")
    List<Record> getAll() {
        return service.getAll();
    }



    @RequestMapping("/delete/{id}")
    Record deleteById(@PathVariable("id") String id) {

        return service.delete(id);
    }
    @RequestMapping("/get/{id}")
    Record getById(@PathVariable("id") String id) {

        return service.get(id);
    }
    @PostMapping("/create")
    Record create(@RequestBody Record record) {
        return service.create(record);

    }
    @PutMapping("/update")
    Record update(@RequestBody Record record) {
        return service.update(record);
    }
}