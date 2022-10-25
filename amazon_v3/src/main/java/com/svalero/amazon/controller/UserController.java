package com.svalero.amazon.controller;

import com.svalero.amazon.domain.User;
import com.svalero.amazon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add-user")
    public String addUser(@ModelAttribute User user, Model model) {
        // Dar de alta el usuario
        userService.addUser(user);
        model.addAttribute("message", "Usuario registrado correctamente");
        return "register-user";
    }

    @GetMapping("/register-user")
    public String registerUser(Model model) {
        model.addAttribute("user", new User());
        return "register-user";
    }

    @GetMapping("/user/{userId}")
    public String getUserProfile(Model model, @PathVariable long userId) {
        // TODO Buscar el usuario en la base de datos por el id
        // TODO Cuidado porque solamente puedo yo ver mi perfil (falta seguridad)
        return "profile";
    }

    @GetMapping("/user/{userId}/orders")
    public String getUserOrders(Model model, @PathVariable long userId) {
        return "user-orders";
    }
}
