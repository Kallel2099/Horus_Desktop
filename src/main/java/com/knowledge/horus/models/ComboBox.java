package com.knowledge.horus.models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "ComboBox",
        indexes = {@Index(columnList = "Descricao, Uso",
                name = "IDX_ComboBox", unique = true)})
public class ComboBox implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "Id")
    private Integer id;
    
    @Column(name = "Uso", length = 30)
    private String uso;
    
    @Column(name = "Descricao", length = 50)
    private String descrição;

    public ComboBox() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.uso);
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
        final ComboBox other = (ComboBox) obj;
        return Objects.equals(this.uso, other.uso);
    }

    @Override
    public String toString() {
        return "ComboBox{" + "id=" + id + ","
            + " uso=" + uso + ","
            + " descri\u00e7\u00e3o=" + descrição + '}';
    }    
}