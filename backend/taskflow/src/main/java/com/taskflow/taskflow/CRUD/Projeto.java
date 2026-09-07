package com.taskflow.taskflow.CRUD;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "projeto")
public class Projeto{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
         private Long idprojeto;

        @Column (name = "nomeprojeto", nullable = false)
         private String nomeprojeto;

         @ManyToOne
         @JoinColumn (name = "idusuario", nullable = false)
          private Usuario usuario;

        public Long getIdProjeto() {
             return idprojeto;
        }
        public String getNomeProjeto(){
             return nomeprojeto;
        }
        public Usuario getUsuario(){
             return usuario;
        }
        
        public void setIdProjeto (long idProjeto){
             this.idprojeto = idProjeto;
        }

        public void setNomeProjeto(String nomeProjeto){
             this.nomeprojeto = nomeProjeto;
        }
        public void setUsuario(Usuario usuario){
             this.usuario = usuario;
        }
}