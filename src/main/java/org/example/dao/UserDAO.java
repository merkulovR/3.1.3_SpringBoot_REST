package org.example.dao;

import org.example.model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserDAO {
    public List<User> getAllUsers();

    public void addUser(User user);

    public User getUser(long id);

    public void deleteUser(long id);

    public void updateUser(User user);

    public UserDetails loadUserByUsername(String userName);
}
