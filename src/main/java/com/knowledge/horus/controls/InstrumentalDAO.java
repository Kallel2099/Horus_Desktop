package com.knowledge.horus.controls;

/*import Controle.Conexão;
import Modelos.Cme.InstruMod;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;*/

import com.knowledge.horus.models.Instrumental;
import java.util.List;

public class InstrumentalDAO extends GenericDAO<Instrumental> {
    
    public InstrumentalDAO() {
        super(Instrumental.class);
    }
    
    public List<Instrumental> findByLogin(String Login) {
        String jpql = "from Usuario p where p.login like ?1";
        return find(jpql, Login);
    }
    
    
    
    /*Conexão conex = new Conexão();
    
    public void Salvar(InstruMod inst){
        conex.conectar();
        try {
            PreparedStatement pst = conex.con.prepareStatement("INSERT INTO arsenal (item, tipo, especialidade,"
                    + " descrição, formato, tamanho, unidade1, larguraa, unidade2, largurab, unidade3, comp,"
                    + " unidade4, diametro, unidade5, ponta, orientação, angulo, num, serrilha, widia, dente,"
                    + " trava, furo, outro1, outro2, outro3, imagem, cód, setor, fantasia) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,"
                    + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pst.setString(1, inst.getItem());
            pst.setString(2, inst.getTipo());
            pst.setString(3, inst.getEspecialidade());
            pst.setString(4, inst.getDescrição());
            pst.setString(5, inst.getFormato());
            pst.setDouble(6, inst.getTamanho());
            pst.setString(7, inst.getUnidade1());
            pst.setDouble(8, inst.getLarguraa());
            pst.setString(9, inst.getUnidade2());
            pst.setDouble(10, inst.getLargurab());
            pst.setString(11, inst.getUnidade3());
            pst.setDouble(12, inst.getComp());
            pst.setString(13, inst.getUnidade4());
            pst.setDouble(14, inst.getDiametro());
            pst.setString(15, inst.getUnidade5());
            pst.setString(16, inst.getPonta());
            pst.setString(17, inst.getOrientação());
            pst.setString(18, inst.getAngulo());
            pst.setString(19, inst.getNum());
            pst.setString(20, inst.getSerrilha());
            pst.setString(21, inst.getWidia());
            pst.setString(22, inst.getDente());
            pst.setString(23, inst.getTrava());
            pst.setString(24, inst.getFuro());
            pst.setString(25, inst.getOutro1());
            pst.setString(26, inst.getOutro2());
            pst.setString(27, inst.getOutro3());
            pst.setBytes(28, inst.getImagem());
            pst.setString(29, inst.getCód());
            pst.setString(30, inst.getSetor());
            pst.setString(31, inst.getFantasia());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir dados:\n"+ex.getMessage());
        }    
        conex.desconectar();
    }
    
public InstruMod Buscar(InstruMod inst){
        conex.conectar();
        conex.execSql("SELECT * FROM arsenal WHERE cód = "+"'"+((String) inst.getBusca().intern().trim())+"'");
        try {
            conex.rs.next();
            inst.setCód(conex.rs.getString("cód"));
            inst.setItem(conex.rs.getString("item"));
            inst.setTipo(conex.rs.getString("tipo"));
            inst.setEspecialidade(conex.rs.getString("especialidade"));
            inst.setSetor(conex.rs.getString("setor"));
            inst.setDescrição(conex.rs.getString("descrição"));
            inst.setFormato(conex.rs.getString("formato"));
            inst.setTamanho(conex.rs.getDouble("tamanho"));
            inst.setUnidade1(conex.rs.getString("unidade1"));
            inst.setLarguraa(conex.rs.getDouble("larguraa"));
            inst.setUnidade2(conex.rs.getString("unidade2"));
            inst.setLargurab(conex.rs.getDouble("largurab"));
            inst.setUnidade3(conex.rs.getString("unidade3"));
            inst.setComp(conex.rs.getDouble("comp"));
            inst.setUnidade4(conex.rs.getString("unidade4"));
            inst.setDiametro(conex.rs.getDouble("diametro"));
            inst.setUnidade5(conex.rs.getString("unidade5"));
            inst.setPonta(conex.rs.getString("ponta"));
            inst.setOrientação(conex.rs.getString("orientação"));
            inst.setAngulo(conex.rs.getString("angulo"));
            inst.setNum(conex.rs.getString("num"));
            inst.setSerrilha(conex.rs.getString("serrilha"));
            inst.setWidia(conex.rs.getString("widia"));
            inst.setDente(conex.rs.getString("dente"));
            inst.setTrava(conex.rs.getString("trava"));
            inst.setFuro(conex.rs.getString("furo"));
            inst.setOutro1(conex.rs.getString("outro1"));
            inst.setOutro2(conex.rs.getString("outro2"));
            inst.setOutro3(conex.rs.getString("outro3"));
            inst.setImagem(conex.rs.getBytes("imagem"));
            inst.setFantasia(conex.rs.getString("fantasia"));
            inst.setOk(1);
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ítem não encontrado! \n");
            inst.setOk(0);
            inst.setCód("");
        }
        conex.desconectar();
        return inst;
    }

    public void Editar(InstruMod inst){
        conex.conectar();
        try {
            PreparedStatement pst = conex.con.prepareStatement("UPDATE arsenal SET item=?, tipo=?,"
                    + " especialidade=?, descrição=?, formato=?, tamanho=?, unidade1=?, larguraa=?, unidade2=?,"
                    + " largurab=?, unidade3=?, comp=?, unidade4=?, diametro=?, unidade5=?, ponta=?, orientação=?,"
                    + " angulo=?, num=?, serrilha=?, widia=?, dente=?, trava=?, furo=?, outro1=?, outro2=?, outro3=?,"
                    + " imagem=?, setor=?, fantasia=? WHERE cód=?");
            pst.setString(1, inst.getItem());
            pst.setString(2, inst.getTipo());
            pst.setString(3, inst.getEspecialidade());
            pst.setString(4, inst.getDescrição());
            pst.setString(5, inst.getFormato());
            pst.setDouble(6, inst.getTamanho());
            pst.setString(7, inst.getUnidade1());
            pst.setDouble(8, inst.getLarguraa());
            pst.setString(9, inst.getUnidade2());
            pst.setDouble(10, inst.getLargurab());
            pst.setString(11, inst.getUnidade3());
            pst.setDouble(12, inst.getComp());
            pst.setString(13, inst.getUnidade4());
            pst.setDouble(14, inst.getDiametro());
            pst.setString(15, inst.getUnidade5());
            pst.setString(16, inst.getPonta());
            pst.setString(17, inst.getOrientação());
            pst.setString(18, inst.getAngulo());
            pst.setString(19, inst.getNum());
            pst.setString(20, inst.getSerrilha());
            pst.setString(21, inst.getWidia());
            pst.setString(22, inst.getDente());
            pst.setString(23, inst.getTrava());
            pst.setString(24, inst.getFuro());
            pst.setString(25, inst.getOutro1());
            pst.setString(26, inst.getOutro2());
            pst.setString(27, inst.getOutro3());
            pst.setBytes(28, inst.getImagem());
            pst.setString(29, inst.getSetor());
            pst.setString(30, inst.getCód());
            pst.setString(31, inst.getFantasia());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados substituidos com sucesso!");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao substituir dados:\n"+ex.getMessage());
        }    
        conex.desconectar();
    }
    
    public void Excluir(InstruMod inst){
        conex.conectar();
        try {
            PreparedStatement pst = conex.con.prepareStatement("DELETE FROM arsenal WHERE cód=?");
            pst.setString(1, inst.getCód());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados excluídos com sucesso!");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir dados:\n"+ex.getMessage());
        }    
        conex.desconectar();
    }*/
}
