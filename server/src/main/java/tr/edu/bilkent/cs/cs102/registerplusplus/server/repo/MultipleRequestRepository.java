package tr.edu.bilkent.cs.cs102.registerplusplus.server.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.MultipleRequest;

import java.util.List;

public interface MultipleRequestRepository extends MongoRepository<MultipleRequest, String> {

    List<MultipleRequest> findMultipleRequestsByRequestOwner_Id(String id);
}
