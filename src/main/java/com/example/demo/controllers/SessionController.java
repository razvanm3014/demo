package com.example.demo.controllers;

import com.example.demo.models.Session;
import com.example.demo.repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/sessions")
public class SessionController {
    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping
    public List<Session> list(){
        return sessionRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Session get(@PathVariable Integer id){
        return sessionRepository.getOne(id);
    }

    @PostMapping
    public Session createSession(@RequestBody final Session session){
        return sessionRepository.saveAndFlush(session);

    }


    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete (@PathVariable Integer id ){
        sessionRepository.deleteById(id);
    }


    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public void update (@PathVariable Integer id, @RequestBody Session newSession){
        Session old = sessionRepository.getOne(id);
        old.setSession_description(newSession.getSession_description());
        old.setSession_length(newSession.getSession_length());
        old.setSession_name(newSession.getSession_name());
        sessionRepository.saveAndFlush(old);

    }



}
