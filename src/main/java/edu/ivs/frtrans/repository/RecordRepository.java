package edu.ivs.frtrans.repository;

import edu.ivs.frtrans.model.Record;
import edu.ivs.frtrans.model.Route;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends MongoRepository<Record, String> {
}
