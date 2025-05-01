package com.knowledge.horus.models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "Movimentacao")
public class Movimentacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "Id")
    private Long id;
    
    @Column(name = "Código", nullable = false)
    private Long codigo;
    
    @Column(name = "Descrição", length = 50)
    private String descricao;
    
    @Column(name = "Status", length = 20)
    private String status;
    
    @Column(name = "Fornecedor", length = 50)
    private String fornecedor;
    
    @Column(name = "Esterilizador", length = 30)
    private String esterilizador;
    
    @Column(name = "Cirurgia", length = 30)
    private String cirurgia;
    
    @Column(name = "Paciente", length = 30)
    private String paciente;
    
    @Column(name = "Setor", length = 50)
    private String setor;
    
    @Column(name = "Processamento", length = 30)
    private String processamento;
    
    @Column(name = "Validade", length = 30)
    private String validade;
    
    @Column(name = "Prazo", length = 30)
    private int prazo;
    
    @Column(name = "Procedimento", length = 30)
    private String procedimento;
    
    @Column(name = "Recebi", length = 50)
    private String recebi;
    
    @Column(name = "NumLote", length = 20)
    private String numlote;
    
    @Column(name = "Método", length = 30)
    private String metodo;
    
    @Column(name = "Ciclo", length = 10)
    private int ciclo;
    
    @Column(name = "Inicio", length = 30)
    private String inicio;
    
    @Column(name = "Fim", length = 30)
    private String fim;
    
    @Column(name = "Qtd", length = 5)
    private int qtd;
    
    @Column(name = "Anexo", columnDefinition = "mediumblob")
    private byte[] anexo;
    
    @Column(name = "Dano", length = 100)
    private String dano;
    
    @Column(name = "Ação", length = 100)
    private String acao;
    
    @Column(name = "Data", length = 30)
    private String data;
    
    @Column(name = "Operador", length = 30)
    private String operador;
    
    @Column(name = "Lote", length = 20)
    private int lote;
    
    @Column(name = "NovoLote", length = 20)
    private int novolote;
    
    @Column(name = "NovoCiclo", length = 20)
    private int novociclo;
    
    @Column(name = "Supervisor", length = 50)
    private String supervisor;
    
    @Column(name = "Ocorrencia", length = 50)
    private String ocorrencia;
    
    @Column(name = "Teste", length = 20)
    private String teste;
    
    @Column(name = "Enbalagem", length = 20)
    private String embalagem;
    
    @Column(name = "Integridade", length = 20)
    private String integridade;
    
    @Column(name = "Humidade", length = 20)
    private String humidade;
    
    @Column(name = "Selagem", length = 20)
    private String selagem;
    
    @Column(name = "Identificação", length = 20)
    private String identificacao;
    
    @Column(name = "Integrador", length = 20)
    private String integrador;
    
    @Column(name = "Pertence", length = 50)
    private String pertence;
    
    @Column(name = "Fantasia", length = 50)
    private String fantasia;
    
    @Column(name = "Concluido", length = 30)
    private String concluido;
    
    @Column(name = "Destino", length = 30)
    private String destino;
    
    /*private String busca;
    private int r;
    private String dir;
    private int sql;
    private int pos;
    private String query;*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getEsterilizador() {
        return esterilizador;
    }

    public void setEsterilizador(String esterilizador) {
        this.esterilizador = esterilizador;
    }

    public String getCirurgia() {
        return cirurgia;
    }

    public void setCirurgia(String cirurgia) {
        this.cirurgia = cirurgia;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getProcessamento() {
        return processamento;
    }

    public void setProcessamento(String processamento) {
        this.processamento = processamento;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public int getPrazo() {
        return prazo;
    }

    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }

    public String getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(String procedimento) {
        this.procedimento = procedimento;
    }

    public String getRecebi() {
        return recebi;
    }

    public void setRecebi(String recebi) {
        this.recebi = recebi;
    }

    public String getNumlote() {
        return numlote;
    }

    public void setNumlote(String numlote) {
        this.numlote = numlote;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public int getCiclo() {
        return ciclo;
    }

    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFim() {
        return fim;
    }

    public void setFim(String fim) {
        this.fim = fim;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public byte[] getAnexo() {
        return anexo;
    }

    public void setAnexo(byte[] anexo) {
        this.anexo = anexo;
    }

    public String getDano() {
        return dano;
    }

    public void setDano(String dano) {
        this.dano = dano;
    }

    public String getAção() {
        return acao;
    }

    public void setAção(String ação) {
        this.acao = ação;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public int getLote() {
        return lote;
    }

    public void setLote(int lote) {
        this.lote = lote;
    }

    public int getNovolote() {
        return novolote;
    }

    public void setNovolote(int novolote) {
        this.novolote = novolote;
    }

    public int getNovociclo() {
        return novociclo;
    }

    public void setNovociclo(int novociclo) {
        this.novociclo = novociclo;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getOcorrencia() {
        return ocorrencia;
    }

    public void setOcorrencia(String ocorrencia) {
        this.ocorrencia = ocorrencia;
    }

    public String getTeste() {
        return teste;
    }

    public void setTeste(String teste) {
        this.teste = teste;
    }

    public String getEmbalagem() {
        return embalagem;
    }

    public void setEmbalagem(String embalagem) {
        this.embalagem = embalagem;
    }

    public String getIntegridade() {
        return integridade;
    }

    public void setIntegridade(String integridade) {
        this.integridade = integridade;
    }

    public String getHumidade() {
        return humidade;
    }

    public void setHumidade(String humidade) {
        this.humidade = humidade;
    }

    public String getSelagem() {
        return selagem;
    }

    public void setSelagem(String selagem) {
        this.selagem = selagem;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public String getIntegrador() {
        return integrador;
    }

    public void setIntegrador(String integrador) {
        this.integrador = integrador;
    }

    public String getPertence() {
        return pertence;
    }

    public void setPertence(String pertence) {
        this.pertence = pertence;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    public String getConcluido() {
        return concluido;
    }

    public void setConcluido(String concluido) {
        this.concluido = concluido;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.id);
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
        final Movimentacao other = (Movimentacao) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Movimentacao{" + "id=" + id + ","
                + " codigo=" + codigo + ","
                + " descricao=" + descricao + ","
                + " status=" + status + ","
                + " fornecedor=" + fornecedor + ","
                + " esterilizador=" + esterilizador + ","
                + " cirurgia=" + cirurgia + ","
                + " paciente=" + paciente + ","
                + " setor=" + setor + ","
                + " processamento=" + processamento + ","
                + " validade=" + validade + ","
                + " prazo=" + prazo + ","
                + " procedimento=" + procedimento + ","
                + " recebi=" + recebi + ","
                + " numlote=" + numlote + ","
                + " metodo=" + metodo + ","
                + " ciclo=" + ciclo + ","
                + " inicio=" + inicio + ","
                + " fim=" + fim + ","
                + " qtd=" + qtd + ","
                + " dano=" + dano + ","
                + " acao=" + acao + ","
                + " data=" + data + ","
                + " operador=" + operador + ","
                + " lote=" + lote + ","
                + " novolote=" + novolote + ","
                + " novociclo=" + novociclo + ","
                + " supervisor=" + supervisor + ","
                + " ocorrencia=" + ocorrencia + ","
                + " teste=" + teste + ","
                + " embalagem=" + embalagem + ","
                + " integridade=" + integridade + ","
                + " humidade=" + humidade + ","
                + " selagem=" + selagem + ","
                + " identificacao=" + identificacao + ","
                + " integrador=" + integrador + ","
                + " pertence=" + pertence + ","
                + " fantasia=" + fantasia + ","
                + " concluido=" + concluido + ","
                + " destino=" + destino + '}';
    }
}
    