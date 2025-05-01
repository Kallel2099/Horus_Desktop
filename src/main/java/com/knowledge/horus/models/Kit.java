package com.knowledge.horus.models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "Kit")
public class Kit implements Serializable {

    @Id
    @Column(name = "Código", nullable = false, length = 10)
    private String cod;
    
    @Column(name = "Descrição", nullable = false, length = 30)
    private String des;
    
    @Column(name = "Especialidade", nullable = false, length = 20)
    private String esp;
    
    @Column(name = "Fantasia", length = 20)
    private String fan;
    
    @Column(name = "Setor", length = 30)
    private String set;
    
    @Column(name = "Imagem", columnDefinition = "mediumblob")
    private byte[] img;
    
    //private String busca;
    //private int status;
    //private int lin;
    //private int pos;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getEsp() {
        return esp;
    }

    public void setEsp(String esp) {
        this.esp = esp;
    }

    public String getFan() {
        return fan;
    }

    public void setFan(String fan) {
        this.fan = fan;
    }

    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.cod);
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
        final Kit other = (Kit) obj;
        return Objects.equals(this.cod, other.cod);
    }

    @Override
    public String toString() {
        return "Kit{" + "cod=" + cod + ","
                + " des=" + des + ","
                + " esp=" + esp + ","
                + " fan=" + fan + ","
                + " set=" + set + '}';
    }
}