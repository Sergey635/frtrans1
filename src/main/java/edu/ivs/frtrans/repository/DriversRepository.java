package edu.ivs.frtrans.repository;

import edu.ivs.frtrans.model.Drivers;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriversRepository extends MongoRepository<Drivers, String> {
}
