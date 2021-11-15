package org.example.service;

import org.example.model.Role;
import org.example.model.User;
import org.example.repositories.RoleRepository;
import org.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userDetailsServiceImpl")
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User getUser(long id) {
        return userRepository.getById(id);
    }

    @Override
    @Transactional
    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        if (!user.getPassword().equals(getUser(user.getId()).getPassword())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }

        userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return userRepository.getByUsername(userName);
    }

    /**
     * Метод для создания тестовых юзеров
     * Создаем в @PostConstructor'e LoginController'a
     */

    @Override
    @Transactional
    public void addInitUsers() {
        User admin = new User("Admin", "Adminov", "admin@mail.com", "admin", "pass");
        User user = new User("User", "Userov", "user@mail.com", "user", "pass");
        Role adminRole = new Role("ROLE_ADMIN");
        Role userRole = new Role("ROLE_USER");

        addUser(admin);
        addUser(user);
        roleRepository.save(adminRole);
        roleRepository.save(userRole);

        admin.addRole(adminRole);
        admin.addRole(userRole);
        user.addRole(userRole);

        adminRole.addUser(admin);
        userRole.addUser(admin);
        userRole.addUser(user);
    }
}
