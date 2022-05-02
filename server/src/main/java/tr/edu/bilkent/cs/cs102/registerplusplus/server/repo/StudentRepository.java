package tr.edu.bilkent.cs.cs102.registerplusplus.server.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

}
