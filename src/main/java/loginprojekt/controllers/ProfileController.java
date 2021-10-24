package loginprojekt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
public class ProfileController {

    @GetMapping("/profilePage")
    public ModelAndView profile(HttpSession session) {
        if (session.getAttribute("username") != null) {
            return new ModelAndView("profilePage");
        } else {
            return new ModelAndView(new RedirectView("/"));
        }
    }
}
