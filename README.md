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


## Architecture

![Arquitetura](https://github.com/gabriellima96/bureau-credit/blob/master/architecture.png)



## Author

* **Gabriel Lima** - [https://gabriellima.site](https://gabriellima.site)

## License

Este projeto está licenciado sob a licença MIT - consulte o arquivo [LICENSE.md] (LICENSE.md) para obter detalhes
