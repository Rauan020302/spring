package ru.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/* required = false в отсутствии параметров возвращает null*/
@Controller
@RequestMapping("/page")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name",required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname) {
        System.out.println(name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodBye")
    public String goodByePage() {
        return "first/goodBye";
    }
}
