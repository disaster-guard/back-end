package Controller;

import Pojo.UserId;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserIdController {

    @RequestMapping("/api/getUserId")
    public UserId greeting(
            @RequestHeader(value = "Authorization") String header,
            @RequestParam(value = "email") String email) {

        return new UserId(200);
    }
}
