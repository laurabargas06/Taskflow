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

    public Tarefa atualizarTarefa(Tarefa tarefa, Long idUsuario, Long idProjeto) {
        Usuario usuario = usuarioRepository.findById(idUsuario).get();
        Projeto projeto = projetoRepository.findById(idProjeto).get();

        tarefa.setUsuario(usuario);
        tarefa.setProjeto(projeto);

        return tarefaRepository.save(tarefa);
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
        return tarefaRepository.findByUsuarioId(idUsuario);
    }

    public void deletarTarefasPorUsuario(Long idUsuario) {
        tarefaRepository.deleteByUsuarioId(idUsuario);
    }
}
