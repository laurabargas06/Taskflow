package com.taskflow.taskflow.CRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class ProjetoService {
    @Autowired
    private ProjetoRepository projetorepository;

    @Autowired
    private UsuarioRepository usuariorepository;

    public Projeto criarProjeto(Projeto projeto, Long idUsuario){
        Usuario usuario = usuariorepository.findById(idUsuario).get();

        projeto.setUsuario(usuario);

        return projetorepository.save(projeto);
    }
    
    public Projeto atualizarProjeto(Projeto projeto, Long idUsuario){
        Usuario usuario = usuariorepository.findById(idUsuario).get();

        projeto.setUsuario(usuario);

        return projetorepository.save(projeto);
    }
    public Projeto buscarProjeto(Long id){
        return projetorepository.findById(id).get();
    }
    public Iterable<Projeto> buscarProjetos(){
        return projetorepository.findAll();
    }
    public void deletarProjeto(Long id){
        projetorepository.deleteById(id);
    }
    public Iterable<Projeto> buscarProjetosPorUsuario(Long idUsuario) {
        return projetorepository.findByUsuarioId(idUsuario);
    }
    public void deletarProjetosPorUsuario(Long idUsuario) {
        projetorepository.deleteByUsuarioId(idUsuario);
    }


}
