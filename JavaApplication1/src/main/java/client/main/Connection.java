package client.main;


import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Connection {
    private static final Gson json = new Gson();
    private static final HttpClient client = HttpClientBuilder.create().build();

    public static boolean authenticate(String id, String password) {
        HttpPost req = new HttpPost("http://localhost:8080/auth");
        HttpResponse response;
        String jsonString = null;
        try {
            req.setEntity(new UrlEncodedFormEntity(List.of(
                    new BasicNameValuePair("id", id),
                    new BasicNameValuePair("password", password)
            )));
            response = client.execute(req);
            jsonString = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return json.fromJson(jsonString, Boolean.class);
    }

    public static void sendSingleRequest(String ownerStudentId, String wantedCourseId) {
        HttpPost post = new HttpPost("http://localhost:8080/singleRequest");
        try {
            post.setEntity(new UrlEncodedFormEntity(List.of(
                    new BasicNameValuePair("ownerStudentId", ownerStudentId),
                    new BasicNameValuePair("wantedCourseId", wantedCourseId))));
            HttpResponse response = client.execute(post);
            System.out.println(response.getStatusLine().getStatusCode());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Course> getAllCoursesFromServer() {
        HttpResponse response;
        String jsonString;
        List<Course> courses = null;
        try {
            response = client.execute(new HttpGet("http://localhost:8080/courses"));
            jsonString = EntityUtils.toString(response.getEntity());
            Course[] a = json.fromJson(jsonString, Course[].class);
            courses = Arrays.asList(a);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return courses;
    }

    public static Course[][] getStudentCourseSchedule(String id) {
        HttpResponse response;
        String jsonString;
        Course[][] result;
        try {
            response = client.execute(new HttpGet("http://localhost:8080/studentSchedule/" + id));
            jsonString = EntityUtils.toString(response.getEntity());
            result = json.fromJson(jsonString, Course[][].class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static Student getUpdatedStudent(String id) {
        HttpResponse response;
        String json1 = null;
        try {
            response = client.execute(new HttpGet("http://localhost:8080/student/" + id));
            json1 = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Student s = json.fromJson(json1, Student.class);
        s.setCourseSchedule(Connection.getStudentCourseSchedule(s.getId()));
        return s;
    }

    public static void sendMultipleRequest(String id, List<String> courseIds) {
        Student s = new Student("", id);
        List<Course> wanted = new ArrayList<>();
        for(int i = 0; i < courseIds.size(); i++) {
            Course c = new Course(null, null, null, null);
            c.setId(courseIds.get(i));
            wanted.add(c);
        }
        MultipleRequest multipleRequest = new MultipleRequest(s,wanted);
        String jsonString = json.toJson(multipleRequest);
//        courseIds.add(id);
//        String jsonString = json.toJson(courseIds);
//        System.out.println(jsonString);
        HttpPost post = new HttpPost("http://localhost:8080/multipleRequest");
        post.setHeader("Accept", "application/json");
        post.setHeader("Content-type", "application/json");
        try {
            post.setEntity(new StringEntity(jsonString));
            System.out.println(client.execute(post).getStatusLine().getStatusCode());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
