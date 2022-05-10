package client.main;

import client.LoginPage.LoginPage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Register {

    private static Queue<Request> requestQueue = new LinkedList<>();
    private static Courses allCourses;
    private static ArrayList<Student> allStudents;
    private static ArrayList<Request> forumRequests = new ArrayList<>();

    public static void main(String[] args) {
        allStudents = addStudents();

        allCourses = addCourses();

        Courses cs102Courses, math102Courses, math132Courses, eng102Courses;
        cs102Courses = new Courses();
        math102Courses = new Courses();
        math132Courses = new Courses();
        eng102Courses = new Courses();

        /* for(int i = 0; i < allCourses.getSize(); i++) {
            System.out.println(allCourses.getCourse(i).toString());
            allCourses.getCourse(i).printProgram();
        } */


        for (int i = 0; i < allCourses.getSize(); i++) {
            Course tempCourse = allCourses.getCourse(i);

            if (tempCourse.getName().equals("CS102")) {
                cs102Courses.addCourse(tempCourse);
            }

            if (tempCourse.getName().equals("MATH102")) {
                math102Courses.addCourse(tempCourse);
            }

            if (tempCourse.getName().equals("MATH132")) {
                math132Courses.addCourse(tempCourse);
            }

            if (tempCourse.getName().equals("ENG102")) {
                eng102Courses.addCourse(tempCourse);
            }
        }

        ArrayList<Courses> allPaths = new ArrayList<Courses>();

        for (int i = 0; i < cs102Courses.getSize(); i++) {
            Courses possiblePath = new Courses();
            Course csCourse = cs102Courses.getCourse(i);
            possiblePath.addCourse(csCourse);
            for (int j = 0; j < math102Courses.getSize(); j++) {
                Course math102Course = math102Courses.getCourse(j);
                if (csCourse.doesOverlap(math102Course)) {
                    continue;
                } else {
                    possiblePath.addCourse(math102Course);
                }
                for (int u = 0; u < math132Courses.getSize(); u++) {
                    Course math132Course = math132Courses.getCourse(u);
                    if (csCourse.doesOverlap(math132Course) || math102Course.doesOverlap(math132Course)) {
                        continue;
                    } else {
                        possiblePath.addCourse(math132Course);
                    }
                    for (int p = 0; p < eng102Courses.getSize(); p++) {
                        Course engCourse = eng102Courses.getCourse(p);
                        if (csCourse.doesOverlap(engCourse) || math102Course.doesOverlap(engCourse)
                                || math132Course.doesOverlap(engCourse)) {
                            continue;
                        } else {
                            possiblePath.addCourse(engCourse);
                            Courses addThat = new Courses();
                            for (int pp = 0; pp < possiblePath.getSize(); pp++) {
                                addThat.addCourse(possiblePath.getCourse(pp));
                            }
                            allPaths.add(addThat);
                        }
                        if (possiblePath.getSize() == 4) {
                            possiblePath.removeCourse(engCourse);
                        }
                    }
                    if (possiblePath.getSize() == 3) {
                        possiblePath.removeCourse(math132Course);
                    }
                }
                if (possiblePath.getSize() == 2) {
                    possiblePath.removeCourse(math102Course);
                }
            }
            if (possiblePath.getSize() == 1) {
                possiblePath.removeCourse(csCourse);
            }
        }
        
        /*for (int i = 0; i < allPaths.size(); i++) {
            System.out.println("Path: " + (i+1));
            for (int j = 0; j < allPaths.get(i).getSize(); j++) {
                System.out.println(allPaths.get(i).getCourse(j).toString());
            }
            System.out.println();
        }*/

        Random rand = new Random();

        for (int i = 0; i < allStudents.size(); i++) {

            boolean isHappened = false;

            int cnt = 0;

            while (!isHappened) {

                int pathNumber = rand.nextInt(allPaths.size());

                if (cnt == 1000) {
                    break;
                }

                boolean ctr = true;

                for (int j = 0; j < allPaths.get(pathNumber).getSize(); j++) {
                    ctr &= allPaths.get(pathNumber).getCourse(j).isThereQuota();
                    ctr &= !(allStudents.get(i).doesOverlap(allPaths.get(pathNumber).getCourse(j)));
                    //System.out.println(ctr + " " + pathNumber);
                }

                if (ctr) {
                    for (int j = 0; j < allPaths.get(pathNumber).getSize(); j++) {
                        allPaths.get(pathNumber).getCourse(j).addStudent(allStudents.get(i));
                    }
                    isHappened = true;
                }
                cnt++;
            }

            if (cnt == 1000) {
                System.out.println("It is impossible to arrange students!" + i);
                break;
            }
        }

        for (int i = 0; i < allStudents.size(); i++) {
            System.out.println("Student" + (i + 1) + "'s program: ");
            allStudents.get(i).printSchedule();
        }

        for (int i = 0; i < allCourses.getSize(); i++) {
            System.out.println(allCourses.getCourse(i).isThereQuota());
        }
        LoginPage loginpage = new LoginPage(allCourses);
        loginpage.setVisible(true);
        loginpage.setLocationRelativeTo(null);
        //test();

    }

    private static ArrayList<Student> addStudents() {
        ArrayList<Student> result = new ArrayList<>();
        try {
            File database = new File("D:\\cs102\\Bilkent-Section-Change-Project\\JavaApplication1\\src\\main\\resources\\Names_and_IDs.txt");
            Scanner sc = new Scanner(database);
            while (sc.hasNextLine()) {
                String name = sc.next();
                String surname = sc.next();
                name += (" " + surname);
                String id = sc.next();
                Student st = new Student(name, id);
                result.add(st);
            }
        } catch (FileNotFoundException err) {
            System.out.println("Error occured!");
            err.printStackTrace();
        }


        return result;
    }

    private static Courses addCourses() {
        Courses result = new Courses();
        try {
            File database = new File("D:\\cs102\\Bilkent-Section-Change-Project\\JavaApplication1\\src\\main\\resources\\Course_Database.txt");
            Scanner sc = new Scanner(database);
            int id = 1000;
            while (sc.hasNextLine()) {
                String name, section, insName, insSurname, insID;
                Instructor instructor;
                boolean[][] program = new boolean[Person.rowNum][Person.columnNum];
                name = sc.next();
                section = sc.next();
                insName = sc.next();
                insSurname = sc.next();
                insName += (" " + insSurname);
                insID = "" + id;
                instructor = new Instructor(insName, insID);
                for (int i = 0; i < Person.rowNum; i++) {
                    for (int j = 0; j < Person.columnNum; j++) {
                        int check = sc.nextInt();
                        if (check == 1) {
                            program[i][j] = true;
                        } else {
                            program[i][j] = false;
                        }
                    }
                }
                Course lesson = new Course(name, section, program, instructor);
                instructor.addCourse(lesson);
                result.addCourse(lesson);
                id++;
            }
        } catch (FileNotFoundException err) {
            System.out.println("Error occured!");
            err.printStackTrace();
        }
        return result;
    }

    /**
     * This method add given request to queue
     */
    protected static void addRequestToQueue(Request r) {
        requestQueue.add(r);
    }

    /**
     * This method add request to the forum
     */
    protected static void addRequestToForum(Request r) {
        forumRequests.add(r);
    }

    /**
     * This method removes request from the queue when student want
     */
    protected static void removeRequestFromQueue(Request r) {
        requestQueue.remove(r);
    }

    /**
     * This method removes request from the forum when student want
     */
    protected static void removeRequestFromForum(Request r) {
        forumRequests.remove(r);
    }


    /**
     * This method checks the applicability of the requests
     */
    private static void checkTheRequests() {
        for (int i = 0; i < requestQueue.size(); i++) {
            Request currentRequest = ((LinkedList<Request>) requestQueue).get(i);
            if (!currentRequest.isStillValid()) {
                currentRequest.getRequestOwner().removeRequest(currentRequest);
                i--;
                continue;
            }
            if (currentRequest.isPossible()) {
                processRequest(currentRequest);
                currentRequest.getRequestOwner().removeRequest(currentRequest);
                i = 0;
            }
        }
    }

    /**
     * This method process the given request
     */
    private static void processRequest(Request r) {

        //If it is a single request
        if (r.getClass().getName().equals("SingleRequest")) {
            Course wanted = ((SingleRequest) r).getWantedCourse();
            Student owner = r.getRequestOwner();
            Course removeThat = null;
            for (int j = 0; j < owner.courses.getSize(); j++) {
                if (owner.courses.getCourse(j).getName().equals(wanted.getName())) {
                    removeThat = owner.courses.getCourse(j);
                }
            }
            removeThat.removeStudent(owner);
            wanted.addStudent(owner);
        }

        //If it is a multiple request
        else {
            Courses wanteds = ((MultipleRequest) r).getWantedCourses();
            Student owner = r.getRequestOwner();
            for (int p = 0; p < wanteds.getSize(); p++) {
                Course wanted = wanteds.getCourse(p);
                Course removeThat = null;
                for (int j = 0; j < owner.courses.getSize(); j++) {
                    if (owner.courses.getCourse(j).getName().equals(wanted.getName())) {
                        removeThat = owner.courses.getCourse(j);
                    }
                }
                removeThat.removeStudent(owner);
                wanted.addStudent(owner);
            }
        }
    }

    /**
     * This method process the request in the forum when the client accept the trade offer
     */
    protected static void processForumRequest(ForumRequest fr, Student acceptor) {
        Student owner = fr.getRequestOwner();
        fr.getWantedCourse().removeStudent(acceptor);
        fr.getCurrentCourse().removeStudent(owner);
        fr.getWantedCourse().addStudent(owner);
        fr.getCurrentCourse().addStudent(acceptor);
        fr.getRequestOwner().removeForumRequest(fr);
    }


    /**
     * This method checks the validity of the forum requests and remove the unvalid ones
     */
    public static void checkForumRequests() {
        for (int i = 0; i < forumRequests.size(); i++) {
            ForumRequest ff = (ForumRequest) forumRequests.get(i);
            if (!ff.isStillValid()) {
                ff.getRequestOwner().removeForumRequest(ff);
            }
        }
    }


    /**
     * This methods controls the functionality of requests
     */
    public static void test() {

        System.out.print("Enter the index of the wanted course for student 1: ");
        Student ss = allStudents.get(0);
        Scanner in = new Scanner(System.in);
        int wantedIndex = in.nextInt();
        Course cc = allCourses.getCourse(wantedIndex);
        ss.createSingleRequest(cc);
        checkTheRequests();
        ss.printSchedule();
        for (int i = 0; i < ss.courses.getSize(); i++) {
            System.out.println(ss.courses.getCourse(i));
        }


        System.out.print("Enter the number of the wanted courses for student 1: ");
        int kk = in.nextInt();
        Courses wanteds = new Courses();
        for (int i = 1; i <= kk; i++) {
            System.out.print("Enter the index of the wanted course for student 1: ");
            int wantedIndex1 = in.nextInt();
            wanteds.addCourse(allCourses.getCourse(wantedIndex1));
        }
        ss.createMultipleRequest(wanteds);
        checkTheRequests();
        ss.printSchedule();
        for (int i = 0; i < ss.courses.getSize(); i++) {
            System.out.println(ss.courses.getCourse(i));
        }


        System.out.print("Enter the index of the wanted course for student 1: ");
        wantedIndex = in.nextInt();
        cc = allCourses.getCourse(wantedIndex);
        ss.createSingleRequest(cc);
        checkTheRequests();
        ss.printSchedule();
        for (int i = 0; i < ss.courses.getSize(); i++) {
            System.out.println(ss.courses.getCourse(i));
        }
    }
}