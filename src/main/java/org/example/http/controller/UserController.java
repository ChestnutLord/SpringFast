package org.example.http.controller;

import lombok.AllArgsConstructor;
import org.example.dto.UserCreateEditDto;
import org.example.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    public UserService userService;

    @GetMapping
    public String findAll(Model model) {
        //model.addAttribute("users", userService.findAll());
        return "user/users";
    }

    @GetMapping("/{id}")
    public String findByid(@PathVariable("id") Long id, Model model) {
        //model.addAttribute("user", userService.findById(id));
        return "user/user";
    }

    @PostMapping
    public String create(@ModelAttribute UserCreateEditDto userCreateEditDto) {
        //userService.cretae(userCreateEditDto);
        return "redirect:/users/" + 25;
    }

    //@PostMapping("/{id}")
    @PostMapping("/{id}/update")
    public String update(@PathVariable("id") Long id, @ModelAttribute UserCreateEditDto userCreateEditDto) {
        //userService.update(id, userCreateEditDto);
        return ("redirect:/users/{id}");
    }

//    @DeleteMapping("/{id}")
@PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
//        userService.delete(id);
        return "redirect:/users";
    }
}
