package tr.edu.bilkent.cs.cs102.registerplusplus.server.service;

import org.springframework.stereotype.Service;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.Course;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.MultipleRequest;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.SingleRequest;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.Student;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.repo.MultipleRequestRepository;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.repo.SingleRequestRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class RequestProcessorService {

    private final CourseService courseService;

    private final SingleRequestRepository singleRequestRepository;

    private final MultipleRequestRepository multipleRequestRepository;


    public RequestProcessorService(CourseService courseService, SingleRequestRepository singleRequestRepository, MultipleRequestRepository multipleRequestRepository) {
        this.courseService = courseService;
        this.singleRequestRepository = singleRequestRepository;
        this.multipleRequestRepository = multipleRequestRepository;
    }


    public void processRequests() {
        List<SingleRequest> singleRequests = singleRequestRepository.findAll();
        List<MultipleRequest> multipleRequests = multipleRequestRepository.findAll();
        Collections.sort(singleRequests);
        Collections.sort(multipleRequests);
        int i1 = 0, i2 = 0;
        while (i1 < singleRequests.size() && i2 < multipleRequests.size()) {
            SingleRequest singleRequest = singleRequests.get(i1);
            MultipleRequest multipleRequest = multipleRequests.get(i2);
            if (singleRequest.compareTo(multipleRequest) <= 0) {
                boolean b = processSingleRequest(singleRequest);
                if (b) {
                    i1 = 0;
                    i2 = 0;
                    singleRequests = singleRequestRepository.findAll();
                    continue;
                }
                i1++;
            } else {
                boolean b = processMultipleRequest(multipleRequest);
                if (b) {
                    i1 = 0;
                    i2 = 0;
                    multipleRequests = multipleRequestRepository.findAll();
                    continue;
                }
                i2++;
            }
        }
        while (i1 < singleRequests.size()) {
            boolean b = processSingleRequest(singleRequests.get(i1));
            if (b) {
                i1 = 0;
                singleRequests = singleRequestRepository.findAll();
                continue;
            }
            i1++;
        }
        while (i2 < multipleRequests.size()) {
            boolean b = processMultipleRequest(multipleRequests.get(i2));
            if (b) {
                i2 = 0;
                multipleRequests = multipleRequestRepository.findAll();
                continue;
            }
            i2++;
        }
    }

    private boolean processMultipleRequest(MultipleRequest req) {
        List<Course> wantedCourses = req.getWantedCourses();
        Student owner = req.getRequestOwner();
        List<Course> courseByStudentId = courseService.getCourseByStudentId(owner);
        List<Course> newCourses = new ArrayList<>();
        List<Course> alreadyTaking = new ArrayList<>();
        for (Course c : wantedCourses) {
            if (isFull(c)) {
                return false;
            }
            if (courseByStudentId.contains(c)) {
                alreadyTaking.add(c);
            } else {
                newCourses.add(c);
            }
        }
        boolean[][] originalProgram = owner.getProgram();
        boolean[][] tempProgram = new boolean[originalProgram.length][];
        for (int i = 0; i < originalProgram.length; i++) {
            tempProgram[i] = originalProgram[i].clone();
        }
        for (Course c : alreadyTaking) {
            Course course = courseByStudentId.stream().filter(co -> co.getName().equals(c.getName())).findAny().get();
            courseChangeTempProgram(course, tempProgram);
        }
        for (Course c : wantedCourses) {
            boolean[][] wantedProgram = c.getProgram();
            for (int i = 0; i < tempProgram.length; i++) {
                for (int j = 0; j < tempProgram[i].length; j++) {
                    if (wantedProgram[i][j] && tempProgram[i][j]) {
                        return false;
                    }
                    if (!tempProgram[i][j] && wantedProgram[i][j]) {
                        tempProgram[i][j] = true;
                    }
                }
            }
        }
        for (Course c : newCourses) {
            courseService.addStudentToCourse(owner, c);
        }
        for (Course c : alreadyTaking) {
            Course changingCourse = courseByStudentId.stream().filter(co -> co.getName().equals(c.getName())).findAny().get();
            courseService.removeStudentFromCourse(owner, changingCourse);
            courseService.addStudentToCourse(owner, c);
        }
        multipleRequestRepository.delete(req);
        return true;
    }

    private boolean processSingleRequest(SingleRequest req) {
        Student owner = req.getRequestOwner();
        List<Course> courseByStudentId = courseService.getCourseByStudentId(owner);
        Course wanted = req.getWantedCourse();
        if (courseByStudentId.contains(wanted)) {
            singleRequestRepository.delete(req);
            // return error
            return true;
        }
        if (isFull(wanted)) return false;

        if (doesStudentTakeCourse(wanted, courseByStudentId)) {
            return processSectionChangeRequest(req, courseByStudentId);
        }
        return processNewCourseRequest(req, courseByStudentId);
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

    private boolean processSectionChangeRequest(SingleRequest req, List<Course> courseByStudentId) {
        Student owner = req.getRequestOwner();
        Course wanted = req.getWantedCourse();
        boolean[][] wantedProgram = wanted.getProgram();
        Course course = courseByStudentId.stream().filter(c -> c.getName().equals(wanted.getName())).findAny().get(); //todo isPresent check?
        boolean[][] originalProgram = owner.getProgram();
        boolean[][] tempProgram = new boolean[originalProgram.length][];
        for (int i = 0; i < originalProgram.length; i++) {
            tempProgram[i] = originalProgram[i].clone();
        }
        courseChangeTempProgram(course, tempProgram);
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

    private void courseChangeTempProgram(Course course, boolean[][] tempProgram) {
        boolean[][] courseProgram = course.getProgram();
        for (int i = 0; i < courseProgram.length; i++) {
            for (int j = 0; j < courseProgram[i].length; j++) {
                if (courseProgram[i][j]) {
                    tempProgram[i][j] = false;
                }
            }
        }
    }

    private boolean doesStudentTakeCourse(Course wanted, List<Course> coursesByStudentId) {
        return coursesByStudentId.stream().anyMatch(c -> c.getName().equals(wanted.getName()));
    }


    public boolean isFull(Course c) {
        return c.getStudents().size() >= Course.QUOTA;
    }

    public boolean doesOverlap(Course course, Student student, List<Course> coursesOfStudent) {
        if (coursesOfStudent.contains(course)) return false;
        boolean[][] studentProgram = student.getProgram();
        boolean[][] courseProgram = course.getProgram();
        for (int i = 1; i < studentProgram.length; i++) {
            for (int j = 1; j < studentProgram[i].length; j++) {
                if (studentProgram[i][j] && courseProgram[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
