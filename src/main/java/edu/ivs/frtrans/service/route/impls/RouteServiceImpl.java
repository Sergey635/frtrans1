package edu.ivs.frtrans.service.route.impls;

import edu.ivs.frtrans.data.FakeData;
import edu.ivs.frtrans.model.Route;
import edu.ivs.frtrans.service.route.interfaces.ICrudRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RouteServiceImpl implements ICrudRoute {
    @Autowired
    FakeData data;
    @Override
    public Route create(Route route) {
        if (route.getId() != null) {
            this.getAll().add(route);
        } else{
            Integer id = this.getAll().stream().map(el -> el.getId()).mapToInt(el -> Integer.valueOf(el))
                    .max().orElse(0);
            route.setId(String.valueOf(id + 1));
            LocalDateTime now = LocalDateTime.now();
            route.setModified_at(now);
            route.setCreated_at(now);
            this.getAll().add(route);
        }
        return route;
    }

    @Override
    public Route get(String id) {
        return this.getAll().stream().filter(item -> item.getId().equals(id)).findFirst()
                .orElse(null);
    }

    @Override
    public Route update(Route route) {
        String id = route.getId();
        Route routeToUpdate = this.getAll().stream().filter(el->el.getId().equals(id))
                .findFirst().orElse(null);
        int index = this.getAll().indexOf(routeToUpdate);
        route.setModified_at(LocalDateTime.now());
        this.getAll().set(index, route);
        return route;
    }

    @Override
    public Route delete(String id) {
        Route route = this.get(id);
        this.getAll().remove(route);
        return route;
    }

    @Override
    public List<Route> getAll() {
        return data.getRoutes();
    }
}
