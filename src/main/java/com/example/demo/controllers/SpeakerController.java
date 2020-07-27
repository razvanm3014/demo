package com.example.demo.controllers;

import com.example.demo.models.Speaker;
import com.example.demo.repositories.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakerController {
    @Autowired
    private SpeakerRepository speakerRepository;

    @GetMapping
    public List<Speaker> getAll()
    {
        return speakerRepository.findAll();
    }


    @GetMapping
    @RequestMapping("{id}")
    public Speaker getSpeaker(@PathVariable Integer id){
        return speakerRepository.getOne(id);
    }

}
