# projeto-api-terror

API simples em Spring Boot para listar livros de terror. Dados carregados de um arquivo JSON e mantidos em memória.

## Requisitos
- `Java 21` e `Maven 3.9+`
- IntelliJ IDEA (opcional) com SDK configurada para `Java 21`

## Tecnologias
- Spring Boot `3.3.4`
- Jackson (para leitura do JSON)

## Estrutura do Projeto
- `pom.xml`
- `src/main/java/br/com/fecaf/App.java`
- `src/main/java/br/com/fecaf/model/LivroDeTerror.java`
- `src/main/java/br/com/fecaf/controller/LivrosController.java`
- `src/main/resources/application.properties`
- `src/main/resources/data/livros.json`

## Como Rodar
- Maven:
  - `mvn spring-boot:run`
- IntelliJ IDEA:
  - Abra o projeto e execute a classe `br.com.fecaf.App`.
  - Verifique no console mensagens como `Started App` e a porta (`8080`).

## Endpoints
- `GET /api/v1/livros/listarTodosOsLivros` — lista todos os livros
- `GET /api/v1/livros/{id}` — busca um livro pelo ID

### Testes rápidos
- PowerShell/curl:
  - `curl http://localhost:8080/api/v1/livros/listarTodosOsLivros`
  - `curl http://localhost:8080/api/v1/livros/1`

## Dados Iniciais
- Carregados de `classpath:data/livros.json` via `@PostConstruct` no controller.
- Contém 10 registros realistas com atributos: `id`, `titulo`, `autor`, `anoPublicacao`, `genero`, `paginas`, `editora`, `idioma`, `classificacao`, `sinopse`.

## Modelo (Entidade)
- `LivroDeTerror` com 10 atributos.
- Todos os getters e setters implementados.
- `toString()` sobrescrito.

## CORS
- Habilitado para todos os domínios com `@CrossOrigin("*")` no controller.

## Configuração
- `src/main/resources/application.properties`:
  - `spring.application.name=nome7`
  - Descomente `server.port=8080` se quiser alterar a porta.

## Estrutura de Entrega (exemplo)
```
projeto-api-terror/
├── pom.xml
├── README.md
└── src/
    └── main/
        ├── java/
        │   └── br/com/fecaf/
        │       ├── App.java
        │       ├── model/
        │       │   └── LivroDeTerror.java
        │       └── controller/
        │           └── LivrosController.java
        └── resources/
            ├── application.properties
            └── data/
                └── livros.json
```

## Como Buildar
- `mvn clean package`
- Executar o JAR: `java -jar target/projeto-api-terror-0.0.1-SNAPSHOT.jar`

## Contribuição
- Sinta-se livre para abrir PRs com melhorias e novos endpoints (POST/PUT/DELETE).

## Licença
- Este projeto é entregue sem licença específica. Adicione uma licença se for publicar publicamente.