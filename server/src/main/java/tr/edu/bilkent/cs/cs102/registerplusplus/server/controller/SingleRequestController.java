package tr.edu.bilkent.cs.cs102.registerplusplus.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.Course;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.SingleRequest;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.Student;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.repo.CourseRepository;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.repo.SingleRequestRepository;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.service.CourseService;

import java.util.List;

import static tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.Person.columnNum;
import static tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.Person.rowNum;

@RestController
public class SingleRequestController {

    private final SingleRequestRepository singleRequestRepository;
    private final CourseService courseService;

    SingleRequestController(SingleRequestRepository singleRequestRepository, CourseService courseService) {
        this.singleRequestRepository = singleRequestRepository;
        this.courseService = courseService;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/singleRequests")
    public List<SingleRequest> all() {
        List<SingleRequest> all = singleRequestRepository.findAll();
        return all;
    }
    // end::get-aggregate-root[]

    @PostMapping("/singleRequest")
    public SingleRequest newItem(@RequestBody SingleRequest singleRequest) {
        SingleRequest save = singleRequestRepository.save(singleRequest);
        processRequests();
        return save;
    }

    private void processRequests() {
        List<SingleRequest> requests = singleRequestRepository.findAll();
        for (SingleRequest req : requests) {
            boolean b = processRequest(req);
            if (b){

            }
        }
    }

    private boolean processRequest(SingleRequest req) {
        Student owner = req.getRequestOwner();
        Course wanted = req.getWantedCourse();
        if (!isThereQuota(wanted)) return false;
        if (doesOverlap(wanted, owner)) return false;
        courseService.addStudentToCourse(owner, wanted);
        singleRequestRepository.delete(req);

        return true;
    }

    public boolean isThereQuota(Course c) {
        return c.getStudents().size() < Course.QUOTA;
    }

    public boolean doesOverlap(Course course, Student student){
        List<Course> courses = courseService.getCourseByStudentId(student);//todo making a more efficient one?
        if (courses.contains(course)) return false;
        for(int i = 1; i < rowNum; i++){
            for(int j = 1; j < columnNum; j++){
                if (student.getProgram()[i][j] && course.getProgram()[i][j]){
                    return true;
                }
            }
        }
        return false;
    }
}
