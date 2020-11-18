package edu.ivs.frtrans.service.drivers.impls;

import edu.ivs.frtrans.data.FakeData;
import edu.ivs.frtrans.model.Drivers;
import edu.ivs.frtrans.repository.DriversRepository;
import edu.ivs.frtrans.service.drivers.interfaces.IGrudDrivers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CrudDriversMongoImpl implements IGrudDrivers {
    @Autowired
    FakeData data;

    @Autowired
    DriversRepository repository;

    private List<Drivers> list = new ArrayList<>();

    //@PostConstruct
    void init(){
        list = data.getDrivers();
        list.size();
        repository.saveAll(list);
    }

    @Override
    public Drivers create(Drivers drivers) {
        drivers.setModified_at(LocalDateTime.now());
        drivers.setCreated_at(LocalDateTime.now());
        return repository.save(drivers);
    }

    @Override
    public Drivers get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Drivers update(Drivers item) {
        item.setModified_at(LocalDateTime.now());
        return repository.save(item);
    }

    @Override
    public Drivers delete(String id) {
        Drivers drivers = this.get(id);
        repository.deleteById(id);
        return drivers;
    }

    @Override
    public List<Drivers> getAll() {
        return repository.findAll();
    }

    public List<Drivers> getByName(String name) {
        if (name.equals("")) return this.getAll();
        return this.getAll().stream().filter(drivers ->drivers.getName().contains(name))
                .collect(Collectors.toList());
    }
}
