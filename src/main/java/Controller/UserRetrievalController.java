package Controller;

import Controller.Repository.CredentialsRepository;
import Exceptions.UserNotFoundException;
import Pojo.Credentials;
import Pojo.NearbyUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserRetrievalController {

    @Autowired
    CredentialsRepository repository;

    @RequestMapping("/api/nearByProfile")
    public NearbyUserInfo greeting(
            @RequestHeader(value = "Authorization") String header,
            @RequestParam(value = "email") String email) {

        Credentials credentials = repository.findByEmail(email);

        if (credentials == null) {
            throw new UserNotFoundException();
        }

        return new NearbyUserInfo(
                "http://eadb.org/wp-content/uploads/2015/08/profile-placeholder.jpg",
                credentials.getName());
    }
}
