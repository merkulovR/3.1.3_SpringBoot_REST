package org.example.service;

import org.example.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> getAllUsers();
    void addUser(User user);
    User getUser(long id);
    boolean updateUser(User user);
    @Override
    UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;
    boolean deleteUser(long id);
    void addInitUsers();
}
