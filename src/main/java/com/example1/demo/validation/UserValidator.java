package com.example1.demo.validation;

import com.example1.demo.domain.User;

import com.example1.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
@Component
public class UserValidator
{

    @Autowired UserService userService;

    public ModelAndView userRegisterValidator(User user)
    {
        var mav = new ModelAndView();
        mav.setViewName("registration");

        if(userService.findUserByName(user.getUsername()) != null)
        {
            mav.addObject("usernameMessage", "This username already exists!");
        }
        if(user.getUsername().length() < 6)
        {
            mav.addObject("usernameMessage", "Username length should to have more than 6 symbols");

        }
        if(user.getPassword().length() < 6)
        {
            mav.addObject("passwordMessage", "Password length should to have more than 6 symbols");

        }
        if(userService.findUserByEmail(user.getEmail()) != null)
        {
            mav.addObject("emailMessage", "You have already profile!");

        }
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        if(!user.getEmail().matches(emailRegex))
        {
            mav.addObject("emailMessage", "Invalid email");
        }
        return mav;
    }
}
