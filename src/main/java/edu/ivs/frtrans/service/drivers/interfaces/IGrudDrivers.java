package edu.ivs.frtrans.service.drivers.interfaces;

import edu.ivs.frtrans.model.Drivers;

import java.util.List;

public interface IGrudDrivers {
    Drivers create(Drivers drivers);
    Drivers get(String id);
    Drivers update(Drivers drivers);
    Drivers delete(String id);
    List<Drivers> getAll();
}
