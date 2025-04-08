
# API de Livros

API desenvolvida para cadastrar Livros, e visualizar quais autores e editoras foramr esponsáveis pelo livro escolhido


## Autora do projeto

- Giovanna Piccinato
- Repositório: API-Livros
- Link do projeto: https://api-livros-production.up.railway.app/swagger-ui/


## Como rodar localmente

1 - Clone o repositório:

```bash
    git clone https://github.com/GiovannaPiccinato/API-Livros
    cd seu-repo 
```


2 - Execute o projeto com:

```bash
  ./mvnw quarkus:dev
```



> A API será disponibilizada em: https://api-livros-production.up.railway.app/swagger-ui/

##  Funcionalidades Principais

### Autor Resource

| Método | Rota | Descrição |
|--------|------|-----------|
| `GET`  | `/autor` | Listar todos os autores |
| `POST` | `/autor` | Cadastrar novo autor |
| `PUT`  | `/autor/{id}` | Atualizar autor existente |
| `DELETE` | `/autor/deletarAutor/{id}` | Deletar autor |
| `GET`  | `/autor/findAutor/{id}` | Buscar autor por ID |

---

### Editora Resource

| Método | Rota | Descrição |
|--------|------|-----------|
| `GET` | `/editora` | Listar todas as editoras |
| `GET`  | `/editora/findEditora` | Buscar editora por ID |
| `POST`  | `/editora` | Cadastrar nova editora |
| `PUT`  | `/editora/{id}` |  Atualizar editora existente |
| `DELETE` | `/inscricoes/deletarEditora` | Deletar editora |

---

### Livro Resource

| Método | Rota | Descrição |
|--------|------|-----------|
| `GET`  | `/livro` | Listar todos os livros |
| `POST` | `/livro/criar` | Cadastrar novo livro |
| `PUT`  | `/livro/{id}` | Atualizar livro existente |
| `DELETE` | `/livro/deletarLivro/{id}` | Deletar livro |
| `GET`  | `/livro/findLivro/{id}` | Buscar livro por ID |
| `PUT`  | `/livro/basico/{id}}` | Atualiza somente título e número de páginas do livro |

---

## Deploy

Para realizar o deploy desse projeto utilizamos o Reilway

    Você pode fazer o deploy desta API no [Railway](https://railway.app/).

---