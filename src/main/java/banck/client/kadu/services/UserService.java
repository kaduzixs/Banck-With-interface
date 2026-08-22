package banck.client.kadu.services;

// imports

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
@Service
public class UserService {

    // criando uma lista ordenada de map
    private Map<String, String> usuarios = new HashMap<>();

    // criando uma funcao para colocar usuario de teste
    public UserService() {
        usuarios.put("joao", "123456"); // usuário de teste
    }

    // 
    public boolean registerUser(String userName, String userPassword) {
        // verificacao se as chaves sao verdadeiras do hashmap com (containskey)
        if (usuarios.containsKey(userName)) {
            return false;
        }
        // usuario coloca os parametros e retorna verdadeiro
        usuarios.put(userName, userPassword);
        return true;
    }

    // verificacao de login, se os logs de parametros estiverem certos o user entra
    public boolean login(String userName, String userPassword) {
        return usuarios.containsKey(userName) && usuarios.get(userName).equals(userPassword);
    }

    // Banco de dados
    private UserRepository userRepository;

    public UserRepository register(String email, String senha, String nome) {
        UserRepository user = new UserRepository(email, senha, nome);
        return userRepository.save(user);
    }

    public Optional<UserRepository> login(String email, String password) {
        return userRepository.findByEmail(email)
                .filter(usuarios -> usuarios.getPassword().equals(password));
    }
}
   



