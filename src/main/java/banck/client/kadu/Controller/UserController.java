package banck.client.kadu.Controller;


import banck.client.kadu.services.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public boolean login(String userName, String userPassword){
        boolean userLogged = userService.userLogin(userName, userPassword);
        if (userLogged){
            System.out.println("Login succesfull!!");
            return true;
        } 
        return false;
    }
}
