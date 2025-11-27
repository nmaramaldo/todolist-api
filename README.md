# To-Do List API (Gerenciador de Tarefas)

Este projeto é uma API RESTful desenvolvida com **Spring Boot** para o gerenciamento de tarefas pessoais. O sistema permite criar, listar, atualizar e remover tarefas (CRUD completo).

## Tecnologias Utilizadas

* **Java** (JDK 17/21)
* **Spring Boot** (Web, Data JPA)
* **H2 Database** (Banco de dados em memória)
* **Lombok** (Produtividade de código)
* **Swagger / OpenAPI** (Documentação e Testes interativos)

## Como Executar

1.  Clone este repositório ou baixe o código fonte.
2.  Abra o projeto na sua IDE preferida (VS Code, IntelliJ).
3.  Execute a classe principal `TodolistApplication.java`.
4.  A aplicação estará rodando em: `http://localhost:8081`


## Testando a API (Documentação Interativa)

O projeto possui **Swagger** integrado. Para testar todos os endpoints visualmente, acesse o link abaixo com a aplicação rodando:

 **[http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html)**

---

## Documentação dos Endpoints

Abaixo estão os detalhes dos métodos HTTP implementados:

### 1. Listar Tarefas
Retorna todas as tarefas cadastradas.
* **Método:** `GET`
* **URL:** `/api/tarefas`
* **Resposta (200 OK):**
    ```json
    [
      {
        "id": 1,
        "titulo": "Estudar Spring Boot",
        "descricao": "Finalizar atividade da faculdade",
        "concluida": false
      }
    ]
    ```

### 2. Criar Tarefa
Adiciona uma nova tarefa ao banco de dados.
* **Método:** `POST`
* **URL:** `/api/tarefas`
* **Body (JSON):**
    ```json
    {
      "titulo": "Comprar café",
      "descricao": "Marca X, pacote de 500g",
      "concluida": false
    }
    ```
* **Resposta (201 Created):** Retorna a tarefa criada com o ID gerado.

### 3. Atualizar Tarefa
Atualiza os dados de uma tarefa existente.
* **Método:** `PUT`
* **URL:** `/api/tarefas/{id}`
* **Exemplo:** `/api/tarefas/1`
* **Body (JSON):**
    ```json
    {
      "titulo": "Comprar café descafeinado",
      "descricao": "Marca Y",
      "concluida": true
    }
    ```
* **Resposta (200 OK):** Retorna a tarefa atualizada.

### 4. Excluir Tarefa
Remove uma tarefa permanentemente.
* **Método:** `DELETE`
* **URL:** `/api/tarefas/{id}`
* **Exemplo:** `/api/tarefas/1`
* **Resposta (204 No Content):** Sem conteúdo no corpo da resposta.

---
**Autora:** Natália Maramaldo