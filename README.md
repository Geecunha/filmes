#  API de Filmes

API desenvolvida para cadastrar **Filmes**, visualizar os **diretores** responsáveis por cada produção e suas respectivas **produtoras**.

---

##  Autora do Projeto

- **Geovanna Cardoso**
- Repositório: `filmes-api`
- Link do projeto: [https://filmes-api-production.up.railway.app/swagger-ui/](https://filmes-api-production.up.railway.app/swagger-ui/)

---

##  Como Rodar Localmente

1. **Clone o repositório:**

```bash
git clone https://github.com/geovannacardoso/filmes-api
cd filmes-api
```

2. **Execute o projeto:**

```bash
./mvnw quarkus:dev
```

> A API será disponibilizada em: `http://localhost:8080/q/swagger-ui/`

---

##  Funcionalidades Principais

###  Filme Resource

| Método | Rota | Descrição |
|--------|------|-----------|
| `GET`  | `/filmes` | Listar todos os filmes |
| `GET`  | `/filmes/{id}` | Buscar filme por ID |
| `POST` | `/filmes` | Cadastrar novo filme |
| `PUT`  | `/filmes/{id}` | Atualizar filme existente |
| `DELETE` | `/filmes/deletar/{id}` | Deletar filme |
| `GET`  | `/filmes/top3` | Retornar os 3 filmes com maiores notas |
| `GET`  | `/filmes/por-diretor/{id}` | Listar filmes de um diretor específico |
| `GET`  | `/filmes/por-produtora/{id}` | Listar filmes de uma produtora específica |

---

###  Diretor Resource

| Método | Rota | Descrição |
|--------|------|-----------|
| `GET`  | `/diretores` | Listar todos os diretores |
| `GET`  | `/diretores/{id}` | Buscar diretor por ID |
| `POST` | `/diretores` | Cadastrar novo diretor |
| `PUT`  | `/diretores/{id}` | Atualizar diretor existente |
| `DELETE` | `/diretores/deletar/{id}` | Deletar diretor |

---

###  Produtora Resource

| Método | Rota | Descrição |
|--------|------|-----------|
| `GET`  | `/produtoras` | Listar todas as produtoras |
| `GET`  | `/produtoras/{id}` | Buscar produtora por ID |
| `POST` | `/produtoras` | Cadastrar nova produtora |
| `PUT`  | `/produtoras/{id}` | Atualizar produtora existente |
| `DELETE` | `/produtoras/deletar/{id}` | Deletar produtora |

---

##  Deploy

Este projeto está hospedado no Railway:

> Acesse a documentação Swagger da API em:  
> [https://filmes-api-production.up.railway.app/swagger-ui/](https://filmes-api-production.up.railway.app/swagger-ui/)



---

##  Tecnologias Utilizadas

- **Quarkus**
- **Java 17**
- **Hibernate ORM com Panache**
- **Banco H2**
- **Swagger (OpenAPI)**
- **Maven**
