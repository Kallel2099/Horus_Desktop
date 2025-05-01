package com.knowledge.horus.controls;

import com.knowledge.horus.models.Arsenal;
import com.knowledge.horus.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;

public class ArsenalDAO extends GenericDAO<Arsenal> {
    
    public ArsenalDAO() {
        super(Arsenal.class);
    }
    
    public List<Arsenal> findByDetalhes(String inst) {
        EntityManager manager = JPAUtil.getInstance().getEntityManager();
        String JPQL = "SELECT DISTINCT b FROM Arsenal b WHERE b.item LIKE :inst"
                + " OR b.tipo LIKE :inst OR b.especialidade LIKE :inst"
                + " OR b.descricao LIKE :inst ORDER BY b.item";
        return manager.createQuery(JPQL, Arsenal.class)
                .setParameter("inst", "%"+inst+"%")
                .getResultList();
    }
    
    public List<Arsenal> findByCod(Long inst) {
        String jpql = "from Arsenal a where a.cod = ?1";
        return find(jpql, inst);
    }
}
