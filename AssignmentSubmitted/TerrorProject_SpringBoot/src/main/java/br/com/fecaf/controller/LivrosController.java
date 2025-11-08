package br.com.fecaf.controller;

import br.com.fecaf.model.LivroDeTerror;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/livros")
public class LivrosController {

    private final List<LivroDeTerror> livros = new ArrayList<>();

    @PostConstruct
    public void carregarDadosIniciais() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("data/livros.json")) {
            if (is != null) {
                List<LivroDeTerror> dados = mapper.readValue(is, new TypeReference<List<LivroDeTerror>>() {});
                livros.clear();
                livros.addAll(dados);
            }
        }
    }

    @GetMapping("/listarTodosOsLivros")
    public List<LivroDeTerror> listarTodos() {
        return livros;
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroDeTerror> buscarPorId(@PathVariable Long id) {
        Optional<LivroDeTerror> encontrado = livros.stream()
                .filter(l -> id.equals(l.getId()))
                .findFirst();
        return encontrado.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}