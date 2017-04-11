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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public String greeting(HttpServletRequest request) {

//        if (!this.clientSecret.equals(clientSecret)) {
//            throw new BadSecretException();
//        } else {
//            Credentials credentials = repository.findByEmail(email);
//            if (credentials == null) {
//                System.out.println("Thing is null");
//                throw new UserNotFoundException();
//            }
//
//            if (!credentials.getPassword().equals(password)) {
//                throw new LoginFailedException();
//            }
//

//            int id = (int) (Math.random() * (50000));
//            sessionRepository.save(new SessionId(id));
//            return new UserToken(id);

        System.out.println(request.getParameter("json"));
        return request.getParameter("json");
//        }
    }
}
