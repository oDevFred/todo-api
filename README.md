# 📝 To-Do List API

Uma API REST robusta e simplificada para gerenciamento de tarefas cotidianas, desenvolvida para demonstrar os fundamentos do ecossistema Spring Boot.

---

## 🚀 Sobre o Projeto

**"API REST para gerenciar tarefas (To-Do List) com Spring Boot"**

O objetivo deste projeto é fornecer uma interface programática para a criação, consulta, atualização e exclusão de tarefas (CRUD). A aplicação conta com validações de regras de negócio, como obrigatoriedade de títulos e persistência automática de datas de criação.

---

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java 21
* **Framework:** Spring Boot 4+
* **Persistência:** Spring Data JPA
* **Banco de Dados:** H2 Database (Em memória para fácil execução)
* **Gerenciador de Dependências:** Maven

---

## ⚙️ Como Rodar a Aplicação

Siga os passos abaixo para ter o projeto rodando localmente:

1. **Clone o repositório:**
```bash
git clone https://github.com/oDevFred/todo-api.git

```


2. **Abra o projeto:**
Importe o projeto na sua IDE favorita (**IntelliJ IDEA**, Eclipse ou VS Code).
3. **Execute:**
Localize a classe principal `TodoApiApplication.java` (ou nome similar) e execute o método `main`.
4. **Acesse:**
A API estará disponível em: `http://localhost:8080`

---

## 🌐 Endpoints da API

Abaixo estão as rotas disponíveis para interação:

| Ação | Método | Endpoint | Descrição |
| --- | --- | --- | --- |
| **Listar** | `GET` | `/tarefas` | Retorna todas as tarefas cadastradas. |
| **Buscar** | `GET` | `/tarefas/{id}` | Retorna os detalhes de uma tarefa específica. |
| **Criar** | `POST` | `/tarefas` | Cadastra uma nova tarefa no sistema. |
| **Atualizar** | `PUT` | `/tarefas/{id}` | Altera os dados de uma tarefa existente. |
| **Deletar** | `DELETE` | `/tarefas/{id}` | Remove permanentemente uma tarefa. |

---

## 📊 Estrutura de Dados (Exemplo de JSON)

Ao criar ou atualizar uma tarefa, utilize o seguinte formato:

```json
{
  "titulo": "Finalizar documentação",
  "descricao": "Escrever o README detalhado do projeto",
  "concluida": false
}

```

---

## 🛡️ Regras de Negócio e Status HTTP

* **201 Created:** Retornado ao criar uma tarefa com sucesso.
* **404 Not Found:** Retornado quando o ID informado não existe.
* **400 Bad Request:** Retornado se o título for enviado vazio ou nulo.
* **Data de Criação:** Gerada automaticamente pelo sistema no momento do cadastro.

---

**Dica:** Você pode visualizar o console do banco de dados H2 acessando `http://localhost:8080/h2-console` enquanto a aplicação estiver rodando (verifique as configurações no seu `application.properties`).

---

## 🗒️ Anotações do Fredinho

Estou muito feliz, pois este foi meu primeiro projeto Spring Boot onde fiz totalmente sozinho.
* Não utilizei tutoriais.
* Não fiquei dependente de IA (Pensava antes de pedir ajudar).
* Peguei códigos de projetos antigos (Esse sim feito junto aos tutoriais).
