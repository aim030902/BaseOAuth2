package uz.pdp.b5oauth2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import uz.pdp.b5oauth2.entity.User;
import uz.pdp.b5oauth2.repo.UserRepo;

@Controller
public class UserController {

    @Autowired
    UserRepo userRepo;

    @GetMapping("/user")
    public String oauth(@AuthenticationPrincipal OAuth2User principal){
        System.out.println(principal);
        User user =new User();
        user.setBio(principal.getAttribute("bio"));
        user.setEmail(principal.getAttribute("email"));
        user.setAvatar_url(principal.getAttribute("avatar_url"));
        user.setGiven_name(principal.getAttribute("given_name"));
        user.setLogin(principal.getAttribute("login"));
        user.setName(principal.getAttribute("name"));
        user.setPicture(principal.getAttribute("picture"));
        user.setType(principal.getAttribute("type"));
        user.setUrl(principal.getAttribute("url"));
        userRepo.save(user);

        return "index";
    }

    @GetMapping("/lists")
    public String list(Model model){
        model.addAttribute("userList",userRepo.findAll());
        return "users";
    }
}
