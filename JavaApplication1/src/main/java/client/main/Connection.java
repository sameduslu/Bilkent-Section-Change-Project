package client.main;


import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;

public class Connection {
    private static final Gson json = new Gson();
    private static final HttpClient client = HttpClientBuilder.create().build();

    public static Student updateStudent(String id) {
        HttpResponse response;
        String json1 = null;
        try {
            response = client.execute(new HttpGet("http://localhost:8080/student/" + id));
            json1 = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json.fromJson(json1, Student.class);
    }

    public static void main(String[] args) {
        Student s = updateStudent("1");
        System.out.println(s);
    }

    public static boolean authenticate(String id, String password) {
        HttpPost req = new HttpPost("http://localhost:8080/auth");
        HttpResponse response = null;
        String json1 = null;
        try {
            req.setEntity(new UrlEncodedFormEntity(List.of(
                    new BasicNameValuePair("id", id),
                    new BasicNameValuePair("password", password)
            )));
            response = client.execute(req);
            json1 = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return json.fromJson(json1, Boolean.class);
    }
}
