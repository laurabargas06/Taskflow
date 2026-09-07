package com.taskflow.taskflow.CRUD;

import org.springframework.data.jpa.repository.JpaRepository;
import com.taskflow.taskflow.CRUD.Projeto;
import java.util.List;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
    
    List<Projeto> findByUsuarioIdusuario(Long idUsuario);
    
    void deleteByUsuarioIdusuario(Long idusuario);
}