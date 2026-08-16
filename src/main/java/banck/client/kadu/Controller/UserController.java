package banck.client.kadu.Controller;


import banck.client.kadu.services.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String userName, @RequestParam String userPassword) {
        boolean autenticado = userService.login(userName, userPassword);

        if (autenticado) {
            return ResponseEntity.ok("Login realizado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Nome ou senha inválidos");
        }
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrar(@RequestParam String userName, @RequestParam String userPassword) {
        boolean cadastrado = userService.cadastrarUser(userName, userPassword);

        if (cadastrado) {
            return ResponseEntity.ok("Usuário cadastrado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Nome já cadastrado");
        }
    }
}
