package com.knowledge.horus.models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "Equipamentos")
public class Equipamentos implements Serializable {
    
    @Column(name = "Id", nullable = false, length = 10)
    private String id;
    
    @Column(name = "Descrição", nullable = false, length = 30)
    private String des;
    
    @Column(name = "Status", length = 10)
    private String status;
    
    @Id
    @Column(name = "Código", nullable = false, length = 10)
    private String cod;
    
    @Column(name = "Série", length = 15)
    private String serie;
    
    
    //private String busca;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final Equipamentos other = (Equipamentos) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Equipamentos{" + "id=" + id + ","
                + " des=" + des + ","
                + " status=" + status + ","
                + " cod=" + cod + ","
                + " serie=" + serie + '}';
    }

    
}