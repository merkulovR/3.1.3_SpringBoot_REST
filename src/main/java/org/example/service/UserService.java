package org.example.service;

import org.example.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService extends UserDetailsService {
    public List<User> getAllUsers();
    public void addUser(User user);
    public User getUser(long id);
    public void updateUser(User user);
    @Override
    UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;
    public void deleteUser(long id);
    void addInitUsers();
    void addInitUser(User user);
}
