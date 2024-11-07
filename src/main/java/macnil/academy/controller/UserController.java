package macnil.academy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import macnil.academy.model.User;
import macnil.academy.service.UserService;

@Controller
@RequestMapping("/users")

public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public String usersView(Model viewModel) {
        viewModel.addAttribute("title", "Users");
        viewModel.addAttribute("users", userService.readAll());
        return "users";
    }

    @GetMapping("create")
    public String createUserView(Model viewModel) {
        viewModel.addAttribute("title", "Create Users");
        viewModel.addAttribute("user", new User());
        return "createUser";
    }

  

    
    }








    

