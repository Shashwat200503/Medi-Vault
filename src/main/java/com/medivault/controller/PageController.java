package com.medivault.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/view/documents")
    public String documents() { return "documents"; }

    @GetMapping("/view/users")
    public String users() { return "users"; }

    @GetMapping("/view/prescriptions")
    public String prescriptions() { return "prescriptions"; }

    @GetMapping("/view/labreports")
    public String labreports() { return "labreports"; }

    @GetMapping("/view/dashboard")
    public String dashboard() { return "dashboard"; }

    @GetMapping("/view/login")
    public String login() { return "login"; }

    @GetMapping("/view/register")
    public String register() { return "register"; }

    @GetMapping("/")
    public String home() { return "index"; }
}
