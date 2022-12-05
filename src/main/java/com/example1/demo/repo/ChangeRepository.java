package com.example1.demo.repo;


import com.example1.demo.dao.ChangeDao;
import com.example1.demo.domain.ChangeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Repository
public class ChangeRepository
{
    @Autowired ChangeDao dao;

    public ModelAndView findNecessaryGame(ChangeInfo changeInfo)
    {
        ModelAndView model = new ModelAndView("listGames");
        model.addObject("games", dao.findNewOrder(changeInfo).get(0));
        return model;
    }


    public void saveNecessaryGame(ChangeInfo changeInfo)
    {
        dao.saveNewOrder(changeInfo);
    }
}
