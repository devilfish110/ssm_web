package org.study.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.study.entities.Dlb;
import org.study.entities.Result;
import org.study.service.DlbService;

@Controller("loginController")
@RequestMapping({"/user"})
public class LoginController {
    @Autowired
    private DlbService loginService;

    public LoginController() {
    }

    @GetMapping({"/login"})
    @ResponseBody
    public Result login(@Valid Dlb user) {
        return loginService.login(user);
    }

    @GetMapping("/logout")
    public String logout() {
        return "login.html";
    }
}