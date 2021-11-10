package org.example.service;

import org.example.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {
    public Set<Role> getAllRoles();

    public void saveRole(Role role);

    public Role getRole(String name);

    public void deleteRole(String name);
}
