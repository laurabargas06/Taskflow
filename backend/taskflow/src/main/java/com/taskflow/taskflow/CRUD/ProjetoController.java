package com.taskflow.taskflow.CRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/projeto")
public class ProjetoController {
    @Autowired
    private ProjetoService projetoservice;

    @GetMapping
    public Iterable<Projeto> listarProjetos() {
        return projetoservice.buscarProjetos();
    }

    @GetMapping("/{id}")
    public Projeto buscarProjeto(@PathVariable Long id) {
        return projetoservice.buscarProjeto(id);
    }

    @PostMapping
    public Projeto criarProjeto(@RequestBody Projeto projeto, @RequestParam Long idUsuario) {
        return projetoservice.criarProjeto(projeto, idUsuario);
    }

    @PutMapping("/{id}")
    public Projeto atualizarProjeto(@PathVariable Long id, @RequestBody Projeto projeto, @RequestParam Long idUsuario) {
        projeto.setIdProjeto(id);
        return projetoservice.atualizarProjeto(projeto, idUsuario);
    }

    @DeleteMapping("/{id}")
    public void deletarProjeto(@PathVariable Long id) {
        projetoservice.deletarProjeto(id);
    }
}
