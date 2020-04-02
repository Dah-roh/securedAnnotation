package com.sample.securedtesting;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @Secured({"ROLE_USER", "ROLE_MODERATOR", "ROLE_ADMIN"})
    @GetMapping("/user")
    public String userAccess() {
        return "User Content.";
    }

    @Secured("ROLE_MODERATOR")
    @GetMapping("/mod")
    public String moderatorAccess() {
        return "Moderator Board.";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/admin")
    public String adminAccess() {
        return "Admin Board.";
    }
}
