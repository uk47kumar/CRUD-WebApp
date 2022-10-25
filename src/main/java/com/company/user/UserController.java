package com.company.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String getAllUser(Model model){
        List<User> allUser = userService.getAllUser();
        model.addAttribute("allUser", allUser);
        return "users";
    }

    @GetMapping("/users/new")
    public String showAddForm(Model model){
        model.addAttribute("user", new User());
        return "user_form";
    }
}
