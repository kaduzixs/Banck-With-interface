package banck.client.kadu.Controller;


import banck.client.kadu.services.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String userName, @RequestParam String userPassword) {
        boolean autentic = userService.login(userName, userPassword);

        if(autentic) {
            return ResponseEntity.ok("login realized with success!!");
        }
        // exigicao de login valido com UNAUTHORIZED
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Name or Passwords invalid");
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestParam String userName, @RequestParam String userPassword) {
        boolean register = userService.registerUser(userName, userPassword);

        if (register) {
            return ResponseEntity.ok("User registerd with success!!");
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Name already register");
        }
    }
}
