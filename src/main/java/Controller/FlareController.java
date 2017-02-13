package Controller;

import Pojo.BaseMsg;
import org.springframework.web.bind.annotation.*;

@RestController
public class FlareController {

    @RequestMapping("/api/flare")
    @ResponseBody
    public BaseMsg greeting(
            @RequestHeader(value = "Authorization") String header,
            @RequestParam(value = "longitude") double longitude,
            @RequestParam(value = "lat") double lat,
            @RequestParam(value = "user_id") int userId,
            @RequestParam(value = "type") String type) {

        return new BaseMsg("200");
    }
}
