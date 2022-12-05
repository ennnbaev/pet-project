package com.example1.demo.controller;

import com.example1.demo.domain.User;
import com.example1.demo.service.UserService;
import com.example1.demo.validation.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@org.springframework.stereotype.Controller
public class RegistrationController
{
    @Autowired UserValidator userValidator;
    @Autowired UserService userService;

    @GetMapping("/registration")
    public ModelAndView registration()
    {
        var mav = new ModelAndView();
        mav.addObject("user",new User());
        mav.setViewName("registration");
        return mav;
    }
    @PostMapping("/registration")
    public ModelAndView registration(@ModelAttribute User user)
    {
        var mav = userValidator.userRegisterValidator(user);
        if(mav.getModel().size()!=0){
            return mav;
        }
        userService.saveUser(user);
        mav.setViewName("login");
        return mav;
    }
}
