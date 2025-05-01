package com.knowledge.horus.controls;

import com.knowledge.horus.models.Kit;
import java.util.List;

/*import Controle.Conexão;
import Modelos.Cme.KitMod;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;*/

public class KitDAO extends GenericDAO<Kit> {
    
    public KitDAO() {
        super(Kit.class);
    }
    
    public List<Kit> findByLogin(String Login) {
        String jpql = "from Usuario p where p.login like ?1";
        return find(jpql, Login);
    }
    
    
    
    
    
    
    
    
    /*Conexão conex = new Conexão();
    
    public void Criar(KitMod kit){
        conex.conectar();
        String ki = ("kt"+kit.getCódKt());
        try {
            PreparedStatement pst = conex.con.prepareStatement("CREATE TABLE "+ki+" (código CHAR(15) PRIMARY KEY,"
                    + " descrição CHAR(50))");
            pst.execute();
            JOptionPane.showMessageDialog(null, "Novo kit criado!");
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "O kit já existe no sistema.\nPara editá-lo, clique no botão Editar,"
                    + "\nou, para montar um novo kit, clique no botão Limpar.");
            kit.setStatus(1);
        }
        conex.desconectar();
    }
    
    public void Salvar(KitMod kit){
        conex.conectar();
        String ki = ("kt"+kit.getCódKt());
        try {
            PreparedStatement pst = conex.con.prepareStatement("INSERT INTO "+ki+" (código,"
                    + " descrição) VALUES (?, ?)");
            pst.setString(1, kit.getCódInst());
            pst.setString(2, kit.getDesInst());
            pst.execute();
            //JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir dados:\n"+ex.getMessage());
        }    
        conex.desconectar();
    }
    
    public KitMod Buscar(KitMod kit){
        conex.conectar();
        String ki = ("kt"+kit.getCódKt());
        conex.execSql("SELECT * FROM "+ki+"");
        try {
            conex.rs.last();
            kit.setLin(conex.rs.getRow());
            if ((kit.getPos()) != 0) {
                conex.rs.absolute(kit.getPos());
                kit.setCódInst(conex.rs.getString("código"));
                kit.setDesInst(conex.rs.getString("descrição"));
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Kit não encontrado!\n");
        }
        conex.desconectar();
        return kit;
    }

    public void Excluir(KitMod kit){
        conex.conectar();
        String ki = ("kt"+kit.getCódKt());
        try {
            PreparedStatement pst = conex.con.prepareStatement("DELETE FROM "+ki+" WHERE CódKt=?");
            pst.setString(1, kit.getCódKt());
            pst.execute();
            //JOptionPane.showMessageDialog(null, "Ítem excluído com sucesso!");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir Ítem:\n"+ex.getMessage());
        }    
        conex.desconectar();
    }
    
    public void Limpar(KitMod kit){
        conex.conectar();
        String ki = ("kt"+kit.getCódKt());
        try {
            PreparedStatement pst = conex.con.prepareStatement("DELETE FROM "+ki+"");
            pst.execute();
            //JOptionPane.showMessageDialog(null, "Kit esvaziado com sucesso!");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao esvaziar o Kit:\n"+ex.getMessage());
        }    
        conex.desconectar();
    }

    public void ExcluirKit(KitMod kit) {
        conex.conectar();
        String ki = ("kt"+kit.getCódKt());
        try {
            PreparedStatement pst = conex.con.prepareStatement("DROP TABLE "+ki+"");
            pst.execute();
            JOptionPane.showMessageDialog(null, "Kit excluído com sucesso!");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir o kit:\n"+ex.getMessage());
        }    
        conex.desconectar();
    }
    
    public void TestaKit(KitMod kit){
        conex.conectar();
        String ki = ("kt"+kit.getCódKt());
        PreparedStatement pst;
        try {
            pst = conex.con.prepareStatement("CREATE TABLE "+ki+" (código CHAR(1) PRIMARY KEY)");
            pst.execute();
            pst = conex.con.prepareStatement("DROP TABLE "+ki+"");
            pst.execute();
            kit.setStatus(0);
            //JOptionPane.showMessageDialog(null, "Este kit não existe no banco");
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Este kit já foi cadastrado.\nPara editá-lo, clique no botão Editar,"
            //        + "\nou, para montar um novo kit, clique no botão Limpar.");
            kit.setStatus(1);
        }
        conex.desconectar();
    }*/
}
