package edu.ivs.frtrans.service.route.interfaces;

import edu.ivs.frtrans.model.Route;

import java.util.List;

public interface ICrudRoute {
    Route create(Route route);
    Route get(String id);
    Route update(Route item);
    Route delete(String id);
    List<Route> getAll();
}
