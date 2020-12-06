package edu.ivs.frtrans.service.record.impls;

import edu.ivs.frtrans.model.Record;
import edu.ivs.frtrans.repository.RecordRepository;
import edu.ivs.frtrans.service.record.interfaces.ICrudRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceRecordMongoImpl implements ICrudRecord {
    @Autowired
    RecordRepository repository;

    @Override
    public Record create(Record record) {
        record.setCreated_at(LocalDateTime.now());
        record.setModified_at(LocalDateTime.now());
        return repository.save(record);
    }

    @Override
    public Record get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Record update(Record record) {
        record.setModified_at(LocalDateTime.now());
        return repository.save(record);
    }

    @Override
    public Record delete(String id) {
        Record record = this.get(id);
        repository.deleteById(id);
        return record;
    }

    @Override
    public List<Record> getAll() {
        return repository.findAll();}

        public List<Record> getByName (String name) {
            if (name.equals(" ")) return this.getAll();
            return this.getAll().stream().filter(record -> record.getName()
            .contains(name)).collect(Collectors.toList());
        }

}
