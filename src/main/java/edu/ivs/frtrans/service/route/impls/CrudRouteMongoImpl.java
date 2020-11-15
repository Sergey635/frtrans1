package edu.ivs.frtrans.service.route.impls;

import edu.ivs.frtrans.data.FakeData;
import edu.ivs.frtrans.model.Route;
import edu.ivs.frtrans.repository.RouteRepository;
import edu.ivs.frtrans.service.route.interfaces.ICrudRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Service
public class CrudRouteMongoImpl implements ICrudRoute {

    @Autowired
    FakeData data;

    @Autowired
    RouteRepository repository;

    private List<Route> list = new ArrayList<>();

    //@PostConstruct
    void init(){
        list = data.getRoutes();
        list.size();
        repository.saveAll(list);
    }

    @Override
    public Route create(Route route) {
        route.setModified_at(LocalDateTime.now());
        route.setCreated_at(LocalDateTime.now());
        return repository.save(route);
    }

    @Override
    public Route get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Route update(Route route) {
        route.setModified_at(LocalDateTime.now());
        return repository.save(route);
    }

    @Override
    public Route delete(String id) {
        Route route = this.get(id);
        repository.deleteById(id);
        return route;
    }

    @Override
    public List<Route> getAll() {
        return repository.findAll();
    }
}
