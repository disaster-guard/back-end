package Controller;

import Controller.Repository.FlareRepository;
import Pojo.BaseMsg;
import Pojo.Flare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FlareController {

    @Autowired
    private FlareRepository repository;

    @RequestMapping("/api/flare")
    @ResponseBody
    public BaseMsg greeting(
            @RequestHeader(value = "Authorization") String header,
            @RequestParam(value = "longitude") double longitude,
            @RequestParam(value = "lat") double lat,
            @RequestParam(value = "user_id") String userId) {

        if(repository.findByUserId(userId) != null){
            System.out.println("removed flare #" + repository.removeByUserId(userId).toString());
            return new BaseMsg("200");
        } else {
            Flare flare = new Flare(longitude,lat,userId);
            System.out.println("saved " + repository.save(flare).toString());
            return new BaseMsg("200");
        }
    }
}
