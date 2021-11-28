package org.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
    private long id;
    private String name;
    private String lastname;
    private String email;
    private String username;
    private long[] roles;
    private String password;

    public UserDto() {
    }

    public UserDto(long id, String name, String lastname, String email, String username, long[] roles, String password) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.username = username;
        this.roles = roles;
        this.password = password;
    }

    public User toUser() {
        return new User(
                this.name,
                this.lastname,
                this.email,
                this.username,
                this.password
        );
    }

    public static UserDto fromUser(User user) {
        UserDto userDTO = new UserDto();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setLastname(user.getLastname());
        userDTO.setEmail(user.getEmail());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setRoles(user.getRoles().stream().mapToLong(Role::getId).toArray());
        return userDTO;
    }

//    public String getSortedDtoRolesNames() {
//        StringBuilder sortedRolesNames = new StringBuilder();
//        TreeSet<String> roleNames = new TreeSet<>();
//
//        for (long role : roles) {
//            if (role == 1L) {
//                roleNames.add("ADMIN");
//            }
//            if (role == 2L) {
//                roleNames.add("USER");
//            }
//        }
//
//        roleNames.forEach(n -> sortedRolesNames.append(n).append(' '));
//
//        return sortedRolesNames.toString();
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long[] getRoles() {
        return roles;
    }

    public void setRoles(long[] roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
