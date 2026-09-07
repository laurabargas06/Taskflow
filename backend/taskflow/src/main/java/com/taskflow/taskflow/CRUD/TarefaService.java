package com.taskflow.taskflow.CRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TarefaService { 

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ProjetoRepository projetoRepository;

    public Tarefa criarTarefa(Tarefa tarefa, Long idUsuario, Long idProjeto) {
        Usuario usuario = usuarioRepository.findById(idUsuario).get();
        Projeto projeto = projetoRepository.findById(idProjeto).get();

        tarefa.setUsuario(usuario);
        tarefa.setProjeto(projeto);

        return tarefaRepository.save(tarefa);
    }

    public Tarefa atualizarTarefa(Long id, Tarefa tarefaAtualizada, Long idUsuario, Long idProjeto) {
    // 1. Busca a tarefa existente pelo ID passado na URL
    Tarefa tarefaExistente = tarefaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Tarefa não encontrada com o id: " + id));

    // 2. Busca o usuário e o projeto
    Usuario usuario = usuarioRepository.findById(idUsuario)
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    Projeto projeto = projetoRepository.findById(idProjeto)
            .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));

    // 3. Atualiza os dados
    tarefaExistente.setNomeTarefa(tarefaAtualizada.getNomeTarefa());
    tarefaExistente.setDescricao(tarefaAtualizada.getDescricao());
    tarefaExistente.setStatus(tarefaAtualizada.getStatusTarefa());
    tarefaExistente.setUsuario(usuario);
    tarefaExistente.setProjeto(projeto);

    return tarefaRepository.save(tarefaExistente);
}

    public Tarefa buscarTarefa(Long id){
        return tarefaRepository.findById(id).get();
    }

    public Iterable<Tarefa> buscarTarefas(){
        return tarefaRepository.findAll();
    }

    public void deletarTarefa(Long id){
        tarefaRepository.deleteById(id);
    }

    public Iterable<Tarefa> buscarTarefasPorUsuario(Long idUsuario) {
        return tarefaRepository.findByUsuarioIdusuario(idUsuario);
    }

    public void deletarTarefasPorUsuario(Long idUsuario) {
        tarefaRepository.deleteByUsuarioIdusuario(idUsuario);
    }
}
