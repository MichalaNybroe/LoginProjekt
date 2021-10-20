package loginprojekt.controllers;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

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
}
