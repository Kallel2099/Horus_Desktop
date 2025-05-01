package com.knowledge.horus.controls;

import com.knowledge.horus.models.Usuario;
import java.util.List;

public class UsuariosDAO extends GenericDAO<Usuario> {

    public UsuariosDAO() {
        super(Usuario.class);
    }
    
    public List<Usuario> findByLogin(String Login) {
        String jpql = "from Usuario p where p.login like ?1";
        return find(jpql, Login);
    }

    /*public List<Usuarios> findByAgeInBetween(int min, int max) {
        String jpql = "from Person p where p.age between ?1 and ?2";
        return find(jpql, min, max);
    }

    public Usuarios findByFullName(String firstName, String lastName) {
        String jpql = "from Person p where p.firstName like ?1 and p.lastName like ?2";
        return findOne(jpql, firstName, lastName);
    }

    public Usuarios findByCPF(String cpf) {
        String jpql = "select p from Person p, Document d where d.cpf like ?1 " +
                "and p.document.id = d.id";
        return findOne(jpql, cpf);
    }
    */
}