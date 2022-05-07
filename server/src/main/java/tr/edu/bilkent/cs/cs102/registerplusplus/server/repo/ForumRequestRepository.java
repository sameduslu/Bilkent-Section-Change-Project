package tr.edu.bilkent.cs.cs102.registerplusplus.server.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.ForumRequest;

import java.util.Optional;

public interface ForumRequestRepository extends MongoRepository<ForumRequest, String> {


    Optional<ForumRequest> findById(String id);
}
