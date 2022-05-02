package tr.edu.bilkent.cs.cs102.registerplusplus.server.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.Student;

import java.util.Optional;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

    @Query("{id:'?0'}")
    Optional<Student> findById(String id);
}
