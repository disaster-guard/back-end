package Controller;

import Controller.Repository.CredentialsRepository;
import Controller.Repository.SessionRepository;
import Exceptions.BadSecretException;
import Exceptions.LoginFailedException;
import Exceptions.UserNotFoundException;
import Pojo.Credentials;
import Pojo.SessionId;
import Pojo.UserToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


/**
 * Allow user to register.
 */
@RestController
public class LoginController {

    @Autowired
    private CredentialsRepository repository;

    @Autowired
    private SessionRepository sessionRepository;

    /**
     * Ensure data comes from verified source.
     */
    private String clientSecret = "p7lrAtXIa15549Qq5a8gGNoOzuVwYRQfOYTcMWyh";

    @RequestMapping("/oauth")
    @ResponseBody
    public UserToken greeting(
//            @RequestParam(value = "grant_type") String grantType,
            @RequestParam(value = "client_id") String clientId,
            @RequestParam(value = "clientSecret") String clientSecret,
            @RequestParam(value = "username") String email,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "scope") String scope) {

        if (!this.clientSecret.equals(clientSecret)) {
            throw new BadSecretException();
        } else {
            Credentials credentials = repository.findByEmail(email);
            if (credentials == null) {
                System.out.println("Thing is null");
                throw new UserNotFoundException();
            }

            if (!credentials.getPassword().equals(password)) {
                throw new LoginFailedException();
            }

            String id = String.valueOf(UUID.randomUUID());
            sessionRepository.save(new SessionId(id));
            return new UserToken(id);
        }
    }
}
