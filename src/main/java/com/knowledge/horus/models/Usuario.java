package com.knowledge.horus.models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "Usuarios")
public class Usuario implements Serializable{

    @Id
    @Column(name = "Matricula")
    private Long matricula;

    @Column(name = "Nome", nullable = false, length = 50)
    private String nome;
    
    @Column(name = "Login", nullable = false, length = 15)
    private String login;
    
    @Column(name = "Senha", nullable = false, length = 15)
    private String senha;
    
    @Column(name = "Foto", nullable = false, columnDefinition = "mediumblob")
    private byte[] foto;
    
    @Column(name = "Nivel", nullable = false, length = 15)
    private String nivel;
    
    public Usuario(){
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.matricula);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "matricula=" + matricula + ","
                + " nome=" + nome + ","
                + " login=" + login + ","
                + " senha=" + senha + ","
                + " nivel=" + nivel + '}';
    }
    
    
}
