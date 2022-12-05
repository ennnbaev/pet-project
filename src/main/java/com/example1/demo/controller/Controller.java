package com.example1.demo.controller;

import com.example1.demo.domain.ChangeInfo;
import com.example1.demo.service.ChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
public class Controller
{
    @Autowired ChangeService service;

    @GetMapping("")
    public ModelAndView homePage(){
            var mav = new ModelAndView();
            mav.addObject("changeInfo", new ChangeInfo());
            mav.setViewName("homePage");

            return mav;
    }
    @PostMapping("post")
    public ModelAndView postFound(@ModelAttribute ChangeInfo changeInfo){
        return service.findNecessaryGame(changeInfo);
    }

    @GetMapping(value = "/show")
    public ModelAndView show() {

        var mav = new ModelAndView();


        mav.addObject("now", 55);
        mav.setViewName("show");

        return mav;
    }
}
