package edu.ivs.frtrans.repository;

import edu.ivs.frtrans.model.Route;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends MongoRepository<Route, String> {
}
