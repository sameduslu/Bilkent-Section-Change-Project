package tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.service;

import org.springframework.stereotype.Service;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.*;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.repo.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The class that has the methods to process every operation about the execution of the requests.
 */
@Service
public class RequestProcessorService {

    private final CourseService courseService;

    private final SingleRequestRepository singleRequestRepository;

    private final MultipleRequestRepository multipleRequestRepository;

    private final ForumRequestRepository forumRequestRepository;

    private final CourseRepository courseRepository;

    private final StudentService studentService;

    private final StudentRepository studentRepository;


    public RequestProcessorService(CourseService courseService, SingleRequestRepository singleRequestRepository, MultipleRequestRepository multipleRequestRepository, ForumRequestRepository forumRequestRepository, CourseRepository courseRepository, StudentService studentService, StudentRepository studentRepository) {
        this.courseService = courseService;
        this.singleRequestRepository = singleRequestRepository;
        this.multipleRequestRepository = multipleRequestRepository;
        this.forumRequestRepository = forumRequestRepository;
        this.courseRepository = courseRepository;
        this.studentService = studentService;
        this.studentRepository = studentRepository;
    }

    /**
     * This method first loads the non-forum requests from the database with the repository, and traverses through the
     * ordered lists of multiple and single requests. Lists are ordered with respect to the creation times of the
     * requests.
     */
    public void processNonForumRequests() {
        List<SingleRequest> singleRequests = singleRequestRepository.findAll(); //pull from db
        List<MultipleRequest> multipleRequests = multipleRequestRepository.findAll(); //pull from db
        Collections.sort(singleRequests); //sort
        Collections.sort(multipleRequests); //sort

        // A mergesort's-merge-like loop to traverse on the lists at the same time
        // Processes every possible requests till it is impossible to find any processable request at the beginnings.
        int i1 = 0, i2 = 0;
        while (i1 < singleRequests.size() || i2 < multipleRequests.size()) {
            if (i2 >= multipleRequests.size()) {
                SingleRequest singleRequest = singleRequests.get(i1);
                singleRequest.setRequestOwner(studentRepository.findById(singleRequest.getRequestOwner().getId()).get());
                singleRequest.setWantedCourse(courseRepository.findCourseById(singleRequest.getWantedCourse().getId()));
                // If request is no longer valid, delete it from the list and the db.
                if (!isStillValid(singleRequest.getWantedCourse(), singleRequest.getRequestOwner(), courseService.getCourseByStudentId(singleRequest.getRequestOwner()))) {
                    singleRequestRepository.delete(singleRequest);
                    singleRequests.remove(singleRequest);
                    continue;
                }
                // Process the request if possible and turn to the beginning, as there is now a chance to
                // execute the previous ones.
                boolean b = processSingleRequest(singleRequest);
                if (b) {
                    i1 = 0;
                    i2 = 0;
                    singleRequests = singleRequestRepository.findAll();
                    continue;
                }
                i1++;
                continue;
            }
            else if (i1 >= singleRequests.size()) {
                MultipleRequest multipleRequest = multipleRequests.get(i2);
                multipleRequest.setRequestOwner(studentRepository.findById(multipleRequest.getRequestOwner().getId()).get());
                List<Course> courses = new ArrayList<>();
                for (Course c : multipleRequest.getWantedCourses()) {
                    courses.add(courseRepository.findCourseById(c.getId()));

                }
                multipleRequest.setWantedCourses(courses);
                if (!isStillValid(multipleRequest.getWantedCourses(), multipleRequest.getRequestOwner(), courseService.getCourseByStudentId(multipleRequest.getRequestOwner()))) {
                    multipleRequestRepository.delete(multipleRequest);
                    multipleRequests.remove(multipleRequest);
                    continue;
                }
                boolean b = processMultipleRequest(multipleRequest);
                if (b) {
                    i1 = 0;
                    i2 = 0;
                    multipleRequests = multipleRequestRepository.findAll();
                    continue;
                }
                i2++;
                continue;
            }
            SingleRequest singleRequest = singleRequests.get(i1);
            singleRequest.setRequestOwner(studentRepository.findById(singleRequest.getRequestOwner().getId()).get());
            singleRequest.setWantedCourse(courseRepository.findCourseById(singleRequest.getWantedCourse().getId()));
            MultipleRequest multipleRequest = multipleRequests.get(i2);
            multipleRequest.setRequestOwner(studentRepository.findById(multipleRequest.getRequestOwner().getId()).get());
            List<Course> courses = new ArrayList<>();
            for (Course c : multipleRequest.getWantedCourses()) {
                courses.add(courseRepository.findCourseById(c.getId()));

            }
            multipleRequest.setWantedCourses(courses);
            if (singleRequest.compareTo(multipleRequest) <= 0) {
                if (!isStillValid(singleRequest.getWantedCourse(), singleRequest.getRequestOwner(), courseService.getCourseByStudentId(singleRequest.getRequestOwner()))) {
                    singleRequestRepository.delete(singleRequest);
                    singleRequests.remove(singleRequest);
                    continue;
                }
                boolean b = processSingleRequest(singleRequest);
                if (b) {
                    i1 = 0;
                    i2 = 0;
                    singleRequests = singleRequestRepository.findAll();
                    continue;
                }
                i1++;
            } else {
                if (!isStillValid(multipleRequest.getWantedCourses(), multipleRequest.getRequestOwner(), courseService.getCourseByStudentId(multipleRequest.getRequestOwner()))) {
                    multipleRequestRepository.delete(multipleRequest);
                    multipleRequests.remove(multipleRequest);
                    continue;
                }
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
    }

    /**
     * Places the student in the course and deletes the request.
     * @param req The single request to be executed
     * @return whether it is executed
     */
    private boolean processSingleRequest(SingleRequest req) {
        Student owner = req.getRequestOwner();
        List<Course> courseByStudentId = courseService.getCourseByStudentId(owner);
        Course wanted = req.getWantedCourse();
        if (Course.isFull(wanted)) return false;

        if (doesStudentTakeCourse(wanted, courseByStudentId)) {
            return processSectionChangeRequest(req, courseByStudentId);
        }
        return processNewCourseRequest(req, courseByStudentId);
    }

    /**
     * Adds the student in the new course and deletes the request.
     * @param req The single request to be executed
     * @param courseByStudentId All courses of the request owner
     * @return whether the request is executed
     */
    private boolean processNewCourseRequest(SingleRequest req, List<Course> courseByStudentId) {

        Student owner = req.getRequestOwner();
        Course wanted = req.getWantedCourse();
        if (doesOverlap(wanted, owner, courseByStudentId)) {
            singleRequestRepository.delete(req);
            return true;
        }
        courseService.addStudentToCourse(owner, wanted);
        singleRequestRepository.delete(req);
        updateForumRequests(req.getRequestOwner());
        return true;
    }

    /**
     * Changes the section of the student and deletes the request.
     * @param req The single request to be executed
     * @param courseByStudentId All courses of the request owner
     * @return whether the request is executed
     */
    private boolean processSectionChangeRequest(SingleRequest req, List<Course> courseByStudentId) {
        Student owner = req.getRequestOwner();
        Course wanted = req.getWantedCourse();
        Course course = courseByStudentId.stream().filter(c -> c.getName().equals(wanted.getName())).findAny().get();
        courseService.removeStudentFromCourse(owner, course);
        courseService.addStudentToCourse(owner, wanted);
        singleRequestRepository.delete(req);
        updateForumRequests(req.getRequestOwner());
        return true;
    }

    /**
     * Places the student in the wanted courses and deletes the request.
     * @param req The single request to be executed
     * @return whether it is executed
     */
    private boolean processMultipleRequest(MultipleRequest req) {
        List<Course> wantedCourses = req.getWantedCourses();
        Student owner = req.getRequestOwner();
        List<Course> courseByStudentId = courseService.getCourseByStudentId(owner);
        for (int p = 0; p < wantedCourses.size(); p++) {
            if (Course.isFull(wantedCourses.get(p))) {
                return false;
            }
        }
        for (int p = 0; p < wantedCourses.size(); p++) {
            Course wanted = wantedCourses.get(p);
            Course removeThat = null;
            for (int j = 0; j < courseByStudentId.size(); j++) {
                if (courseByStudentId.get(j).getName().equals(wanted.getName())) {
                    removeThat = courseByStudentId.get(j);
                }
            }
            if (doesStudentTakeCourse(removeThat, courseByStudentId)) {
                courseService.removeStudentFromCourse(owner, removeThat);
            }
            courseService.addStudentToCourse(owner, wanted);
        }
        multipleRequestRepository.delete(req);
        updateForumRequests(req.getRequestOwner());
        return true;
    }

    /**
     * When there is a change in the requests, this method is called to re-check the forum requests' validity
     * of the request owner. Deletes the invalid forum requests.
     * @param requestOwner the student
     */
    private void updateForumRequests(Student requestOwner) {
        List<ForumRequest> requests = forumRequestRepository.findForumRequestByRequestOwner_Id(requestOwner.getId());
        List<Course> courses = courseRepository.findCourseByStudentsId(requestOwner.getId());
        for (ForumRequest req : requests) {
            if (!courses.contains(req.getCurrentCourse()) || !isStillValid(req.getWantedCourse(), requestOwner, courses)) {
                forumRequestRepository.delete(req);//
            }
        }
    }


    /**
     * Executes the forum requests and swaps the sections of owner and acceptor.
     * @param req The request to be executed
     * @param acceptor the acceptor of the request
     * @return whether the request is executed
     */
    public boolean processForumRequest(ForumRequest req, Student acceptor) {
        acceptor = studentRepository.findById(acceptor.getId()).get();
        req.setRequestOwner(studentRepository.findById(req.getRequestOwner().getId()).get());
        req.setWantedCourse(courseRepository.findCourseById(req.getWantedCourse().getId()));
        req.setCurrentCourse(courseRepository.findCourseById(req.getCurrentCourse().getId()));
        if (!isForumRequestPossible(req, acceptor)) {
            return false;
        }
        courseService.removeStudentFromCourse(req.getRequestOwner(), req.getCurrentCourse());
        courseService.removeStudentFromCourse(acceptor, req.getWantedCourse());
        courseService.addStudentToCourse(req.getRequestOwner(), req.getWantedCourse());
        courseService.addStudentToCourse(acceptor, req.getCurrentCourse());
        forumRequestRepository.delete(req);
        acceptor = studentRepository.findById(acceptor.getId()).get();
        req.setRequestOwner(studentRepository.findById(req.getRequestOwner().getId()).get());
        updateForumRequests(req.getRequestOwner());
        updateForumRequests(acceptor);
        processNonForumRequests();
        return true;
    }

    public boolean isForumRequestPossible(ForumRequest req, Student acceptor) {
        boolean b = courseRepository.findCourseByStudentsId(acceptor.getId()).contains(req.getWantedCourse());
        boolean[][] acceptorProgram = cloneProgramOfStudent(acceptor);
        boolean[][] currentCourseProgram = req.getCurrentCourse().getProgram();
        Course[][] schedule = studentService.getSchedule(acceptor.getId());
        for (int i = 0; i < currentCourseProgram.length; i++) {
            for (int j = 0; j < currentCourseProgram[i].length; j++) {
                if (schedule[i][j] != null && schedule[i][j].getName().equals(req.getWantedCourse().getName())) {
                    continue;
                }
                if ((acceptorProgram[i][j] && currentCourseProgram[i][j])) {
                    return false;
                }
            }
        }
        return b;
    }

    private boolean[][] cloneProgramOfStudent(Student student) {
        boolean[][] originalProgram = student.getProgram();
        boolean[][] tempProgram = new boolean[originalProgram.length][];
        for (int i = 0; i < originalProgram.length; i++) {
            tempProgram[i] = originalProgram[i].clone();
        }
        return tempProgram;
    }

    private boolean doesStudentTakeCourse(Course wanted, List<Course> coursesByStudentId) {
        return coursesByStudentId.stream().anyMatch(c -> c.getName().equals(wanted.getName()));
    }


    public boolean doesOverlap(Course course, Student student, List<Course> coursesOfStudent) {
        if (coursesOfStudent.contains(course)) return true;
        return checkProgramOverlap(course.getProgram(), student.getProgram());
    }

    public static boolean checkProgramOverlap(boolean[][] courseProgram, boolean[][] studentProgram) {
        for (int i = 1; i < studentProgram.length; i++) {
            for (int j = 1; j < studentProgram[i].length; j++) {
                if (studentProgram[i][j] && courseProgram[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks the validity of the single section request
     * @param wantedCourse the wanted course of the request
     * @param student the request owner
     * @param coursesOfStudent the courses of the request owner
     * @return the validity
     */
    public boolean isStillValid(Course wantedCourse, Student student, List<Course> coursesOfStudent) {
        if (coursesOfStudent.contains(wantedCourse)) return false;
        boolean[][] studentProgram = student.getProgram();
        boolean[][] courseProgram = wantedCourse.getProgram();
        Course[][] studentSchedule = studentService.getSchedule(student.getId());
        for (int i = 1; i < studentProgram.length; i++) {
            for (int j = 1; j < studentProgram[i].length; j++) {
                if (studentProgram[i][j] && studentSchedule[i][j].getName().equals(wantedCourse.getName())) {
                    continue;
                }
                if (studentProgram[i][j] && courseProgram[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Checks the validity of the multiple section request
     * @param wantedCourses the wanted courses of the request
     * @param student the request owner
     * @param coursesOfStudent the courses of the request owner
     * @return the validity
     */
    public static boolean isStillValid(List<Course> wantedCourses, Student student, List<Course> coursesOfStudent) {
        List<Course> noIncluded = new ArrayList<>();

        //finding the courses which is not in the requesting courses and adding them to noIncluded 
        for (int i = 0; i < coursesOfStudent.size(); i++) {
            boolean ctr = true;
            for (int j = 0; j < wantedCourses.size(); j++) {
                if (wantedCourses.get(j).getName().equals(coursesOfStudent.get(i).getName())) {
                    ctr = false;
                }
            }
            if (ctr) {
                noIncluded.add(coursesOfStudent.get(i));
            }
        }

        //checking the compatibility of requesting courses and no included courses
        for (int i = 0; i < wantedCourses.size(); i++) {
            for (int j = 0; j < noIncluded.size(); j++) {
                if (wantedCourses.get(i).doesOverlap(noIncluded.get(j))) {
                    return false;
                }
            }
        }

        //checking the compatibility of requesting courses with each other
        for (int i = 0; i < wantedCourses.size(); i++) {
            for (int j = i + 1; j < wantedCourses.size(); j++) {
                if (wantedCourses.get(i).doesOverlap(wantedCourses.get(j))) {
                    return false;
                }
            }
        }

        return coursesOfStudent.stream().noneMatch(wantedCourses::contains);
    }
}
