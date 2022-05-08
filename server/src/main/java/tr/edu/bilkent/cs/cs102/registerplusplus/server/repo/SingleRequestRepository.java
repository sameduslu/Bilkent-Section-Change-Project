package tr.edu.bilkent.cs.cs102.registerplusplus.server.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.SingleRequest;

import java.util.List;

public interface SingleRequestRepository extends MongoRepository<SingleRequest, String> {
    List<SingleRequest> findSingleRequestByRequestOwner_Id(String id);
}
