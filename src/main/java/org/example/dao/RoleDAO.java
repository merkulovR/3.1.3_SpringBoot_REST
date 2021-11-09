package org.example.dao;

import org.example.model.Role;
import org.example.model.User;

import java.util.List;
import java.util.Set;

public interface RoleDAO {
    public Set<Role> getAllRoles();

    public void saveRole(Role role);

    public Role getRole(String name);

    public void deleteRole(String name);

}
