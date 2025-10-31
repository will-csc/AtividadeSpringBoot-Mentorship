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

    // 🔹 O método será chamado automaticamente ao iniciar a aplicação
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

    // ✅ GET - lista todos os carros
    @GetMapping
    public List<Carro> listarCarros() {
        return carros;
    }
}
