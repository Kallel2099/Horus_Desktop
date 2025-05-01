package com.knowledge.horus.controls;

import com.knowledge.horus.models.Bandeja;
import java.util.List;

public class BandejaDAO extends GenericDAO<Bandeja> {

    public BandejaDAO() {
        super(Bandeja.class);
    }
    
    public List<Bandeja> findByLogin(String Login) {
        String jpql = "from Usuario p where p.login like ?1";
        return find(jpql, Login);
    }
    
    
    
    /*Conexão conex = new Conexão();
    
    public void Criar(Bandeja bandeja){
        conex.conectar();
        String band = ("bd"+bandeja.getCódBd());
        try {
            PreparedStatement pst = conex.con.prepareStatement("CREATE TABLE "+band+" (código CHAR(15) PRIMARY KEY,"
                    + " descrição CHAR(50))");
            pst.execute();
            JOptionPane.showMessageDialog(null, "Nova bandeja criada!");
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "A bandeja já existe no sistema.\nPara editá-la, clique no botão Editar,"
                    + "\nou, para montar uma nova bandeja, clique no botão Limpar.");
            bandeja.setStatus(1);
        }
        conex.desconectar();
    }
    
    public void Salvar(BandejaMod bandeja){
        conex.conectar();
        String band = ("bd"+bandeja.getCódBd());
        try {
            PreparedStatement pst = conex.con.prepareStatement("INSERT INTO "+band+" (código,"
                    + " descrição) VALUES (?, ?)");
            pst.setString(1, bandeja.getCódInst());
            pst.setString(2, bandeja.getDesInst());
            pst.execute();
            //JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir dados:\n"+ex.getMessage());
        }    
        conex.desconectar();
    }
    
    public BandejaMod Buscar(BandejaMod bandeja){
        conex.conectar();
        String table = ("bd"+bandeja.getCódBd());
        conex.execSql("SELECT * FROM "+table+"");
        try {
            conex.rs.last();
            bandeja.setLin(conex.rs.getRow());
            if ((bandeja.getPos()) != 0) {
                conex.rs.absolute(bandeja.getPos());
                bandeja.setCódInst(conex.rs.getString("código"));
                bandeja.setDesInst(conex.rs.getString("descrição"));
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Bandeja não encontrada!\n");
        }
        conex.desconectar();
        return bandeja;
    }

    public void Excluir(BandejaMod bandeja){
        conex.conectar();
        String band = ("bd"+bandeja.getCódBd());
        try {
            PreparedStatement pst = conex.con.prepareStatement("DELETE FROM "+band+" WHERE CódBd=?");
            pst.setString(1, bandeja.getCódBd());
            pst.execute();
            //JOptionPane.showMessageDialog(null, "Ítem excluído com sucesso!");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir Ítem:\n"+ex.getMessage());
        }    
        conex.desconectar();
    }
    
    public void Limpar(BandejaMod bandeja){
        conex.conectar();
        String band = ("bd"+bandeja.getCódBd());
        try {
            PreparedStatement pst = conex.con.prepareStatement("DELETE FROM "+band+"");
            pst.execute();
            //JOptionPane.showMessageDialog(null, "Bandeja esvaziada com sucesso!");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao esvaziar bandeja:\n"+ex.getMessage());
        }    
        conex.desconectar();
    }

    public void ExcluirBandeja(BandejaMod bandeja) {
        conex.conectar();
        String band = ("bd"+bandeja.getCódBd());
        try {
            PreparedStatement pst = conex.con.prepareStatement("DROP TABLE "+band+"");
            pst.execute();
            JOptionPane.showMessageDialog(null, "Bandeja excluída com sucesso!");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir bandeja:\n"+ex.getMessage());
        }    
        conex.desconectar();
    }
    
    public void TestaBandeja(BandejaMod bandeja){
        conex.conectar();
        String band = ("bd"+bandeja.getCódBd());
        PreparedStatement pst;
        try {
            pst = conex.con.prepareStatement("CREATE TABLE "+band+" (código CHAR(1) PRIMARY KEY)");
            pst.execute();
            pst = conex.con.prepareStatement("DROP TABLE "+band+"");
            pst.execute();
            bandeja.setStatus(0);
            //JOptionPane.showMessageDialog(null, "Esta bandeja não existe no banco");
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Esta bandeja já foi cadastrada.\nPara editá-la, clique no botão Editar,"
            //        + "\nou, para montar uma nova bandeja, clique no botão Limpar.");
            bandeja.setStatus(1);
        }
        conex.desconectar();
    }*/
}
