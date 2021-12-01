# BlueBankSquad6

Desafio final do curso da Gama Academy em parceria como Banco Pan.

### Squad 6:
- Guilherme Nunes
- Mariana Fonseca
- Miromar Junior
- Vinicius Menolli
- Jessica Kopps

### Tecnologias utilizadas:

- Spring Boot (Maven e JDK 11)
- DB Relacional MySQL
- Swagger
- Deploy na AWS

## Utilizando a aplicação:

- Requisitos:
  - Maven e JDK 11
- Passo a passo:
  - No terminal, dentro da aplicação, gere o .jar da aplicação executando o comando:
  ```
  mvn clean install -Dskiptests
  ```
  Caso o código acima não funcione, execute:
  ```
  ./mvnw clean install -DskipTests
  ```
- Rodar a aplicação:
```
???
```
- URL para acesso local:
  - http://localhost:5000

## Endpoints:

| Método |  Caminho                     | Uso                       |
| :---   | :---                         | :---                      |
| POST   | <BASE_URL>/salvar            | Cadastrar cliente         |
| POST   | <BASE_URL>/atualizar/{id}    | Atualizar dados cadastrados dos clientes por ID|
| GET    | <BASE_URL>/listar            | Listar todos os clientes  |
| GET    | <BASE_URL>/listar{id}        | Listar clientes pelo ID   |
| GET    | <BASE_URL>/listar/cpf/{cpf}  | Listar clientes pelo CPF  |
| GET    | <BASE_URL>/delete/{id}       | Deletar clientes pelo ID  |

- Amazon Simple Notification Service (SNS):
|  Caminho                        | Uso                                  |
| :---                            | :---                                 |
| <BASE_URL>/addInscricao/{email} | Mandar email para incrição no SNS    |
| <BASE_URL>/enviarNotificacao    | Mandar email para emails cadastrados |


## Acessar a documentação (Swagger):
- <BASE_URL>/swagger-ui.html#

## Diagrama de Entidade Relacionamento (DER):
- IMAGEM DIAGRAMA DB



