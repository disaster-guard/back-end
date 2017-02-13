package Controller;

import Pojo.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserRetrievalController {

    @RequestMapping("/api/nearByProfile")
    @ResponseBody
    public NearbyUserInfo greeting(
            @RequestHeader(value = "Authorization") String header,
            @RequestParam(value = "email") String email) {

        return new NearbyUserInfo(
                "http://images.mentalfloss.com/sites/default/files/styles/article_640x430/public/rickrollheader.png",
                "Darrien Glasser");
    }
}
