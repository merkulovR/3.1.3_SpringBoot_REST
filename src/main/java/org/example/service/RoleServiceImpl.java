package org.example.service;

import org.example.model.Role;
import org.example.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    @Transactional
    public void saveRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    @Transactional
    public Role getRole(Long id) {
        return roleRepository.getById(id);
    }

    @Override
    @Transactional
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Role getByRoleName(String name) {
        return roleRepository.getByRoleName(name);
    }
}
