package com.knowledge.horus.controls;

import com.knowledge.horus.util.JPAUtil;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

public abstract class GenericDAO<T extends Serializable> {

    private Class<T> aClass;

    protected GenericDAO(Class<T> aClass) {
        this.aClass = aClass;
    }

    // Cria o gerenciador de entidades em instância unica e retorna uma entidade
    protected EntityManager getEntityManager() {
        return JPAUtil.getInstance().getEntityManager();
    }
    
    // Salvar
    public void save(T entity) {
        EntityManager manager = getEntityManager();// Instancia o Entity Manager
        manager.getTransaction().begin();// Inicia a transação com o banco
        manager.persist(entity);// Método salvar da JPA
        manager.getTransaction().commit();// Finaliza a transação com o banco
        manager.close();// Encerra a conexão com o banco
    }
    
    // Atualizar
    public void update(T entity) {
        EntityManager manager = getEntityManager();
        manager.getTransaction().begin();
        manager.merge(entity);// Método atualizar da JPA
        manager.getTransaction().commit();
        manager.close();
    }

    // Deletar por ID
    public void delete(Long id) {
        EntityManager manager = getEntityManager();
        manager.getTransaction().begin();
        manager.remove(manager.getReference(aClass, id));// Método deletar da JPA
        manager.getTransaction().commit();
        manager.close();
    }

    // Deletar por 
    public void delete(T entity) {
        EntityManager manager = getEntityManager();
        manager.getTransaction().begin();
        manager.remove(manager.merge(entity));
        manager.getTransaction().commit();
        manager.close();
    }
    
    // Buscar por ID
    public T findById(Long id) {
        EntityManager manager = getEntityManager();
        manager.getTransaction().begin();
        T entity = (T) manager.find(aClass, id);// Método buscar da JPA
        manager.getTransaction().commit();
        manager.close();
        return entity;
    }
    // Buscar todos os dados de uma determinada classe e retorna uma lista
    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        EntityManager manager = getEntityManager();
        manager.getTransaction().begin();
        Query query = manager.createQuery("from " + aClass.getSimpleName());// Cria uma consulta no banco buscando a classe pelo nome
        List<T> entities = query.getResultList();
        manager.getTransaction().commit();
        manager.close();
        return entities;
    }
    
    // Busca todas as entidades à partir de uma lista de parâmetros
    @SuppressWarnings("unchecked")
    public List<T> find(String jpql, Object... params) {
        EntityManager manager = getEntityManager();
        manager.getTransaction().begin();
        Query query = manager.createQuery(jpql);
        for (int i = 0; i < params.length; i++) {
            query.setParameter(i+1, params[i]);
        }
        List<T> entities = query.getResultList();
        manager.getTransaction().commit();
        manager.close();
        return entities;
    }
    
    // Busca uma única entidade à partir de uma lista de parâmetros
    @SuppressWarnings("unchecked")
    public T findOne(String jpql, Object... params) {
        EntityManager manager = getEntityManager();
        manager.getTransaction().begin();
        Query query = manager.createQuery(jpql);
        for (int i = 0; i < params.length; i++) {
            query.setParameter(i+1, params[i]);
        }
        T entity = (T) query.getSingleResult();
        manager.getTransaction().commit();
        manager.close();
        return entity;
    }

    // Retorna o número total de linhas de determinada tabela
    public long count() {
        EntityManager manager = getEntityManager();
        manager.getTransaction().begin();
        Query query = manager.createQuery("select count(c) from "+
                aClass.getSimpleName() + " c");
        long count = (Long) query.getSingleResult();
        manager.getTransaction().commit();
        manager.close();
        return count;
    }
}
