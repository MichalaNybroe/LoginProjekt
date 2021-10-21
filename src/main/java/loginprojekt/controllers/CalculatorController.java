package loginprojekt.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public class CalculatorController {
    @GetMapping("/calculator")
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


    @PostMapping("/calculating")
    public ModelAndView calculating() {
        return new ModelAndView("calculator");
    }
}
