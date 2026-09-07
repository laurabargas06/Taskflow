package com.taskflow.taskflow.CRUD;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity // define que essa classe é uma entidade do BD
@Table(name = "tarefa")
public class Tarefa {
       public enum statusTarefa {
         PENDENTE,
         EM_ANDAMENTO,
         CONCLUIDA
       }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idtarefa;

    @Column(name = "nomeprojeto", nullable = false) // Mapeia para a coluna 'nomeTarefa'
    private String nometarefa;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "idusuario", nullable = false)
      private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idprojeto", nullable = false)
     private Projeto projeto;
    
    @Enumerated(EnumType.ORDINAL)
    @Column (name = "status", nullable = false)
    private statusTarefa status;

    public statusTarefa getStatusTarefa() {
         return status;
    }

    public String getDescricao() {
         return descricao;
    }

    public long getIdTarefa() {
         return idtarefa;
    }

    public String getNomeTarefa() {
         return nometarefa;
    }

    public Usuario getUsuario() {
    return usuario;
    }

   public Projeto getProjeto() {
    return projeto;
   }


    public void setStatus(statusTarefa status) {
     this.status = status;
    }

    public void setIdTarefa(long idTarefa) {
     this.idtarefa = idTarefa;
    }

    public void setNomeTarefa(String nomeTarefa) {
     this.nometarefa = nomeTarefa;
    }

    public void setDescricao(String descricao) {
     this.descricao = descricao;
    }
    public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
    }
    public void setProjeto(Projeto projeto) {
    this.projeto = projeto;
    }
}
