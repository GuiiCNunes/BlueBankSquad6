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

## Diagrama de Entidade Relacionamento (DER):
<img src="./db/der.png" width="100%" />


## Utilizando a aplicação:

- Requisitos:
  - Maven e JDK 11
- Passo a passo:
  - No terminal, dentro da pasta da aplicação, gere o .jar executando o comando:
  ```
  mvn clean install -Dskiptests
  ```
  Caso o código acima não funcione, execute:
  ```
  ./mvnw clean install -DskipTests
  ```git
  - Rodar a aplicação (dentro da pasta target, onde está o arquivo .jar):
  ```
  java -jar api-spring-blueBank-0.0.1-SNAPSHOT.jar  
  ```

## URL para acesso local:
  - http://localhost:5000


## Acessar a documentação (Swagger):
- http://localhost:5000/swagger-ui.html#
 

## Endpoints:



- Clientes <br>

| Método |  Caminho                     | Uso                       |
| :---   | :---                         | :---                      |
| POST   | <BASE_URL>/cliente/salvar            | Cadastrar cliente         |
| POST   | <BASE_URL>/cliente/atualizar/{id}    | Atualizar dados cadastrados dos clientes por ID|
| GET    | <BASE_URL>/cliente/listar            | Listar todos os clientes  |
| GET    | <BASE_URL>/cliente/listar/{id}       | Listar clientes pelo ID   |
| GET    | <BASE_URL>/cliente/listar/cpf/{cpf}  | Listar clientes pelo CPF  |
| GET    | <BASE_URL>/cliente/deletar/{id}      | Deletar clientes pelo ID |

- Transação <br>

| Método |  Caminho                     | Uso                       |
| :---   | :---                         | :---                      |
| POST   | <BASE_URL>/transacao/salvar  | Realizar transação. Usar tipo: deposito/transferencia/saque |
| GET    | <BASE_URL>/transacao/listar   | Listar histórico de transações |

- Amazon Simple Notification Service (SNS): <br>

|  Caminho                        | Uso                                  |
| :---                            | :---                                 |
| <BASE_URL>/addInscricao/{email} | Mandar email para inscrição no SNS    |
| <BASE_URL>/enviarNotificacao    | Mandar notificação para emails cadastrados |


