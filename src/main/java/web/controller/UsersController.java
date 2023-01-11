package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;


@Controller
public class UsersController {
    private final UserService service;
    @Autowired
    public UsersController(UserService service) {
        this.service = service;
    }

    @GetMapping(value = "/")
    public String mainPage(Model model){
        model.addAttribute("users", service.getAllUsers());
        return "index.html";
    }

    @GetMapping("/{id}")
    public String showUserById(@PathVariable("id") int id, Model model){
        model.addAttribute("userById", service.getUserById(id));
        model.addAttribute("id", id);
        model.addAttribute("pageTitle", service.getUserById(id).getName());
        return "byId";
    }

    @GetMapping("/{id}/delete")
    public String deleteUserById(@PathVariable("id")int id){
        service.removeUserById(id);
        return "redirect:/";
    }

    @PostMapping("/create")
    public String createNewUser(@ModelAttribute("user") User user){
        service.addUser(user);
        return "redirect:/";
    }
    @GetMapping("/delete/all")
    public String deleteAllUsers(){
        service.removeAllUsers();
        return "redirect:/";
    }
    @PatchMapping("/{id}/update")
    public String update(@ModelAttribute("user") User user,
                         @PathVariable("id") int id){
        service.updateUser(id, user);
        return "redirect:/";
    }
}
