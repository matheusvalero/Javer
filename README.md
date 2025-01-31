Microsserviços de Cadastro de Clientes:

Este projeto consiste em duas aplicações Spring Boot que trabalham juntas para gerenciar o cadastro de clientes de um banco. A primeira aplicação (Gateway) atua como uma interface para o cliente, expondo endpoints REST e realizando cálculos de score de crédito. A segunda aplicação (Storage) é responsável pelo armazenamento dos dados dos clientes em um banco de dados H2.

Estrutura do Projeto
O projeto é dividido em duas aplicações independentes:

Gateway: Expõe endpoints REST e faz chamadas para a aplicação Storage.

Storage: Gerencia o armazenamento dos dados dos clientes em um banco de dados H2.

Ambas as aplicações se comunicam via Feign Client, e cada uma tem sua própria base de código e responsabilidades.

Primeira Aplicação: Gateway
A aplicação Gateway é a interface principal para o cliente. Ela expõe endpoints REST e realiza cálculos de score de crédito com base nos dados obtidos da aplicação Storage.

Estrutura do Código
1. Modelo Cliente
Classe: Cliente

Pacote: com.javer.clientes.gateway.model

Descrição: Representa o modelo de dados do cliente. Contém os campos:

id: Identificador único do cliente.

nome: Nome do cliente.

telefone: Número de telefone do cliente.

correntista: Indica se o cliente é correntista (true ou false).

scoreCredito: Score de crédito do cliente.

saldoCc: Saldo da conta corrente do cliente.

2. Feign Client
Interface: ClienteStorageClient

Pacote: com.javer.clientes.gateway.client

Descrição: Interface que define os métodos para comunicação com a aplicação Storage. Usa o Feign Client para fazer chamadas REST para os endpoints da aplicação Storage.

3. Controller
Classe: ClienteGatewayController

Pacote: com.javer.clientes.gateway.controller

Descrição: Expõe os endpoints REST para o cliente. Faz chamadas para a aplicação Storage usando o Feign Client e realiza o cálculo do score de crédito.

Endpoints:

GET /api/clientes: Lista todos os clientes.

GET /api/clientes/{id}: Obtém um cliente pelo ID.

POST /api/clientes: Cria um novo cliente.

PUT /api/clientes/{id}: Atualiza um cliente existente.

DELETE /api/clientes/{id}: Deleta um cliente.

GET /api/clientes/{id}/score: Calcula o score de crédito do cliente (10% do saldo da conta corrente).

4. Arquivo application.properties
Descrição: Configurações da aplicação, como a porta em que a aplicação roda (8080) e o nome da aplicação (gateway).

Segunda Aplicação: Storage
A aplicação Storage é responsável pelo armazenamento dos dados dos clientes em um banco de dados H2. Ela expõe endpoints CRUD para a aplicação Gateway.

Estrutura do Código
1. Entidade Cliente
Classe: Cliente

Pacote: com.javer.storage.model

Descrição: Representa a entidade do cliente no banco de dados. Contém os mesmos campos do modelo da aplicação Gateway, mas é mapeada como uma entidade JPA.

2. Repositório
Interface: ClienteRepository

Pacote: com.javer.storage.repository

Descrição: Interface que estende JpaRepository para realizar operações CRUD no banco de dados H2.

3. Controller
Classe: ClienteController

Pacote: com.javer.storage.controller

Descrição: Expõe os endpoints REST para a aplicação Gateway. Realiza operações CRUD no banco de dados.

Endpoints:

GET /clientes: Lista todos os clientes.

GET /clientes/{id}: Obtém um cliente pelo ID.

POST /clientes: Cria um novo cliente.

PUT /clientes/{id}: Atualiza um cliente existente.

DELETE /clientes/{id}: Deleta um cliente.

4. Arquivo application.properties
Descrição: Configurações da aplicação, como a porta em que a aplicação roda (8081), o nome da aplicação (storage) e as configurações do banco de dados H2.

Como Executar o Projeto
Pré-requisitos
Java 17
Maven
Postman (para testar os endpoints)


Tecnologias Utilizadas

Spring Boot: Framework para desenvolvimento de aplicações Java.

Spring Data JPA: Para operações de banco de dados.

H2 Database: Banco de dados em memória para desenvolvimento.

Feign Client: Para comunicação entre as aplicações.

Springdoc OpenAPI: Para documentação da API.

JUnit e Mockito: Para testes unitários.