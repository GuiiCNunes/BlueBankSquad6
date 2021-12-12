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
- Banco de Dados Relacional MySQL
- Swagger
- Postman
- Deploy na AWS

- Metodologias Ágeis:
  - Jira (Kanban)

- AWS Cloud:
  - Amazon Simple Notification Service (SNS)
  - API Gateway
  - Elastic BeanStalk
  - Code Pipeline
  - Code Commit
  - Code Build 
  - Lambda
  - RDS 
  - S3

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
  - http://localhost:8080

## URL para acesso na AWS:
- http://squad6t2ebs1-env.eba-rafmcyz8.us-east-2.elasticbeanstalk.com/

## Acessar a documentação (Swagger):
- <BASE_URL>/swagger-ui.html#
 

## Endpoints:

- Clientes <br>

| Método |  Caminho                     | Uso                       |
| :---   | :---                         | :---                      |
| POST   | <BASE_URL>/cliente/salvar            | Cadastrar cliente         |
| POST   | <BASE_URL>/cliente/atualizar/{id}    | Atualizar dados cadastrados dos clientes por ID|
| GET    | <BASE_URL>/cliente/listar            | Listar todos os clientes cadastrados |
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

- API Gataway

| Método |  Caminho                     | Uso                       |
| :---   | :---                         | :---                      |
| POST   | https://8gno5jdvk7.execute-api.us-east-2.amazonaws.com/blueBank/clientes/listar/      | Cadastrar cliente         |
| POST   | https://8gno5jdvk7.execute-api.us-east-2.amazonaws.com/blueBank/clientes/atualizar/{id}    | Atualizar dados cadastrados dos clientes por ID|
| GET    | https://8gno5jdvk7.execute-api.us-east-2.amazonaws.com/blueBank/clientes/listar  | Listar todos os clientes cadastrados |
| GET    | https://8gno5jdvk7.execute-api.us-east-2.amazonaws.com/blueBank/clientes/listar/{id}       | Listar clientes pelo ID   |
| GET    | https://8gno5jdvk7.execute-api.us-east-2.amazonaws.com/blueBank/clientes/listar/cpf/{cpf}  | Listar clientes pelo CPF  |
| GET    | https://8gno5jdvk7.execute-api.us-east-2.amazonaws.com/blueBank/clientes/deletar/{id}      | Deletar clientes pelo ID |
| POST   | https://8gno5jdvk7.execute-api.us-east-2.amazonaws.com/blueBank/transacao/salvar  | Realizar transação. Usar tipo: deposito/transferencia/saque |
| GET    | https://8gno5jdvk7.execute-api.us-east-2.amazonaws.com/blueBank/transacao/listar   | Listar histórico de transações |

