package loginprojekt.controllers;

import loginprojekt.services.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {
    UserService userService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/profilePage")
    public String profile() {
        return "profilePage";
    }

    @GetMapping("/friday")
    public String day() {
        return "friday";
    }

    @GetMapping("/createUser")
    public String create() {
        return "createUser";
    }

    @PostMapping("/")
    public String createdUser(@RequestParam String name, @RequestParam String password, Model model) {
        userService.createUser(name, password);
        model.addAttribute("user", userService.getUser());
        return "index";
    }

    @PostMapping("/profilePage")
    public String logIn(@RequestParam String name, @RequestParam String password, Model model) {
        userService.checkUser(
                "SELECT user.user_name FROM users WHERE user_name = " + name + " && user_password = " + password
        );
        model.addAttribute("user", )
    }
}
