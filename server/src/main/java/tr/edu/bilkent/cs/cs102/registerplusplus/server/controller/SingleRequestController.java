package tr.edu.bilkent.cs.cs102.registerplusplus.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.Course;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.SingleRequest;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.Student;
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
        for (int i = 0; i < requests.size(); i++) {
            boolean b = processRequest(requests.get(i));
            if (b) {
                i = 0;
                requests = singleRequestRepository.findAll();
            }
        }
    }

    private boolean processRequest(SingleRequest req) {
        Student owner = req.getRequestOwner();
        List<Course> courseByStudentId = courseService.getCourseByStudentId(owner);
        Course wanted = req.getWantedCourse();
        if (courseByStudentId.contains(wanted)) {
            singleRequestRepository.delete(req);
            return true;
        }
        if (!isThereQuota(wanted)) return false;

        if (doesStudentTakeCourse(wanted, courseByStudentId)) {
            return processSectionChangeRequest(req, courseByStudentId);
        }
        return processNewCourseRequest(req, courseByStudentId);
    }

    private boolean processSectionChangeRequest(SingleRequest req, List<Course> courseByStudentId) {
        Student owner = req.getRequestOwner();
        Course wanted = req.getWantedCourse();
        boolean[][] wantedProgram = wanted.getProgram();
        Course course = courseByStudentId.stream().filter(c -> c.getName().equals(wanted.getName())).findAny().get();
        boolean[][] originalProgram = owner.getProgram();
        boolean[][] tempProgram = new boolean[originalProgram.length][];
        for (int i = 0; i < originalProgram.length; i++) {
            tempProgram[i] = originalProgram[i].clone();
        }
        boolean[][] courseProgram = course.getProgram();
        for (int i = 0; i < courseProgram.length; i++) {
            for (int j = 0; j < courseProgram[i].length; j++) {
                if (courseProgram[i][j]) {
                    tempProgram[i][j] = false;
                }
            }
        }
        for (int i = 0; i < tempProgram.length; i++) {
            for (int j = 0; j < tempProgram[i].length; j++) {
                if (wantedProgram[i][j] && tempProgram[i][j]) {
                    return false;
                }
            }
        }
        courseService.removeStudentFromCourse(owner, course);
        courseService.addStudentToCourse(owner, wanted);
        singleRequestRepository.delete(req);
        return true;
    }

    private boolean doesStudentTakeCourse(Course wanted, List<Course> coursesByStudentId) {
        return coursesByStudentId.stream().anyMatch(c -> c.getName().equals(wanted.getName()));
    }

    private boolean processNewCourseRequest(SingleRequest req, List<Course> courseByStudentId) {
        Student owner = req.getRequestOwner();
        Course wanted = req.getWantedCourse();
        if (doesOverlap(wanted, owner, courseByStudentId)) {
            return false;
        }
        courseService.addStudentToCourse(owner, wanted);
        singleRequestRepository.delete(req);
        return true;
    }

    public boolean isThereQuota(Course c) {
        return c.getStudents().size() < Course.QUOTA;
    }

    public boolean doesOverlap(Course course, Student student, List<Course> coursesOfStudent) {
        if (coursesOfStudent.contains(course)) return false; //todo???
        for (int i = 1; i < rowNum; i++) {
            for (int j = 1; j < columnNum; j++) {
                if (student.getProgram()[i][j] && course.getProgram()[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
