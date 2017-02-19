package Controller;

import Controller.Repository.CredentialsRepository;
import Pojo.BaseMsg;
import Pojo.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    @Autowired
    private CredentialsRepository repository;

    @RequestMapping("/register")
    @ResponseBody
    public BaseMsg greeting(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password) {

        if(repository.findByEmail(email) != null){
            return new BaseMsg("400");
        } else {
            System.out.println("saved " + repository.save(new Credentials(name,password,email)).toString());
            return new BaseMsg("200");
        }
    }
}
