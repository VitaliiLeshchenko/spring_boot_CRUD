package vitalii.leshchenko.spring_boot_CRUD.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}
