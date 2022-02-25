package clone.instargram.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class UserController {

    @GetMapping("/story")
    public String story(){
        return "story";
    }

    @GetMapping("/profile")
    public String profile(){
        return "profile";
    }
}
