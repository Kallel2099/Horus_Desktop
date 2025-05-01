package com.knowledge.horus.models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "Instrumentais")
public class Instrumental implements Serializable {
    
    @Id
    @Column(name = "Código", nullable = false, length = 10)
    private String cod;
    
    @Column(name = "Descrição", nullable = false, length = 30)
    private String des;
    
    @Column(name = "Especialidade", nullable = false, length = 20)
    private String esp;
    
    @Column(name = "Fantasia", length = 20)
    private String fan;
    
    @Column(name = "Pertence", length = 20)
    private String per;
    
    @Column(name = "Formato", length = 10)
    private String form;
    
    @Column(name = "Tamanho", length = 5)
    private Double tam;
    
    @Column(name = "Unidade1", length = 5)
    private String unid1;
    
    @Column(name = "Altura", length = 5)
    private Double altu;
    
    @Column(name = "Unidade2", length = 5)
    private String unid2;
    
    @Column(name = "Largura", length = 5)
    private Double larg;
    
    @Column(name = "Unidade3", length = 5)
    private String unid3;
    
    @Column(name = "Comprimento", length = 5)
    private Double comp;
    
    @Column(name = "Unidade4", length = 5)
    private String unid4;
    
    @Column(name = "Diametro", length = 5)
    private Double diam;
    
    @Column(name = "Unidade5", length = 5)
    private String unid5;
    
    @Column(name = "Ponta", length = 15)
    private String pont;
    
    @Column(name = "Orientação", length = 15)
    private String orien;
    
    @Column(name = "Angulo", length = 15)
    private String angu;
    
    @Column(name = "Numero", length = 10)
    private String num;
    
    @Column(name = "Serrilha", length = 10)
    private String serr;
    
    @Column(name = "Widia", length = 10)
    private String widia;
    
    @Column(name = "Dente", length = 10)
    private String dente;
    
    @Column(name = "Trava", length = 10)
    private String trava;
    
    @Column(name = "Furo", length = 15)
    private String furo;
    
    @Column(name = "Outro1", length = 20)
    private String outro1;
    
    @Column(name = "Outro2", length = 20)
    private String outro2;
    
    @Column(name = "Outro3", length = 20)
    private String outro3;
    
    @Column(name = "Imagem", columnDefinition = "mediumblob")
    private byte[] img;
    private String seta;
    
    //private String item;
    //private String tipo;
    //private String detalhe;
    //private String busca;
    //private int id;
    //private int ok;
    //private String b;

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

    public String getPer() {
        return per;
    }

    public void setPer(String per) {
        this.per = per;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public Double getTam() {
        return tam;
    }

    public void setTam(Double tam) {
        this.tam = tam;
    }

    public String getUnid1() {
        return unid1;
    }

    public void setUnid1(String unid1) {
        this.unid1 = unid1;
    }

    public Double getAltu() {
        return altu;
    }

    public void setAltu(Double altu) {
        this.altu = altu;
    }

    public String getUnid2() {
        return unid2;
    }

    public void setUnid2(String unid2) {
        this.unid2 = unid2;
    }

    public Double getLarg() {
        return larg;
    }

    public void setLarg(Double larg) {
        this.larg = larg;
    }

    public String getUnid3() {
        return unid3;
    }

    public void setUnid3(String unid3) {
        this.unid3 = unid3;
    }

    public Double getComp() {
        return comp;
    }

    public void setComp(Double comp) {
        this.comp = comp;
    }

    public String getUnid4() {
        return unid4;
    }

    public void setUnid4(String unid4) {
        this.unid4 = unid4;
    }

    public Double getDiam() {
        return diam;
    }

    public void setDiam(Double diam) {
        this.diam = diam;
    }

    public String getUnid5() {
        return unid5;
    }

    public void setUnid5(String unid5) {
        this.unid5 = unid5;
    }

    public String getPont() {
        return pont;
    }

    public void setPont(String pont) {
        this.pont = pont;
    }

    public String getOrien() {
        return orien;
    }

    public void setOrien(String orien) {
        this.orien = orien;
    }

    public String getAngu() {
        return angu;
    }

    public void setAngu(String angu) {
        this.angu = angu;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getSerr() {
        return serr;
    }

    public void setSerr(String serr) {
        this.serr = serr;
    }

    public String getWidia() {
        return widia;
    }

    public void setWidia(String widia) {
        this.widia = widia;
    }

    public String getDente() {
        return dente;
    }

    public void setDente(String dente) {
        this.dente = dente;
    }

    public String getTrava() {
        return trava;
    }

    public void setTrava(String trava) {
        this.trava = trava;
    }

    public String getFuro() {
        return furo;
    }

    public void setFuro(String furo) {
        this.furo = furo;
    }

    public String getOutro1() {
        return outro1;
    }

    public void setOutro1(String outro1) {
        this.outro1 = outro1;
    }

    public String getOutro2() {
        return outro2;
    }

    public void setOutro2(String outro2) {
        this.outro2 = outro2;
    }

    public String getOutro3() {
        return outro3;
    }

    public void setOutro3(String outro3) {
        this.outro3 = outro3;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public String getSet() {
        return seta;
    }

    public void setSet(String set) {
        this.seta = set;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.cod);
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
        final Instrumental other = (Instrumental) obj;
        return Objects.equals(this.cod, other.cod);
    }

    @Override
    public String toString() {
        return "Instrumental{" + "cod=" + cod + ","
                + " des=" + des + ", esp=" + esp + ","
                + " fan=" + fan + ", per=" + per + ","
                + " form=" + form + ", tam=" + tam + ","
                + " unid1=" + unid1 + ", altu=" + altu + ","
                + " unid2=" + unid2 + ", larg=" + larg + ","
                + " unid3=" + unid3 + ", comp=" + comp + ","
                + " unid4=" + unid4 + ", diam=" + diam + ","
                + " unid5=" + unid5 + ", pont=" + pont + ","
                + " orien=" + orien + ", angu=" + angu + ","
                + " num=" + num + ", serr=" + serr + ","
                + " widia=" + widia + ", dente=" + dente + ","
                + " trava=" + trava + ", furo=" + furo + ","
                + " outro1=" + outro1 + ", outro2=" + outro2 + ","
                + " outro3=" + outro3 + ", set=" + seta + '}';
    }
}
