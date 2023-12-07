package com.example.demo1.Controllers;

import com.example.demo1.Models.Personal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class regController {

    @Autowired
    private com.example.demo1.repos.userRepo userRepository;
    @GetMapping("/main")
    public String getmain(Model model) {
        return "main";
    }


    @GetMapping("/registration")
    private String RegView()
    {
        return "regis";
    }
    @PostMapping("/registration")
    private String Reg(Personal user, Model model)
    {
        Personal user_from_db = userRepository.findByUsername(user.getUsername());
        if (user_from_db != null)
        {
            model.addAttribute("message", "Пользователь с таким логином уже существует");
            return "regis";
        }
        user.setRole("User");
        userRepository.save(user);
        return "redirect:/login";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
