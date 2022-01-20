package ru.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calc")
public class CalculatorController {

    @GetMapping("calc")
    public String calc(@RequestParam(value = "a") int a , @RequestParam(value = "b") int b,
                    @RequestParam(value = "action") String action, Model model) {
        double result;
        switch (action) {
            case "multiplication":
                 result= a*b;
                break;
            case "addition":
                 result = a+b;
                break;
            case "subtraction":
                 result = a-b;
            break;
            case "division":
                 result = a/(double)b;
            break;

            default:
                result = 0;
                break;
        }
        model.addAttribute("action" , result);
        return "first/calc";


    }
}
