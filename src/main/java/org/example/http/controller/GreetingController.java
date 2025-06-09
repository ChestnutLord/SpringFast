package org.example.http.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.example.database.entity.Role;
import org.example.dto.UserReadDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/api/v1")
public class GreetingController {

    @ModelAttribute("roles")
    public List<Role> roles(){
        return Arrays.asList(Role.values());
    }

    @GetMapping("/hello")
    public ModelAndView hello(ModelAndView modelAndView,
                              HttpServletRequest request,
                              @ModelAttribute UserReadDto userReadDto) {
        modelAndView.setViewName("greeting/hello");
        // modelAndView.addObject("user", new UserReadDto(1L, "Ivan"));

        return modelAndView;
    }

    @GetMapping("/bye")
    public String bye(Model model) {
        return "greeting/bye";
    }

    @GetMapping("/ilikeit")
    public ModelAndView someNewModelAndView(ModelAndView modelAndView) {
        modelAndView.setViewName("greeting/ilikeit");
        return modelAndView;
    }

    @GetMapping("/hello2/{id}")
    public ModelAndView hello2(ModelAndView modelAndView,
                               HttpServletRequest request,
                               @RequestParam Integer age,
                               @RequestHeader String accept,
                               @CookieValue("JSESSIONID") String jsessionId,
                               @PathVariable("id") Integer id) {
        String ageParamValue = request.getParameter("age");
        String acceptHeader = request.getHeader("accept");
        Cookie[] cookies = request.getCookies();

        modelAndView.setViewName("greeting/hello");

        return modelAndView;
    }

}