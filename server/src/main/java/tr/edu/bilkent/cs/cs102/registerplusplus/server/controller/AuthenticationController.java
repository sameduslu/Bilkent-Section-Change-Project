package tr.edu.bilkent.cs.cs102.registerplusplus.server.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.Credentials;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.repo.CredentialsRepository;

import java.util.List;

@RestController
public class AuthenticationController {
    private final CredentialsRepository credentialsRepository;

    public AuthenticationController(CredentialsRepository credentialsRepository) {
        this.credentialsRepository = credentialsRepository;
    }

    @PostMapping(value = "/auth")
    public Boolean authenticate(@RequestParam String id, @RequestParam String password) {
        List<Credentials> credentialsByUsername = credentialsRepository.findCredentialsByUsername(id);
        if (credentialsByUsername.isEmpty()) {
            return false;
        }
        return credentialsByUsername.get(0).getPassword().equals(password);
    }
}
