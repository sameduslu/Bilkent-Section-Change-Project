package tr.edu.bilkent.cs.cs102.registerplusplus.server.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.SingleRequest;

public interface SingleRequestRepository extends MongoRepository<SingleRequest, String> {
}
