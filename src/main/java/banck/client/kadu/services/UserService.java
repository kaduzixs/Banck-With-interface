package banck.client.kadu.services;

public class UserService {
    // Criar funcoes para que quando o usuario chamar a requisicao
    //chamar a funcao, que no caso e o login
    private String userName;
    private String userPassword;
    private String email;
    private char cpf;

    public String getName(){
        return userName;
    }
    public String getPassword(){
        return userPassword;
    }
    public String getEmail(){
        return email;
    }
    public char getCpf(){
        return cpf;
    }

   


}
