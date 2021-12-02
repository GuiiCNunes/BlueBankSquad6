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
## URL para acesso local:
  - http://localhost:5000

## Acessar a documentação (Swagger):
- <BASE_URL>/swagger-ui.html#
 

## Endpoints:

- Clientes <br>

| Método |  Caminho                     | Uso                       |
| :---   | :---                         | :---                      |
| POST   | <BASE_URL>/salvar            | Cadastrar cliente         |
| POST   | <BASE_URL>/atualizar/{id}    | Atualizar dados cadastrados dos clientes por ID|
| GET    | <BASE_URL>/listar            | Listar todos os clientes  |
| GET    | <BASE_URL>/listar{id}        | Listar clientes pelo ID   |
| GET    | <BASE_URL>/listar/cpf/{cpf}  | Listar clientes pelo CPF  |
| GET    | <BASE_URL>/deletar/{id}       | Deletar clientes pelo ID |

- Transação <br>

| Método |  Caminho                     | Uso                       |
| :---   | :---                         | :---                      |
| POST   | <BASE_URL>/transacao/salvar  | Realizar transação. Usar tipo: deposito/saque |
| GET    | <BASE_URL>/transacao/listar   | Listar histórico de transações |

- Amazon Simple Notification Service (SNS): <br>

|  Caminho                        | Uso                                  |
| :---                            | :---                                 |
| <BASE_URL>/addInscricao/{email} | Mandar email para inscrição no SNS    |
| <BASE_URL>/enviarNotificacao    | Mandar notificação para emails cadastrados |


