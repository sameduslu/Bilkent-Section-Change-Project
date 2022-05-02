package tr.edu.bilkent.cs.cs102.registerplusplus.server.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.Course;

import java.util.List;

@Repository
public interface CourseRepository extends MongoRepository<Course, String> {
    @Query("{id:'?0'}")
    Course findCourseById(String id);

    @Query(value = "{category:'?0'}", fields = "{'name' : 1, 'quantity' : 1}")
    List<Course> findAll(String category);
    //todo queries

    List<Course> findCourseByStudentsId(String id);
}
