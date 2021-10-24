package loginprojekt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
public class CalculatorController {
    @PostMapping("/calculating")
    public ModelAndView calculator(@RequestParam int first, @RequestParam int second, @RequestParam String operator, Model model) {
        int result;
        if (operator.equals("+")) {
            result = first + second;
        } else if (operator.equals("-")) {
            result = first - second;
        } else if (operator.equals("/")) {
            result = first / second;
        } else {
            result = first * second;
        }
        //overfør int til html side
        model.addAttribute("result", first + operator + second + "=" + result);
        return new ModelAndView("calculator");
    }


    @GetMapping("/calculator")
    public ModelAndView calculating(HttpSession session) {
        if (session.getAttribute("username") != null) {
            return new ModelAndView("calculator");
        } else {
            return new ModelAndView(new RedirectView("/"));
        }
    }
}
