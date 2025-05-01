package com.knowledge.horus.models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "Banco",
        indexes = {@Index(columnList = "Ítem, Tipo, Especialidade, Descrição",
                name = "IDX_Banco", unique = true)})
public class Banco implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "Id")
    private Long id;
    
    @Column(name = "Ítem", length = 30)
    private String item;
    
    @Column(name = "Tipo", length = 30)
    private String tipo;
    
    @Column(name = "Especialidade", length = 50)
    private String especialidade;
    
    @Column(name = "Descrição", length = 50)
    private String descricao;
    
    @Column(name = "Formato", length = 30)
    private String formato;
    
    @Column(name = "Tamanho")
    private double tamanho;
    
    @Column(name = "Unidade1", length = 10)
    private String unidade1;
    
    @Column(name = "LarguraA")
    private double larguraa;
    
    @Column(name = "Unidade2", length = 10)
    private String unidade2;
    
    @Column(name = "LarguraB")
    private double largurab;
    
    @Column(name = "Unidade3", length = 10)
    private String unidade3;
    
    @Column(name = "Comp")
    private double comp;
    
    @Column(name = "Unidade4", length = 10)
    private String unidade4;
    
    @Column(name = "Diametro")
    private double diametro;
    
    @Column(name = "Unidade5", length = 10)
    private String unidade5;
    
    @Column(name = "Ponta", length = 30)
    private String ponta;
    
    @Column(name = "Orientação", length = 30)
    private String orientacao;
    
    @Column(name = "Angulo", length = 30)
    private String angulo;
    
    @Column(name = "Num", length = 30)
    private String num;
    
    @Column(name = "Serrilha", length = 30)
    private String serrilha;
    
    @Column(name = "Widia", length = 30)
    private String widia;
    
    @Column(name = "Dente", length = 30)
    private String dente;
    
    @Column(name = "Trava", length = 30)
    private String trava;
    
    @Column(name = "Furo", length = 30)
    private String furo;
    
    @Column(name = "Outro1", length = 30)
    private String outro1;
    
    @Column(name = "Outro2", length = 30)
    private String outro2;
    
    @Column(name = "Outro3", length = 30)
    private String outro3;
    
    @Column(name = "Imagem", columnDefinition = "mediumblob")
    private byte[] imagem;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getDescrição() {
        return descricao;
    }

    public void setDescrição(String descrição) {
        this.descricao = descrição;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public double getTamanho() {
        return tamanho;
    }

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }

    public String getUnidade1() {
        return unidade1;
    }

    public void setUnidade1(String unidade1) {
        this.unidade1 = unidade1;
    }

    public double getLarguraa() {
        return larguraa;
    }

    public void setLarguraa(double larguraa) {
        this.larguraa = larguraa;
    }

    public String getUnidade2() {
        return unidade2;
    }

    public void setUnidade2(String unidade2) {
        this.unidade2 = unidade2;
    }

    public double getLargurab() {
        return largurab;
    }

    public void setLargurab(double largurab) {
        this.largurab = largurab;
    }

    public String getUnidade3() {
        return unidade3;
    }

    public void setUnidade3(String unidade3) {
        this.unidade3 = unidade3;
    }

    public double getComp() {
        return comp;
    }

    public void setComp(double comp) {
        this.comp = comp;
    }

    public String getUnidade4() {
        return unidade4;
    }

    public void setUnidade4(String unidade4) {
        this.unidade4 = unidade4;
    }

    public double getDiametro() {
        return diametro;
    }

    public void setDiametro(double diametro) {
        this.diametro = diametro;
    }

    public String getUnidade5() {
        return unidade5;
    }

    public void setUnidade5(String unidade5) {
        this.unidade5 = unidade5;
    }

    public String getPonta() {
        return ponta;
    }

    public void setPonta(String ponta) {
        this.ponta = ponta;
    }

    public String getOrientação() {
        return orientacao;
    }

    public void setOrientação(String orientação) {
        this.orientacao = orientação;
    }

    public String getAngulo() {
        return angulo;
    }

    public void setAngulo(String angulo) {
        this.angulo = angulo;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getSerrilha() {
        return serrilha;
    }

    public void setSerrilha(String serrilha) {
        this.serrilha = serrilha;
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

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.id);
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
        final Banco other = (Banco) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Banco{" + "id=" + id + ","
                + " item=" + item + ","
                + " tipo=" + tipo + ","
                + " especialidade=" + especialidade + ","
                + " descricao=" + descricao + ","
                + " formato=" + formato + ","
                + " tamanho=" + tamanho + ","
                + " unidade1=" + unidade1 + ","
                + " larguraa=" + larguraa + ","
                + " unidade2=" + unidade2 + ","
                + " largurab=" + largurab + ","
                + " unidade3=" + unidade3 + ","
                + " comp=" + comp + ","
                + " unidade4=" + unidade4 + ","
                + " diametro=" + diametro + ","
                + " unidade5=" + unidade5 + ","
                + " ponta=" + ponta + ","
                + " orientacao=" + orientacao + ","
                + " angulo=" + angulo + ","
                + " num=" + num + ","
                + " serrilha=" + serrilha + ","
                + " widia=" + widia + ","
                + " dente=" + dente + ","
                + " trava=" + trava + ","
                + " furo=" + furo + ","
                + " outro1=" + outro1 + ","
                + " outro2=" + outro2 + ","
                + " outro3=" + outro3 + ","
                + " imagem=" + imagem + '}';
    }
}