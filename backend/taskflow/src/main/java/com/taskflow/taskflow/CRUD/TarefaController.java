package com.taskflow.taskflow.CRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/tarefa")
public class TarefaController {
    @Autowired
    private TarefaService tarefaService;

    @GetMapping
    public Iterable<Tarefa> listarTarefas() {
    return tarefaService.buscarTarefas();
    }

    @GetMapping("/{id}")
    public Tarefa buscarTarefa(@PathVariable Long id) {
        return tarefaService.buscarTarefa(id);
    }

    @PostMapping
    public Tarefa criarTarefa(@RequestBody Tarefa tarefa, @RequestParam Long idUsuario, @RequestParam Long idProjeto) {
        return tarefaService.criarTarefa(tarefa, idUsuario, idProjeto);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizarTarefa(
        @PathVariable Long id,
        @RequestBody Tarefa tarefa,
        @RequestParam Long idUsuario,
        @RequestParam Long idProjeto) {

       Tarefa tarefaAtualizada = tarefaService.atualizarTarefa(id, tarefa, idUsuario, idProjeto);
        return ResponseEntity.ok(tarefaAtualizada);
    }

    @DeleteMapping("/{id}")
    public void deletarTarefa(@PathVariable Long id) {
        tarefaService.deletarTarefa(id);
    }

}
