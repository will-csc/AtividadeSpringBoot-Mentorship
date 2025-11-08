# API REST de Carros - Spring Boot

## 📋 Descrição do Projeto

Esta é uma API REST desenvolvida em Spring Boot para gerenciar um catálogo de carros. A API permite operações CRUD (Create, Read, Update, Delete) e carrega dados iniciais de um arquivo JSON.

## 🛠️ Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 4.0.0-RC1**
- **Spring Web**
- **Jackson** (para manipulação de JSON)
- **Maven** (gerenciamento de dependências)

## 🚀 Step-by-Step para Construir a API

### Passo 1: Configuração do Projeto Maven

1. Crie um novo projeto Maven
2. Configure o `pom.xml` com as dependências do Spring Boot:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.example</groupId>
    <artifactId>project-1-spring</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>21</maven.compiler.source>
        <maven.compiler.target>21</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>4.0.0-RC1</version>
    </parent>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
            <version>4.0.0-RC1</version>
        </dependency>
    </dependencies>
</project>
```

### Passo 2: Criar a Classe Principal (App.java)

```java
package br.com.fecaf;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    CommandLineRunner initialization () {
        return args -> {
            System.out.println("Server no Ar !!");
        };
    }
}
```

### Passo 3: Criar o Model (Carro.java)

```java
package br.com.fecaf.model;

public class Carro {
    private Long id;
    private String marca;
    private String modelo;
    private int ano;
    private double preco;
    private String motor;
    private String combustivel;
    private double consumoCidade;
    private double consumoEstrada;
    private String cor;
    private String transmissao;
    private String status;

    // Getters e Setters
    // ... (implementar todos os getters e setters)
}
```

### Passo 4: Criar o Controller (CarroController.java)

```java
package br.com.fecaf.controller;

import br.com.fecaf.model.Carro;
import org.springframework.web.bind.annotation.*;
import jakarta.annotation.PostConstruct;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/carros")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CarroController {
    
    private List<Carro> carros = new ArrayList<>();

    @PostConstruct
    public void carregarJson() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream inputStream = getClass()
                    .getResourceAsStream("/data/carros.json");

            carros = objectMapper.readValue(inputStream, new TypeReference<List<Carro>>() {});
            System.out.println("✅ JSON de carros carregado com sucesso: " + carros.size() + " carros.");
        } catch (Exception e) {
            System.err.println("❌ Erro ao carregar o JSON de carros: " + e.getMessage());
        }
    }

    @GetMapping
    public List<Carro> listarCarros() {
        return carros;
    }
}
```

### Passo 5: Criar o Arquivo de Dados JSON

Crie o arquivo `src/main/resources/data/carros.json`:

```json
[
  {
    "id": 1,
    "marca": "Toyota",
    "modelo": "Corolla",
    "ano": 2023,
    "preco": 142000,
    "motor": "2.0 Flex",
    "combustivel": "Gasolina/Etanol",
    "consumoCidade": 10.5,
    "consumoEstrada": 13.2,
    "cor": "Prata",
    "transmissao": "Automática CVT",
    "status": "Novo"
  }
]
```

## 📡 Endpoint da API

### GET /api/v1/carros
**Descrição:** Lista todos os carros
**Resposta:**
```json
[
  {
    "id": 1,
    "marca": "Toyota",
    "modelo": "Corolla",
    "ano": 2023,
    "preco": 142000,
    "motor": "2.0 Flex",
    "combustivel": "Gasolina/Etanol",
    "consumoCidade": 10.5,
    "consumoEstrada": 13.2,
    "cor": "Prata",
    "transmissao": "Automática CVT",
    "status": "Novo"
  }
]
```

## 🏃‍♂️ Como Executar

1. Clone o repositório
2. Execute: `mvn spring-boot:run`
3. A API estará disponível em: `http://localhost:8080`
4. Teste os endpoints usando Postman, Insomnia ou curl

## 🧪 Testando a API

### Listar todos os carros:
```bash
curl -X GET http://localhost:8080/api/v1/carros
```

## 📝 Observações Importantes

- A API utiliza armazenamento em memória (dados são perdidos ao reiniciar)
- CORS está habilitado para permitir requisições de qualquer origem
- Os dados iniciais são carregados automaticamente do arquivo JSON
- Implementa apenas o endpoint GET para listagem de carros

---

# 🎯 ATIVIDADE PRÁTICA - API REST com Spring Boot

**Disciplina:** Desenvolvimento de APIs  
**Professor:** Vitor Jesus  
**Valor:** 1,0 ponto na média  
**Entrega:** Via email para vitor.jesus@pro.fecaf.com.br  

## 📋 Objetivo

Desenvolver uma API REST completa utilizando Spring Boot, seguindo o modelo da API de Carros apresentada em aula. O aluno deve escolher um dos temas sugeridos e implementar todas as operações CRUD.

## 🎲 Temas Disponíveis (Escolha 1)

### 1. 🏈 Jogadores de Futebol
**Atributos sugeridos:**
- id, nome, posicao, idade, altura, peso, nacionalidade, clube, salario, numerosCamisa, golsMarcados, status

### 2. 🚀 Naves Espaciais
**Atributos sugeridos:**
- id, nome, tipo, fabricante, anoLancamento, capacidadePassageiros, velocidadeMaxima, combustivel, missao, status, custoOperacional

### 3. 🏍️ Motocicletas
**Atributos sugeridos:**
- id, marca, modelo, ano, preco, cilindrada, potencia, torque, consumo, cor, categoria, status

### 4. 📱 Smartphones
**Atributos sugeridos:**
- id, marca, modelo, preco, sistemaOperacional, armazenamento, ram, camera, bateria, cor, anoLancamento, status

### 5. 🎮 Jogos de Videogame
**Atributos sugeridos:**
- id, titulo, desenvolvedora, genero, plataforma, anoLancamento, preco, classificacao, nota, vendas, status

## 📝 Requisitos Obrigatórios

### 1. Estrutura do Projeto
- ✅ Projeto Maven com Spring Boot
- ✅ Estrutura de pacotes organizada (model, controller)
- ✅ Classe principal com @SpringBootApplication

### 2. Model (Entidade)
- ✅ Classe com pelo menos 8 atributos relevantes
- ✅ Todos os getters e setters implementados
- ✅ Método toString() sobrescrito

### 3. Controller REST
- ✅ Anotações corretas (@RestController, @RequestMapping, @CrossOrigin)
- ✅ Implementação de todos os endpoints CRUD:
  - **GET** `/api/v1/{recurso}` - Listar todos
  - **GET** `/api/v1/{recurso}/{id}` - Buscar por ID

### 4. Dados Iniciais
- ✅ Arquivo JSON com pelo menos 10 registros
- ✅ Carregamento automático dos dados com @PostConstruct
- ✅ Dados realistas e bem estruturados

### 5. Funcionalidades
- ✅ Armazenamento em memória (List)
- ✅ Pesquisar por ID

## 📦 Estrutura de Entrega

Seu projeto deve conter:

```
projeto-api-[tema]/
├── pom.xml
├── README.md (documentação da sua API)
├── src/
│   └── main/
│       ├── java/
│       │   └── br/com/fecaf/
│       │       ├── App.java
│       │       ├── model/
│       │       │   └── [SuaEntidade].java
│       │       └── controller/
│       │           └── [SeuController].java
│       └── resources/
│           └── data/
│               └── [dados].json
```

## 📋 Exemplo Prático - Jogadores

### Model (Jogador.java)
```java
public class Jogador {
    private Long id;
    private String nome;
    private String posicao;
    private int idade;
    private double altura;
    private double peso;
    private String nacionalidade;
    private String clube;
    private double salario;
    private int numeroCamisa;
    private int golsMarcados;
    private String status;
    
    // Getters, Setters e toString()
}
```

### JSON de Exemplo (jogadores.json)
```json
[
  {
    "id": 1,
    "nome": "Lionel Messi",
    "posicao": "Atacante",
    "idade": 36,
    "altura": 1.70,
    "peso": 72.0,
    "nacionalidade": "Argentina",
    "clube": "Inter Miami",
    "salario": 50000000.0,
    "numeroCamisa": 10,
    "golsMarcados": 800,
    "status": "Ativo"
  },
  {
    "id": 2,
    "nome": "Cristiano Ronaldo",
    "posicao": "Atacante",
    "idade": 39,
    "altura": 1.87,
    "peso": 84.0,
    "nacionalidade": "Portugal",
    "clube": "Al Nassr",
    "salario": 200000000.0,
    "numeroCamisa": 7,
    "golsMarcados": 850,
    "status": "Ativo"
  }
]
```

### Controller (JogadorController.java)
```java
@RestController
@RequestMapping("/api/v1/jogadores")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class JogadorController {
    
    private List<Jogador> jogadores = new ArrayList<>();

    @PostConstruct
    public void carregarJson() {
        // Implementar carregamento do JSON
    }

    @GetMapping
    public List<Jogador> listarJogadores() {
        return jogadores;
    }

    // Implementar demais endpoints...
}
```

## 📊 Critérios de Avaliação

| Critério | Peso | Descrição |
|----------|------|-----------|
| **Estrutura do Projeto** | 20% | Organização de pacotes, nomenclatura |
| **Model Completo** | 20% | Atributos relevantes, getters/setters |
| **Controller Funcional** | 40% | Endpoints implementados |
| **Funcionamento** | 20% | API executa sem erros |

## 📧 Instruções de Entrega

1. **Compacte** todo o projeto em um arquivo ZIP
2. **Nomeie** o arquivo como: `API_[TEMA]_[SEU_NOME].zip`
   - Exemplo: `API_JOGADORES_JOAO_SILVA.zip`
3. **Envie** para: **vitor.jesus@pro.fecaf.com.br**
4. **Assunto** do email: `[FECAF] Entrega API REST - [SEU NOME]`
5. **Prazo**: Quinta Feira 06/11

## ⚠️ Observações Importantes

- ❌ **NÃO** copie o código da API de Carros
- ✅ **USE** como referência e adapte para seu tema
- ✅ **TESTE** todos os endpoints antes da entrega
- ✅ **DOCUMENTE** sua API no README.md
- ❌ **NÃO** entregue projetos que não compilem
- ✅ **SEJA CRIATIVO** na escolha dos atributos

## 🆘 Dúvidas?

- Consulte o README.md da API de Carros como referência

---

**Boa sorte e mãos à obra! 🚀**

**  🚀  Profº Vitor de Jesus 🚀  **
