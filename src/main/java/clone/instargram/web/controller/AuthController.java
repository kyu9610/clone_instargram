package clone.instargram.web.controller;

import clone.instargram.domain.user.User;
import clone.instargram.service.AuthService;
import clone.instargram.web.dto.UserLoginDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class AuthController {
    private final AuthService authService;

    @GetMapping({"/login" , "/"})
    public String LoginForm(){
        return "login";
    }

    @GetMapping("/signup")
    public String SignupForm(){
        return "signup";
    }

    @PostMapping("/signup")
    public String Signup(UserLoginDto userLoginDto){
        User user = userLoginDto.toEntity();

        User userEntity = authService.signup(user);
        if(userEntity == null){
            return "redirect:/signup?error";
        }
        return "redirect:/login";
    }
}
