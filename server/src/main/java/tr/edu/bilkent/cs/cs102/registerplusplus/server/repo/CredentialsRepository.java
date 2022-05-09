package tr.edu.bilkent.cs.cs102.registerplusplus.server.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.Credentials;

import java.util.List;

public interface CredentialsRepository extends MongoRepository<Credentials, String> {
    List<Credentials> findCredentialsByUsername(String username);
}
