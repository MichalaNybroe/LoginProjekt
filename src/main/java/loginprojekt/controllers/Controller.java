package loginprojekt.controllers;

import loginprojekt.repositories.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@org.springframework.stereotype.Controller
public class Controller {

    //VI SKAL HAVE ALT VORES LOGIK UD HERFRA OG HAVE LAVET EN NY SERVICE KLASSE TIL DET!!!

    UserService userService = new UserService();

    @GetMapping("/")
    public ModelAndView home(HttpSession session) {
        if (session.getAttribute("username") != null) {
            return new ModelAndView(new RedirectView("/profilePage"));
        } else {
            return new ModelAndView("index");
        }
    }

    @GetMapping("/createUser")
    public String create() {
        return "createUser";
    }

    @PostMapping("/createUser")
    public RedirectView createdUser(@RequestParam String name, @RequestParam String password) {
        userService.createUser(name, password);
        return new RedirectView("/");
    }

    @PostMapping("/logIn")
    public RedirectView logIn(HttpSession session, @RequestParam String name, @RequestParam String password) {
        boolean exists = userService.isValidUser(
                "SELECT users.user_name FROM users WHERE user_name = ? && user_password = ?",
                name,
                password
        );
        if (exists) {
            // Create session
            session.setAttribute("username", name);
            return new RedirectView("profilePage");
        }
        return new RedirectView("fail"); //Her skal smides en exception?
    }

    @PostMapping("/logOut")
    public RedirectView logOut(HttpSession session) {
        session.invalidate();
        return new RedirectView("/");
    }
}
