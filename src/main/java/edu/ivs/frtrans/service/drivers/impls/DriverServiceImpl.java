package edu.ivs.frtrans.service.drivers.impls;

import edu.ivs.frtrans.data.FakeData;
import edu.ivs.frtrans.model.Drivers;
import edu.ivs.frtrans.service.drivers.interfaces.IGrudDrivers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DriverServiceImpl implements IGrudDrivers {
    @Autowired
    FakeData data;


    @Override
    public Drivers create(Drivers drivers) {
        if (drivers.getId() != null) {
            this.getAll().add(drivers);
        } else{
            Integer id = this.getAll().stream().map(el -> el.getId()).mapToInt(el -> Integer.valueOf(el))
                    .max().orElse(0);
        drivers.setId(String.valueOf(id + 1));
        LocalDateTime now = LocalDateTime.now();
        drivers.setModified_at(now);
        drivers.setCreated_at(now);
        this.getAll().add(drivers);
    }
        return drivers;
}

    @Override
    public Drivers get(String id) {
        return this.getAll().stream().filter(item -> item.getId().equals(id)).findFirst()
                .orElse(null);
    }

    @Override
    public Drivers update(Drivers item) {
        String id = item.getId();
        Drivers itemToUpdate = this.getAll().stream().filter(el->el.getId().equals(id))
                .findFirst().orElse(null);
        int index = this.getAll().indexOf(itemToUpdate);
        item.setModified_at(LocalDateTime.now());
        this.getAll().set(index, item);
        return item;
    }

    @Override
    public Drivers delete(String id) {
        Drivers drivers = this.get(id);
        this.getAll().remove(drivers);
        return drivers;
    }

    @Override
    public List<Drivers> getAll() {
        return data.getDrivers();
    }
}
