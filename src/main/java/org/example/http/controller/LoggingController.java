package org.example.http.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.example.dto.LoggingDto;

@Controller
public class LoggingController {

    @RequestMapping("/loggingPage")
    public String loggingPage(){
        return "user/logging";
    }

    @RequestMapping("/logging")
    public String logging(Model model, @ModelAttribute LoggingDto loggingDto){
        return "redirect:https://google.us";
    }
}
