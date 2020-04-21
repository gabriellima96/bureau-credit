# Bureau Credit

Microservices usando Spring Boot, Docker, Redis, MongoDB e MySQL

## Getting Started

Segue abaixo os requisitos e instruções para rodar o projeto local.

### Prerequisites

É necessário ter instalado na máquina:
- Docker 
- Docker Compose
- Git

Para mais informações de como instalar segue o link:
[Instalação Docker](https://docs.docker.com/get-docker/)
[Instalação Docker Compose](https://docs.docker.com/compose/)

### Installing and Building

Segue abaixo o passo a passo para execução do projeto:

1. Clone o projeto

```
git clone https://github.com/gabriellima96/bureau-credit.git
```

2. Navegue para a pasta do projeto

```
cd bureau-credit
```

3. Construa o projeto com o docker-compose
```
docker-compose up --build
```

4. Acessar o Eureka: http://localhost:8761

5. Importe o 'bureau-credit.postman_collection.json' no postman e teste os endpoints


## Built With

* Maven
* Spring Boot
* Spring Cloud Config
* Spring Cloud Eureka
* Spring Cloud Zuul
* Spring Cloud OAuth2
* Spring Web
* Spring Data Redis
* Spring Data MongoDB
* Spring Data JPA
* Lombok
* MySQL
* MongoDB
* Redis
* FlywayDB

## Endpoints

### Autenticação e Autorização

#### Usuários
Usuário | Senha | Role | Descrição
:-----: | :---: | :-----: | :--------: 
bureaucredit | bureaucredit  | ADMIN | Pode consultar a basea e todas as outras
bancocredito | bancocredito | CREDITO | Só é possível consultar a baseb e basec
credit | credit | USER | Só é possível consultar a basec

### OAUTH
#### POST http://localhost:8080/api/oauth/token
Autenticar e buscar token

**Parameters**
- grant_type (string) * 
- username (string) *
- password (string) *

**Headers**
- Authorization - Basic YnVyZWF1OmJ1cmVhdQ==

**Response**

``` 
/// Response: Success - 200
{
    "access_token": "a8853dc5-6d83-41c5-bcb1-fa3734a53604",
    "token_type": "bearer",
    "refresh_token": "2bd55d20-1679-40bc-91d0-e912fcad69ab",
    "expires_in": 1799,
    "scope": "read write"
}
```
Exemplo:
http://localhost:8080/api/oauth/token?grant_type=password&username=bureaucredit&password=bureaucredit

### Basea
#### GET http://localhost:8080/api/basea/pessoas
Buscar uma pessoa por id da basea

**Parameters**
- size (number)
- page (number)
- sort (string)
- direction (string)

**Headers**
- Authorization - Bearer <access_token>

Exemplo:
http://localhost:8080/api/basea/pessoas?size=2&page=1

#### GET http://localhost:8080/api/basea/pessoas/{id}
Buscar pessoas da basea

**Headers**
- Authorization - Bearer <access_token>

Exemplo:
http://localhost:8080/api/basea/pessoas/1

#### GET http://localhost:8080/api/basea/pessoas/{id}/dividas
Buscar as dividas de uma pessoa

**Headers**
- Authorization - Bearer <access_token>

Exemplo:
http://localhost:8080/api/basea/pessoas/1/dividas

### Baseb
#### GET http://localhost:8080/api/baseb/pessoas
Buscar uma pessoa por id da baseb

**Parameters**
- size (number)
- page (number)
- sort (string)
- direction (string)

**Headers**
- Authorization - Bearer <access_token>

Exemplo:
http://localhost:8080/api/baseb/pessoas?size=2&page=1

#### PUT http://localhost:8080/api/baseb/pessoas/{id}/renda
Atualizar a renda de uma pessoa

**Body**
```
// Request Body
{
	"rendimento": 4700.00,
	"descricao": "Freelance",
	"tipo": "AUTONOMO"
}
```

**Headers**
- Authorization - Bearer <access_token>

Exemplo:
http://localhost:8080/api/baseb/pessoas/1/renda

#### POST http://localhost:8080/api/baseb/pessoas/{id}/bens
Cadastrar bens para uma pessoa

**Body**
```
// Request Body
{
	"descricao": "Casa",
	"classificacao": "IMOVEIS",
	"valor": 120000.00
}
```

**Headers**
- Authorization - Bearer <access_token>

Exemplo:
http://localhost:8080/api/baseb/pessoas/1/bens


### Basec
#### GET http://localhost:8080/api/basec/consultas
Buscar todas as consultas da basec

**Parameters**
- size (number)
- page (number)
- sort (string)
- direction (string)

**Headers**
- Authorization - Bearer <access_token>

Exemplo:http://localhost:8080/api/basec/consultas?size=20&page=1

#### GET http://localhost:8080/api/basec/consultas/{cpf}
Buscar todas as consultas de um cpf

**Headers**
- Authorization - Bearer <access_token>

Exemplo: http://localhost:8080/api/basec/consultas/06279275483

#### POST http://localhost:8080/api/basec/consultas
Cadastrar uma consulta

**Body**
```
// Request Body
{
	"bureau": "SPC",
	"descricao": "Verificar informações da pessoa",
	"cpf": "06279275483"
}
```

**Headers**
- Authorization - Bearer <access_token>

Exemplo:
http://localhost:8080/api/basec/consultas

#### GET http://localhost:8080/api/basec/movimentacoes/{cpf}
Buscar todas as movimentacões de um cpf

**Headers**
- Authorization - Bearer <access_token>

Exemplo: http://localhost:8080/api/basec/movimentacoes/06279275483

#### POST http://localhost:8080/api/basec/movimentacoes/{cpf}
Cadastrar movimentacao de uma pessoa

**Body**
```
// Request Body
{
	"dataMovimentacao": "2019-10-24T02:28:25",
	"valor": 50.00,
	"pagamento": "CREDITO",
	"operacao": "COMPRA",
	"descricao": "Compra no ifood"
}
```

**Headers**
- Authorization - Bearer <access_token>

Exemplo:
http://localhost:8080/api/basec/movimentacoes/06279275483

## Architecture

![Arquitetura](https://github.com/gabriellima96/bureau-credit/blob/master/architecture.png)



## Author

* **Gabriel Lima** - [https://gabriellima.site](https://gabriellima.site)

## License

Este projeto está licenciado sob a licença MIT - consulte o arquivo [LICENSE.md] (LICENSE.md) para obter detalhes
