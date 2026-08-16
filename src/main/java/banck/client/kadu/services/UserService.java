package banck.client.kadu.services;


import java.util.ArrayList;
import java.util.List;
public class UserService {
    // Criar funcoes para que quando o usuario chamar a requisicao
    //chamar a funcao, que no caso e o login
    private String userName;
    private String userPassword;
    private String email;
    private String cpf;

    // criacao de uma lista de usuarios ordenada.
    private static List<UserService> users = new ArrayList<>();

    public UserService(){}

    // constructor da criacao de usuario
    public void constructor(String userName, String userPassword, String email, String cpf){
        this.userName = userName;
        this.userPassword = userPassword;
        this.email = email;
        this.cpf = cpf;
    }

    // Criacao dos gets
    public String getName(){
        return userName;
    }
    public String getPassword(){
        return userPassword;
    }
    public String getEmail(){
        return email;
    }
    public String getCpf(){
        return cpf;
    }

    // criacao de function de registerUser puxando a lista ordenada
    public void cadastrarUser(UserService newUser){
        users.add(newUser);
    }

    // verificacao de usuario, se o usuario pegar o nome e for igual retorna true, senao retorna false
    public static boolean userLogin(String userName, String userPassword){
            for (UserService newUsers : users){
                if(newUsers.getName().equals(userName) && newUsers.getPassword().equals(userPassword)){
                    return true;
                }
            }
            return false;
            }

    }

   



