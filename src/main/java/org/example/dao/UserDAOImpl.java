package org.example.dao;

import org.example.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager
                .createQuery("FROM User", User.class)
                .getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUser(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUser(long id) {
       entityManager.remove(getUser(id));
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) {
        return entityManager
                .createQuery("SELECT u from User u WHERE u.username = :username", User.class)
                .setParameter("username", userName)
                .getSingleResult();
    }

    @Override
    public void addInitUser(User user) {
        entityManager.persist(user);
    }
}
