package com.knowledge.horus.controls;

import com.knowledge.horus.models.Equipamentos;
import java.util.List;

/*import Controle.Conexão;
import Modelos.Cme.EquipamentosMod;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;*/


public class EquipamentosDAO extends GenericDAO<Equipamentos>{
    
    public EquipamentosDAO() {
        super(Equipamentos.class);
    }
    
    public List<Equipamentos> findByLogin(String Login) {
        String jpql = "from Usuario p where p.login like ?1";
        return find(jpql, Login);
    }
    
    
    
    /*Conexão conex = new Conexão();
    
    public void Salvar(EquipamentosMod equipa){
        conex.conectar();
        try {
            PreparedStatement pst = conex.con.prepareStatement("INSERT INTO equipamentos (id, descrição,"
                    + " status, série, código) VALUES (?, ?, ?, ?, ?)");
            pst.setString(1, equipa.getId());
            pst.setString(2, equipa.getDescrição());
            pst.setString(3, equipa.getStatus());
            pst.setString(4, equipa.getSérie());
            pst.setString(5, equipa.getCódigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir dados:\n"+ex.getMessage());
        }    
        conex.desconectar();
    }
    
    public EquipamentosMod Buscar(EquipamentosMod equipa){
        conex.conectar();
        try {
            conex.execSql("SELECT * FROM equipamentos WHERE código = "+"'"+((String) equipa.getBusca().intern().trim())+"'");
            conex.rs.next();
            equipa.setId(conex.rs.getString("id"));
            equipa.setDescrição(conex.rs.getString("descrição"));
            equipa.setStatus(conex.rs.getString("status"));
            equipa.setSérie(conex.rs.getString("série"));
            equipa.setCódigo(conex.rs.getString("código"));
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Equipamento não encontrado!");
        }
        conex.desconectar();
        return equipa;
    }
    
    public void Editar(EquipamentosMod equipa){
        conex.conectar();
        try {
            PreparedStatement pst = conex.con.prepareStatement("UPDATE equipamentos SET "
                    + "status = '"+equipa.getStatus()+"' WHERE código = ?");
            pst.setString(1, equipa.getCódigo());
            pst.execute();
            //JOptionPane.showMessageDialog(null, "Dados substituidos com sucesso!");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao substituir dados:\n"+ex.getMessage());
        }    
        conex.desconectar();
    }*/
}
