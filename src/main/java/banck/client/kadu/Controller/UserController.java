package banck.client.kadu.Controller;


import banck.client.kadu.services.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService user;

    public UserController(UserService user){
        this.user = user;
    }
    public void login(String userName, String password, char cpf, String email){

    }
}
