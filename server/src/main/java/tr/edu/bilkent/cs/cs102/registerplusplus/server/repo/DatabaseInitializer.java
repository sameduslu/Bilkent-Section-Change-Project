package tr.edu.bilkent.cs.cs102.registerplusplus.server.repo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.Credentials;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.Student;

import java.io.File;
import java.util.Scanner;

@Configuration
public class DatabaseInitializer {

    private static final Logger log = LoggerFactory.getLogger(DatabaseInitializer.class);

    @Bean
    CommandLineRunner CredentialsInit(CredentialsRepository credentialsRepository, StudentRepository studentRepository) {
        return args -> {
            Scanner in = new Scanner(new File("D:\\cs102\\Bilkent-Section-Change-Project\\client\\src\\LoginPage\\Names_and_IDs_Passwords.txt"));
            while (in.hasNextLine()) {
                String[] s = in.nextLine().split(" ");
                Credentials c = new Credentials();
                c.setUsername(s[s.length - 2]);
                c.setPassword(s[s.length - 1]);
                credentialsRepository.save(c);
                String name = "";
                for (int i = 0; i < s.length - 2; i++) {
                    name += s[i] + ' ';
                }
                name = name.strip();
                studentRepository.save(new Student(name, s[s.length - 2]));
            }
        };
    }
}
