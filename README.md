# Desafio Validação e Segurança

Projeto desenvolvido como resolução do desafio **Validação e Segurança** do curso **Java Spring Expert**, da **DevSuperior**.

O objetivo do desafio é completar uma API REST de eventos e cidades, aplicando regras de validação nos dados recebidos e regras de segurança baseadas em perfis de usuário.

## Sobre o projeto

A aplicação representa um sistema simples de cadastro de cidades e eventos. Existe uma relação muitos-para-um entre eventos e cidades: vários eventos podem pertencer a uma mesma cidade.

Foram implementados endpoints para consulta e cadastro:

| Método | Endpoint | Acesso | Descrição |
| --- | --- | --- | --- |
| `GET` | `/cities` | Público | Lista cidades ordenadas por nome |
| `POST` | `/cities` | `ROLE_ADMIN` | Cadastra uma nova cidade |
| `GET` | `/events` | Público | Lista eventos de forma paginada |
| `POST` | `/events` | `ROLE_CLIENT` ou `ROLE_ADMIN` | Cadastra um novo evento |

## O que foi feito

- Implementação das entidades `City`, `Event`, `User` e `Role`.
- Criação dos DTOs `CityDTO` e `EventDTO`.
- Implementação dos repositories, services e controllers da API.
- Validação dos campos obrigatórios usando Bean Validation.
- Tratamento de erros de validação com retorno HTTP `422 Unprocessable Entity`.
- Configuração de autenticação e autorização com Spring Security, OAuth2 Authorization Server e JWT.
- Controle de acesso por perfil de usuário (`ROLE_CLIENT` e `ROLE_ADMIN`).
- Carga inicial de dados com usuários, perfis, cidades e eventos no banco H2.
- Testes de integração para validar regras de acesso, validação e consultas.

## Regras de validação

### Cidade

- `name`: obrigatório e não pode ser vazio.

### Evento

- `name`: obrigatório e não pode ser vazio.
- `date`: não pode ser uma data passada.
- `cityId`: obrigatório.

## Regras de segurança

- Consultas `GET` de cidades e eventos são públicas.
- Usuários com perfil `ROLE_CLIENT` ou `ROLE_ADMIN` podem cadastrar eventos.
- Apenas usuários com perfil `ROLE_ADMIN` podem cadastrar cidades.
- Requisições com token inválido são bloqueadas.

## Usuários de teste

| Usuário | Senha | Perfil |
| --- | --- | --- |
| `ana@gmail.com` | `123456` | `ROLE_CLIENT` |
| `bob@gmail.com` | `123456` | `ROLE_CLIENT`, `ROLE_ADMIN` |

## Tecnologias

- Java 25
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security
- OAuth2 Authorization Server
- JWT
- Bean Validation
- H2 Database
- Maven

## Como executar

```bash
./mvnw spring-boot:run
```

Por padrão, a aplicação usa o perfil `test` e banco H2 em memória.

## Como rodar os testes

```bash
./mvnw test
```
