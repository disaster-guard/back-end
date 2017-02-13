package Controller;

import Pojo.BaseMsg;
import Pojo.UserId;
import org.springframework.web.bind.annotation.*;

@RestController
public class IdController {

    @RequestMapping("/api/getUserId")
    public UserId greeting(
            @RequestHeader(value = "Authorization") String header,
            @RequestParam(value = "email") String email) {

        return new UserId(200);
    }
}
