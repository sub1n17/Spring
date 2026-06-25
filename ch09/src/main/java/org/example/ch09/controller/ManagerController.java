package org.example.ch09.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ManagerController {
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    @GetMapping("/manager/index")
    public String index() {

        return "/manager/index";
    }
}
