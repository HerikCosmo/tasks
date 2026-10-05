# Tasks

API REST simples de lista de tarefas (To-Do List), desenvolvida em Java com Spring Boot. Permite criar, listar, buscar, atualizar e remover tarefas.
Cada tarefa possui um título, uma descrição e um status de acompanhamento, que pode ser PENDING, IN_PROGRESS ou DONE.

## Tecnologias

- Java 25
- Spring Boot
    - Spring Web
    - Spring Data JPA
- Lombok
- Docker e Docker Compose (banco de dados)
- Maven

## Pré-requisitos

- [JDK 25](https://jdk.java.net/25/)
- [Docker](https://www.docker.com/) e Docker Compose
- Maven (ou use o wrapper `./mvnw` incluso no projeto)

## Como executar

1. Clone o repositório:

```bash
git clone https://github.com/HerikCosmo/tasks.git
cd tasks
```

2. Suba o banco de dados com o Docker Compose:

```bash
docker compose up -d
```

3. Execute a aplicação:

```bash
./mvnw spring-boot:run
```

A API estará disponível em `http://localhost:8080`.

> Para parar o banco de dados: `docker compose down`

## Endpoints

Base URL: `/tasks`

| Método   | Endpoint      | Descrição                  |
|----------|---------------|----------------------------|
| `POST`   | `/tasks`      | Cria uma nova tarefa       |
| `GET`    | `/tasks`      | Lista todas as tarefas     |
| `GET`    | `/tasks/{id}` | Busca uma tarefa pelo ID   |
| `PUT`    | `/tasks/{id}` | Atualiza uma tarefa        |
| `DELETE` | `/tasks/{id}` | Remove uma tarefa          |

### Exemplo de corpo da requisição (POST / PUT)

```json
{
  "title": "Estudar Spring Boot",
  "description": "Revisar JPA e criação de APIs REST"
}
```

> O status da tarefa será definido automaticamente como `PENDING`

### Exemplo de resposta

```json
{
  "id": 1,
  "title": "Estudar Spring Boot",
  "description": "Revisar JPA e criação de APIs REST",
  "status": "PENDING"
}
```

### Exemplos com cURL

```bash
# Criar
curl -X POST http://localhost:8080/tasks \
  -H "Content-Type: application/json" \
  -d '{"title":"Estudar Spring Boot","description":"Revisar JPA","status":"PENDING"}'

# Listar todas
curl http://localhost:8080/tasks

# Buscar por ID
curl http://localhost:8080/tasks/1

# Atualizar
curl -X PUT http://localhost:8080/tasks/1 \
  -H "Content-Type: application/json" \
  -d '{"title":"Estudar Spring Boot","description":"Revisar JPA","status":"IN_PROGRESS"}'

# Deletar
curl -X DELETE http://localhost:8080/tasks/1
```

## Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.