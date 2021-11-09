package org.example.dao;

import org.example.model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.Set;

@Repository
public class RoleDAOImpl implements RoleDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Set<Role> getAllRoles() {
        return new HashSet<>(entityManager
                .createQuery("FROM Role", Role.class)
                .getResultList());
    }

    @Override
    public void saveRole(Role role) {
        if (role.getId() == 0) {
            entityManager.persist(role);
        }

        entityManager.merge(role);
    }

    @Override
    public Role getRole(String name) {

        return entityManager
                .createQuery("SELECT r FROM Role r WHERE r.roleName = :roleName", Role.class)
                .setParameter("roleName", name)
                .getSingleResult();
    }

    @Override
    public void deleteRole(String name) {
        entityManager
                .createQuery("DELETE FROM Role r WHERE r.roleName = :roleName", Role.class)
                .setParameter("roleName", name)
                .executeUpdate();
    }
}
