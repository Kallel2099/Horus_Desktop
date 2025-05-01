package com.knowledge.horus.controls;

import com.knowledge.horus.models.Caixa;
import java.util.List;

/*import Controle.Conexão;
import Modelos.Cme.CaixaMod;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;*/

public class CaixaDAO extends GenericDAO<Caixa> {
    
    public CaixaDAO() {
        super(Caixa.class);
    }
    
    public List<Caixa> findByLogin(String Login) {
        String jpql = "from Usuario p where p.login like ?1";
        return find(jpql, Login);
    }
    
    
    
    
    
    
    
    
    
    
    
    /*
    Conexão conex = new Conexão();
    
    public void Criar(CaixaMod caixa){
        conex.conectar();
        String table = ("cx"+caixa.getCódCx());
        try {
            PreparedStatement pst = conex.con.prepareStatement("CREATE TABLE "+table+" (código CHAR(15) PRIMARY KEY,"
                    + " descrição CHAR(50))");
            pst.execute();
            JOptionPane.showMessageDialog(null, "Nova caixa criada!");
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "A caixa já existe no sistema.\nPara editá-la, clique no botão Editar,"
                    + "\nou, para montar uma nova caixa, clique no botão Limpar.");
            caixa.setStatus(1);
        }
        conex.desconectar();
    }
    
    public void Salvar(CaixaMod caixa){
        conex.conectar();
        String table = ("cx"+caixa.getCódCx());
        try {
            PreparedStatement pst = conex.con.prepareStatement("INSERT INTO "+table+" (código,"
                    + " descrição) VALUES (?, ?)");
            pst.setString(1, caixa.getCódInst());
            pst.setString(2, caixa.getDesInst());
            pst.execute();
            //JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir dados:\n"+ex.getMessage());
        }    
        conex.desconectar();
    }
    
    public CaixaMod Buscar(CaixaMod caixa){
        conex.conectar();
        String table = ("cx"+caixa.getCódCx());
        conex.execSql("SELECT * FROM "+table+"");
        try {
            conex.rs.last();
            caixa.setLin(conex.rs.getRow());
            if ((caixa.getPos()) != 0) {
                conex.rs.absolute(caixa.getPos());
                caixa.setCódInst(conex.rs.getString("código"));
                caixa.setDesInst(conex.rs.getString("descrição"));
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Caixa não encontrada!\n");
        }
        conex.desconectar();
        return caixa;
    }

    public void Excluir(CaixaMod caixa){
        conex.conectar();
        String table = ("cx"+caixa.getCódCx());
        try {
            PreparedStatement pst = conex.con.prepareStatement("DELETE FROM "+table+" WHERE CódCx=?");
            pst.setString(1, caixa.getCódCx());
            pst.execute();
            //JOptionPane.showMessageDialog(null, "Ítem excluído com sucesso!");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir Ítem:\n"+ex.getMessage());
        }    
        conex.desconectar();
    }
    
    public void Limpar(CaixaMod caixa){
        conex.conectar();
        String table = ("cx"+caixa.getCódCx());
        try {
            PreparedStatement pst = conex.con.prepareStatement("DELETE FROM "+table+"");
            pst.execute();
            //JOptionPane.showMessageDialog(null, "Caixa esvaziada com sucesso!");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao esvaziar Caixa:\n"+ex.getMessage());
        }    
        conex.desconectar();
    }

    public void ExcluirCaixa(CaixaMod caixa) {
        conex.conectar();
        String table = ("cx"+caixa.getCódCx());
        try {
            PreparedStatement pst = conex.con.prepareStatement("DROP TABLE "+table+"");
            pst.execute();
            JOptionPane.showMessageDialog(null, "Caixa excluída com sucesso!");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir Caixa:\n"+ex.getMessage());
        }    
        conex.desconectar();
    }
    
    public void TestaCaixa(CaixaMod caixa){
        conex.conectar();
        String table = ("cx"+caixa.getCódCx());
        PreparedStatement pst;
        try {
            pst = conex.con.prepareStatement("CREATE TABLE "+table+" (código CHAR(1) PRIMARY KEY)");
            pst.execute();
            pst = conex.con.prepareStatement("DROP TABLE "+table+"");
            pst.execute();
            caixa.setStatus(0);
            //JOptionPane.showMessageDialog(null, "Esta caixa não existe no banco");
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Esta caixa já foi cadastrada.\nPara editá-la, clique no botão Editar,"
            //        + "\nou, para montar uma nova caixa, clique no botão Limpar.");
            caixa.setStatus(1);
        }
        conex.desconectar();
    }*/
}
