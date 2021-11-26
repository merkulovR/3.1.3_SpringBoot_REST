package org.example.controllers;

import org.example.model.User;
import org.example.service.RoleService;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        final List<User> users = userService.getAllUsers();

        return users != null && !users.isEmpty()
                ? new ResponseEntity<>(users, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") int id) {
        final User user = userService.getUser(id);

        return user != null
                ? new ResponseEntity<>(user, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/new")
    public ResponseEntity<User> addNewUser(@RequestBody User user) {
//        user.setRoles(roles.stream().map(roleService::getRole).collect(Collectors.toSet()));
        userService.addUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") int id, @RequestBody User user) {
//        user.setRoles(roles.stream().map(roleService::getRole).collect(Collectors.toSet()));
        final boolean result = userService.updateUser(user);

        return result
                ? new ResponseEntity<>(user, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        final boolean result = userService.deleteUser(id);

        return result
                ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
//@GetMapping
//    public String printUsers(Model model) {
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        model.addAttribute("user", user);
//        model.addAttribute("newUser", new User());
//        model.addAttribute("users", userService.getAllUsers());
//        return "/admin";
//    }
//
//    @PostMapping("/new")
//    public String addNewUser(@ModelAttribute("newUser") User user, @RequestParam("roles") ArrayList<Long> roles) {
//        user.setRoles(roles.stream().map(roleService::getRole).collect(Collectors.toSet()));
//        userService.addUser(user);
//        return "redirect:/admin";
//    }
//
//    @PutMapping("/update/{id}")
//    public String updateUser(@ModelAttribute("user") User user, @RequestParam("roles") List<Long> roles) {
//        user.setRoles(roles.stream().map(roleService::getRole).collect(Collectors.toSet()));
//        userService.updateUser(user);
//
//        return "redirect:/admin";
//    }
//
//    @DeleteMapping(value = "/delete/{id}")
//    public String delete(@PathVariable("id") int id) {
//        userService.deleteUser(id);
//
//        return "redirect:/admin";
//    }
