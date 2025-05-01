package com.knowledge.horus.controls;

import com.knowledge.horus.models.Banco;
import com.knowledge.horus.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;

public class BancoDAO extends GenericDAO<Banco> {
    
    public BancoDAO() {
        super(Banco.class);
    }
    
    public List<Banco> findByDetalhes(String inst) {
        EntityManager manager = JPAUtil.getInstance().getEntityManager();
        String JPQL = "SELECT DISTINCT b FROM Banco b WHERE b.item LIKE :inst"
                + " OR b.tipo LIKE :inst OR b.especialidade LIKE :inst"
                + " OR b.descricao LIKE :inst ORDER BY b.item";
        return manager.createQuery(JPQL, Banco.class)
                .setParameter("inst", "%"+inst+"%")
                .getResultList();
    }
}
