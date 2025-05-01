package com.knowledge.horus.controls;

import com.knowledge.horus.models.Movimentacao;
import com.knowledge.horus.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;

public class MovimentaDAO extends GenericDAO<Movimentacao> {
    
    public MovimentaDAO (){
        super(Movimentacao.class);
    }
    
    public List<Movimentacao> findOcorre() {
        EntityManager manager = JPAUtil.getInstance().getEntityManager();
        //String JPQL = "SELECT DISTINCT b FROM Movimentacao b WHERE b.codigo LIKE '8%' ORDER BY b.codigo";
        String JPQL = "SELECT DISTINCT b FROM Movimentacao b WHERE b.codigo LIKE '8%'ORDER BY b.id";
        return manager.createQuery(JPQL, Movimentacao.class)
                //.setParameter("mov", "'8%'")
                .getResultList();
    }
    
    public List<Movimentacao> findByCod(Long mov) {
        String jpql = "from Movimentacao a where a.codigo = ?1";
        return find(jpql, mov);
    }
    
    public List<Movimentacao> findByDetalhes(String movimenta) {
        EntityManager manager = JPAUtil.getInstance().getEntityManager();
        String JPQL = "SELECT DISTINCT b FROM Movimentacao b WHERE b.descricao LIKE :mov"
                + " OR b.fornecedor LIKE :mov OR b.esterilizador LIKE :mov"
                + " OR b.cirurgia LIKE :mov OR b.paciente LIKE :mov"
                + " OR b.procedimento LIKE :mov OR b.numlote LIKE :mov"
                + " OR b.teste LIKE :mov OR b.processamento LIKE :mov"
                + " OR b.validade LIKE :mov OR b.operador LIKE :mov"
                + " OR b.data LIKE :mov OR b.codigo LIKE :mov ORDER BY b.data";
        return manager.createQuery(JPQL, Movimentacao.class)
                .setParameter("mov", "%"+movimenta+"%")
                .getResultList();
    }
}
/*
         moviment.setFornecedor((String) jTable.getValueAt(i, 2));
            moviment.setEsterilizador((String) jTable.getValueAt(i, 3));
            moviment.setCirurgia((String) jTable.getValueAt(i, 4));
            moviment.setPaciente((String) jTable.getValueAt(i, 5));
            moviment.setProcedimento((String) jTable.getValueAt(i, 6));
            moviment.setNumlote((String) jTable.getValueAt(i, 7));
            moviment.setTeste((String) jTable.getValueAt(i, 8));
            moviment.setProcessamento((String) jTable.getValueAt(i, 9));
            moviment.setValidade((String) jTable.getValueAt(i, 10));
            moviment.setOperador((String) jTable.getValueAt(i, 11));
            moviment.setData((String) jTable.getValueAt(i, 12));
            moviment.setCodigo((Long) jTable.getValueAt(i, 13));
            moviment.setAnexo((byte[]) jTable.getValueAt(i, 14));
        */