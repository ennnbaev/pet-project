package com.example1.demo.service;


import com.example1.demo.domain.ChangeInfo;
import com.example1.demo.repo.ChangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Service
public class ChangeService
{
    @Autowired ChangeRepository repository;

    @Transactional
    public ModelAndView findNecessaryGame(ChangeInfo changeInfo)
    {
        repository.saveNecessaryGame(changeInfo);
        return repository.findNecessaryGame(changeInfo);
    }
}
