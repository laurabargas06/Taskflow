package com.taskflow.taskflow.CRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuariorepository;

    public Usuario criarUsuario(Usuario usuario){
       return usuariorepository.save(usuario);
    }

    public Usuario atualizarUsuario(Usuario usuario){
        return usuariorepository.save(usuario);
    }

    public Usuario buscarUsuario(Long id){
        return usuariorepository.findById(id).get();
    }
    public Iterable<Usuario> buscarUsuarios(){
        return usuariorepository.findAll();
    }
    public void deletarUsuario(Long id){
        usuariorepository.deleteById(id);
    }
}
