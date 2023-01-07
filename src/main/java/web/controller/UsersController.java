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
    public String index(Model model){
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
    public String deleteUserById(@PathVariable("id")int id, Model model){
        service.removeUserById(id);
        return "redirect:/";
    }

    @PostMapping("/create")
    public String createNewUser(@ModelAttribute("user") User user,
                                Model model){
        service.add(user);
        return "redirect:/";
    }
    @GetMapping("/delete/all")
    public String deleteAllUsers(Model model){
        service.removeAllUsers();
        return "redirect:/";
    }
//    @GetMapping("/update/name")
//    public String setName(@RequestParam(value = "name", required = false, defaultValue = "Bob") String name,
//                          @RequestParam(value = "id", required = false, defaultValue = "1") Integer id,
//                            Model model){
//        service.updateName(id, name);
//        return "redirect:/";
//    }
    @PatchMapping("/{id}/update")
    public String update(@ModelAttribute("user") User user,
                         @PathVariable("id") int id){
        service.update(id, user);
        return "redirect:/";
    }
}
