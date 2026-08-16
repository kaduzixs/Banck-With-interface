package banck.client.kadu.Controller;


import banck.client.kadu.services.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/login")
    public String login(String userName, String userPassword) {
        boolean isLoggedIn = userService.userLogin(userName, userPassword);
        if (isLoggedIn) {
            return "Login successful!";
        } 
        return false ? "Login invalido" : "login errado!";
    }
}
