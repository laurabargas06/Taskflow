package com.taskflow.taskflow.CRUD;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity 
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idusuario;

    @Column(name = "nomeusuario", nullable = false)
    private String nomeusuario;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "senha", nullable = false)
    private String senha;

    public Long getIdUsuario() {
        return idusuario;
    }

    public String getNomeUsuario() {
        return nomeusuario;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
    public void setIdUsuario(Long idusuario) {
        this.idusuario = idusuario;
    }
    public void setNomeUsuario(String nomeusuario) {
        this.nomeusuario = nomeusuario;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
