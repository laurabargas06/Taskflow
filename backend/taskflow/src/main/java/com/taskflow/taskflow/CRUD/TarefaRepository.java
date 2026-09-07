package com.taskflow.taskflow.CRUD;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.taskflow.taskflow.CRUD.Tarefa;
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
        List<Tarefa> findByUsuarioIdusuario(Long idUsuario);
        void deleteByUsuarioIdusuario(Long idUsuario);

}