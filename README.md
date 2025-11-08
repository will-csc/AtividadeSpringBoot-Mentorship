# Spring Boot Activity — Completed During Mentorship

Note (Context): I completed this activity after I was no longer a student of the professor. It was built during a mentorship session to support the students who attended.

## Overview
Simple Spring Boot API to list horror books. Data is loaded from a JSON file and kept in memory.

Get by ID
<img width="753" height="468" alt="image" src="https://github.com/user-attachments/assets/72faafae-6b23-4487-b208-a65b93efc929" />

Get All Books
<img width="803" height="1019" alt="image" src="https://github.com/user-attachments/assets/110e2c26-92f5-4691-b2de-07308ae663af" />

## Requirements
- `Java 21` and `Maven 3.9+`
- IntelliJ IDEA (optional) with SDK set to `Java 21`

## Technologies
- Spring Boot `3.3.4`
- Jackson (for JSON parsing)

## Project Structure
- `pom.xml`
- `src/main/java/br/com/fecaf/App.java`
- `src/main/java/br/com/fecaf/model/LivroDeTerror.java`
- `src/main/java/br/com/fecaf/controller/LivrosController.java`
- `src/main/resources/application.properties`
- `src/main/resources/data/livros.json`

## How to Run
- Maven:
  - `mvn spring-boot:run`
- IntelliJ IDEA:
  - Open the project and run the class `br.com.fecaf.App`.
  - Check the console for messages like `Started App` and the port (`8080`).

## Endpoints
- `GET /api/v1/livros/listarTodosOsLivros` — lists all books
- `GET /api/v1/livros/{id}` — fetches a book by ID

### Quick Tests
- PowerShell/curl:
  - `curl http://localhost:8080/api/v1/livros/listarTodosOsLivros`
  - `curl http://localhost:8080/api/v1/livros/1`

## Seed Data
- Loaded from `classpath:data/livros.json` via `@PostConstruct` in the controller.
- Contains 10 realistic records with attributes: `id`, `titulo`, `autor`, `anoPublicacao`, `genero`, `paginas`, `editora`, `idioma`, `classificacao`, `sinopse`.

## Model (Entity)
- `LivroDeTerror` with 10 attributes.
- All getters and setters implemented.
- `toString()` overridden.

## CORS
- Enabled for all domains using `@CrossOrigin("*")` in the controller.

## Configuration
- `src/main/resources/application.properties`:
  - `spring.application.name=nome7`
  - Uncomment `server.port=8080` if you want to change the port.

## Delivery Structure (example)
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

## Build
- `mvn clean package`

- Run the JAR: `java -jar target/projeto-api-terror-0.0.1-SNAPSHOT.jar`
