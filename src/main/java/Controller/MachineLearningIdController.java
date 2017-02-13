package Controller;

import Pojo.Age;
import Pojo.CompleteIdentification;
import Pojo.Match;
import Pojo.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MachineLearningIdController {

    @RequestMapping("/api/getUserIdentification")
    @ResponseBody
    public CompleteIdentification greeting(
            @RequestHeader(value = "Authorization") String header,
            @RequestParam(value = "user_id") String userId) {
        List<Match> arr = new ArrayList<>();
        arr.add(new Match("dave", 8.8));
        User usr = new User("200", arr);
        Age age = new Age("200", "male", "88", "white");
        return new CompleteIdentification(usr, age);
    }
}
