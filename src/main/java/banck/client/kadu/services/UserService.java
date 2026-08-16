package banck.client.kadu.services;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
@Service
public class UserService {

    private Map<String, String> usuarios = new HashMap<>();

    public UserService() {
        usuarios.put("joao", "123456"); // usuário de teste
    }

    public boolean cadastrarUser(String userName, String userPassword) {
        if (usuarios.containsKey(userName)) {
            return false;
        }
        usuarios.put(userName, userPassword);
        return true;
    }

    public boolean login(String userName, String userPassword) {
        return usuarios.containsKey(userName) && usuarios.get(userName).equals(userPassword);
    }
}
   



