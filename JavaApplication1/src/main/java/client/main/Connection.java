package client.main;

import com.google.gson.Gson;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Connection {
    private static final Gson json = new Gson();
    private static final CloseableHttpClient client = HttpClientBuilder.create().build();

    private static final String ipAddress = "http://localhost:8080";

    public static boolean authenticate(String id, String password) {
        HttpPost req = new HttpPost(ipAddress + "/auth");
        String jsonString = null;
        try {
            req.setEntity(new UrlEncodedFormEntity(List.of(
                    new BasicNameValuePair("id", id),
                    new BasicNameValuePair("password", password)
            )));
            CloseableHttpResponse response = client.execute(req);
            jsonString = EntityUtils.toString(response.getEntity());
            response.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return json.fromJson(jsonString, Boolean.class);
    }

    public static void sendSingleRequest(String ownerStudentId, String wantedCourseId) {
        HttpPost post = new HttpPost(ipAddress + "/singleRequest");
        try {
            post.setEntity(new UrlEncodedFormEntity(List.of(
                    new BasicNameValuePair("ownerStudentId", ownerStudentId),
                    new BasicNameValuePair("wantedCourseId", wantedCourseId))));
            client.execute(post).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendForumRequest(ForumRequest forumRequest) {
        HttpPost post = new HttpPost(ipAddress + "/forumRequest");
        try {
            post.setEntity(new UrlEncodedFormEntity(List.of(
                    new BasicNameValuePair("studentId", forumRequest.getRequestOwner().getId()),
                    new BasicNameValuePair("wantedCourseId", forumRequest.getWantedCourse().getId()))));
            client.execute(post).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static List<Course> getAllCoursesFromServer() {
        String jsonString;
        List<Course> courses = null;
        try {
            jsonString = getRequest(new HttpGet(ipAddress + "/courses"));
            Course[] a = json.fromJson(jsonString, Course[].class);
            courses = Arrays.asList(a);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return courses;
    }

    public static Course[][] getStudentCourseSchedule(String id) {
        String jsonString;
        Course[][] result;
        try {
            jsonString = getRequest(new HttpGet(ipAddress + "/studentSchedule/" + id));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        result = json.fromJson(jsonString, Course[][].class);
        return result;
    }

    public static void sendMultipleRequest(String id, List<String> courseIds) {
        Student s = new Student("", id);
        List<Course> wanted = new ArrayList<>();
        for (String courseId : courseIds) {
            Course c = new Course(null, null, null, null);
            c.setId(courseId);
            wanted.add(c);
        }
        MultipleRequest multipleRequest = new MultipleRequest(s, wanted);
        String jsonString = json.toJson(multipleRequest);
        HttpPost post = new HttpPost(ipAddress + "/multipleRequest");
        postJson(jsonString, post);
    }

    public static void sendForumRequestApproval(ForumRequestApproval forumRequestApproval) {
        String jsonString = json.toJson(forumRequestApproval);
        HttpPost post = new HttpPost(ipAddress + "/forumRequest-approval");
        postJson(jsonString, post);
    }

    private static void postJson(String jsonString, HttpPost post) {
        post.setHeader("Accept", "application/json");
        post.setHeader("Content-type", "application/json");
        try {
            post.setEntity(new StringEntity(jsonString));
            CloseableHttpResponse resp = client.execute(post);
            resp.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<ForumRequest> getForumRequestsStudentCanAccept(String studentId) {
        String jsonString = null;
        try {
            jsonString = getRequest(new HttpGet(ipAddress + "/forumRequests/" + studentId));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Arrays.asList(json.fromJson(jsonString, ForumRequest[].class));
    }

    public static Student getUpdatedStudent(String id) {
        String json1 = null;
        try {
            HttpGet request = new HttpGet(ipAddress + "/student/" + id);
            json1 = getRequest(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Student s = json.fromJson(json1, Student.class);
        s.setCourseSchedule(Connection.getStudentCourseSchedule(s.getId()));
        return s;
    }

    private static String getRequest(HttpGet request) throws IOException {
        String json1;
        try (CloseableHttpResponse response = client.execute(request)) {
            json1 = EntityUtils.toString(response.getEntity());
        }
        return json1;
    }
}
