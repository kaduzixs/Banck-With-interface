# Documentação do Projeto

> ⚠️ **Status:** projeto em desenvolvimento (ainda não finalizado). Esta documentação reflete o que já foi implementado até o momento e será atualizada conforme o projeto evolui.

## Visão Geral

Este é um projeto de API desenvolvido em **Java** com **Spring Boot**, seguindo a arquitetura em camadas padrão do Spring (Controller → Service → Repository/Banco de Dados).

O projeto conta atualmente com dois módulos principais:

- **User** — responsável pela autenticação e cadastro de usuários.
- **Conta** — responsável pelas operações relacionadas a contas.

## Arquitetura

O projeto segue o padrão de separação de responsabilidades:

```
Controller  →  recebe as requisições HTTP e repassa para a camada de serviço
Service     →  contém a lógica de negócio e a comunicação com o banco de dados
```

Cada um dos dois módulos (`Conta` e `User`) possui seu próprio Controller e seu próprio Service correspondente.

```
src/
└── main/
    └── java/
        └── .../
            ├── controller/
            │   ├── UserController.java
            │   └── ContaController.java
            └── service/
                ├── UserService.java
                └── ContaService.java
```

---

## Módulo: User

### `UserController`

Controller responsável pelas operações relacionadas ao usuário. Consome o `UserService` para executar as funções de banco de dados.

**Funcionalidades atuais:**

| Funcionalidade | Descrição |
|---|---|
| Login | Autentica um usuário existente no sistema |
| Cadastro | Registra um novo usuário no banco de dados |

**Endpoints (sugestão de padrão a confirmar/ajustar conforme implementação real):**

| Método | Rota | Descrição |
|---|---|---|
| `POST` | `/user/login` | Realiza o login do usuário |
| `POST` | `/user/register` | Cadastra um novo usuário |

### `UserService`

Camada de serviço responsável pela lógica de negócio do módulo de usuário, incluindo:
- Validação de credenciais no login.
- Persistência dos dados de um novo usuário no cadastro.

---

## Módulo: Conta

### `ContaController`

Controller responsável pelas operações relacionadas à conta do usuário. Assim como o `UserController`, consome seu respectivo service (`ContaService`) para executar as funções de banco de dados.

### `ContaService`

Camada de serviço com a lógica de negócio das operações de conta, incluindo a comunicação com o banco de dados.

### Classe privada `conta`

Existe uma classe privada chamada `conta`, utilizada para **criar uma conta zerada para fins de teste**. Ela serve como uma estrutura auxiliar/mock para validar o funcionamento do módulo antes da implementação completa das regras de negócio.

---

## Tecnologias Utilizadas

- **Java**
- **Spring Boot**
- Arquitetura REST (API)