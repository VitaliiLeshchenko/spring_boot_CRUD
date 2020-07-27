package vitalii.leshchenko.spring_boot_CRUD.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import vitalii.leshchenko.spring_boot_CRUD.model.User;
import vitalii.leshchenko.spring_boot_CRUD.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String findAll(Model model) {
        List<User> userList = userService.getAll();
        model.addAllAttributes(Map.of("users", userList));
        return "user-list";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user) {
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("/user-update/{id}")
    public String updateForm(@PathVariable("id") long id, Model model) {
        User user = userService.findById(id);
        model.addAllAttributes(Map.of("user", user));
        return "user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user) {
        userService.save(user);
        return "redirect:/users";
    }
}
