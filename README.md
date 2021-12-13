
<h1 align="center" > PROJETO BLUE BANK</b> </h1>
Desafio final do PAN Academy, um curso de formação JAVA e AWS cloud de 10 semanas oferecido pelo banco PAN em parceria com a Gama Academy.
<hr>

<h3>:ghost: Equipe Code Poltergeist:</b></h3>

- Guilherme Nunes
- Mariana Fonseca
- Miromar Junior
- Vinicius Menolli
- Jessica Kopps

<hr>

<h3 id="sumario"> 📑 Tecnologias e recursos utilizados </h3>

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


<hr>

<h3 id="requisitos"> :gear: Utilizando a aplicação </h3>

- Requisitos:
  ```
  - Maven e JDK 11
  ```

- Gere o <b>.jar</b> da aplicação executando o comando no terminal:
    ```shell
    mvn clean install -Dskiptests
    ```

- Para rodar o <b>.jar</b> vá até a pasta do projeto pelo terminal e rode o comando:
    ```shell
    java -jar -Dspring.profiles.active=localdebug blue-bank-0.0.1-SNAPSHOT.jar
    ```

<hr>  
  
<h3 id="db"> :open_file_folder: Banco de Dados</h3>
<h4 id="der">Diagrama de entidade de relacionamento (DER): </h4>
<img src="./db/der.png" width="100%" />

- <a target="_blank" href="./db/blueBank6.sql"> Script SQL do banco de dados</a>
<hr>

<h3 id="endpoints"> 🔌 Endpoints</h3>

- URL para acesso local:
  - http://localhost:8080

- URL para acesso na AWS:
  - http://squad6t2ebs1-env.eba-rafmcyz8.us-east-2.elasticbeanstalk.com/

- Clientes <br>

| Método |  Caminho                     | Uso                       |
| :---   | :---                         | :---                      |
| POST   | <BASE_URL>/cliente/salvar            | Cadastrar cliente         |
| PUT    | <BASE_URL>/cliente/atualizar/{id}    | Atualizar dados cadastrados dos clientes por ID|
| GET    | <BASE_URL>/cliente/listar            | Listar todos os clientes cadastrados |
| GET    | <BASE_URL>/cliente/listar/{id}       | Listar clientes pelo ID   |
| GET    | <BASE_URL>/cliente/listar/cpf/{cpf}  | Listar clientes pelo CPF  |
| DELETE | <BASE_URL>/cliente/deletar/{id}      | Deletar clientes pelo ID |
<br>

- Transação <br>

| Método |  Caminho                     | Uso                       |
| :---   | :---                         | :---                      |
| POST   | <BASE_URL>/transacao/salvar  | Realizar transação. Usar tipo: deposito/transferencia/saque |
| GET    | <BASE_URL>/transacao/listar   | Listar histórico de transações |
<br>

- Amazon Simple Notification Service (SNS): <br>

|  Caminho                        | Uso                                  |
| :---                            | :---                                 |
| <BASE_URL>/addInscricao/{email} | Mandar email para inscrição no SNS    |
| <BASE_URL>/enviarNotificacao    | Mandar notificação para emails cadastrados |
<br>

- API Gateway

| Método |  Caminho                     | Uso                       |
| :---   | :---                         | :---                      |
| POST   | https://8gno5jdvk7.execute-api.us-east-2.amazonaws.com/blueBank/clientes/salvar            | Cadastrar cliente         |
| PUT    | https://8gno5jdvk7.execute-api.us-east-2.amazonaws.com/blueBank/clientes/atualizar/{id}    | Atualizar dados cadastrados dos clientes por ID|
| GET    | https://8gno5jdvk7.execute-api.us-east-2.amazonaws.com/blueBank/clientes/listar            | Listar todos os clientes cadastrados |
| GET    | https://8gno5jdvk7.execute-api.us-east-2.amazonaws.com/blueBank/clientes/listar/{id}       | Listar clientes pelo ID   |
| GET    | https://8gno5jdvk7.execute-api.us-east-2.amazonaws.com/blueBank/clientes/listar/cpf/{cpf}  | Listar clientes pelo CPF  |
| DELETE | https://8gno5jdvk7.execute-api.us-east-2.amazonaws.com/blueBank/clientes/deletar/{id}      | Deletar clientes pelo ID |
| POST   | https://8gno5jdvk7.execute-api.us-east-2.amazonaws.com/blueBank/transacao/salvar  | Realizar transação. Usar tipo: deposito/transferencia/saque |
| GET    | https://8gno5jdvk7.execute-api.us-east-2.amazonaws.com/blueBank/transacao/listar   | Listar histórico de transações |

<hr>

<h3 id="swagger">:scroll: Swagger UI</h3>

- Acesso local
  - http://localhost:8080/swagger-ui.html#

- Acesso ao banco de dados da AWS
  - http://squad6t2ebs1-env.eba-rafmcyz8.us-east-2.elasticbeanstalk.com/swagger-ui.html#
<br>

  <img src="./assets/img/swagger/Swagger.png" width="100%" />
<br>

- Swagger imagens
   - [AWS-SNS](https://github.com/GuiiCNunes/BlueBankSquad6/blob/main/assets/img/swagger/swagger-sns.png?raw=true)
   - [Cliente Controller](https://github.com/GuiiCNunes/BlueBankSquad6/blob/main/assets/img/swagger/swagger-clilente-controller.png?raw=true)
   - [Home Controller](https://github.com/GuiiCNunes/BlueBankSquad6/blob/main/assets/img/swagger/swagger-home-controller.png?raw=true)
   - [Transação Controller](https://github.com/GuiiCNunes/BlueBankSquad6/blob/main/assets/img/swagger/swagger-transacao.png?raw=true)
   - [Models](https://github.com/GuiiCNunes/BlueBankSquad6/blob/main/assets/img/swagger/swagger-models.png?raw=true)

<hr>


<h3 id="aws">	:cloud: AWS Cloud </h3>

- Lambda
  <img src="./assets/img/aws/lambda-2.png" width="100%" />
  
- AWS imagens
  - [Página Home](https://github.com/GuiiCNunes/BlueBankSquad6/blob/main/assets/img/aws/pagina-home.jpg?raw=true)
  - [Elastic Beanstalk](https://github.com/GuiiCNunes/BlueBankSquad6/blob/main/assets/img/aws/elastic-beanstalk.jpg?raw=true)
  - [API Gateway](https://github.com/GuiiCNunes/BlueBankSquad6/blob/main/assets/img/aws/api-gateway.jpg?raw=true)
  - [SNS](https://github.com/GuiiCNunes/BlueBankSquad6/blob/main/assets/img/aws/sns.jpg?raw=true)
  - [RDS](https://github.com/GuiiCNunes/BlueBankSquad6/blob/main/assets/img/aws/rds.jpg?raw=true)
  - [Code Commit](https://github.com/GuiiCNunes/BlueBankSquad6/blob/main/assets/img/aws/code-commit.jpg?raw=true)
  - [Code Build](https://github.com/GuiiCNunes/BlueBankSquad6/blob/main/assets/img/aws/code-build.jpg?raw=true)
  - [Code Pipeline](https://github.com/GuiiCNunes/BlueBankSquad6/blob/main/assets/img/aws/code-pipeline.jpg?raw=true)
  
  <hr>
<h4 id="der">Apresentação do Desafio final </h4>
- <a target="_blank" href="./Apresentacao_CODE_POLTERGEIST.pdf"> Confira nossa apresentação</a>
