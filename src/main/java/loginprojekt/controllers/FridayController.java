package loginprojekt.controllers;

import loginprojekt.services.FridayService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
public class FridayController {


    //skal lige finde ud af at når siden kører skal den udregne datoen og sende det til html'en - men skal det være som objekt??
    @GetMapping("/friday")
    public ModelAndView friday(HttpSession session, Model model) {
        if (session.getAttribute("username") != null) {
            model.addAttribute("day", FridayService.IsItFriday());
            return new ModelAndView("friday");
        } else {
            return new ModelAndView(new RedirectView("/"));
        }
    }
}
