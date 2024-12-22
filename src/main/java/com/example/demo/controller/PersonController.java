package com.example.demo.controller;

import com.example.demo.dto.IngredientPojo;
import com.example.demo.service.IngredientService;
import com.example.demo.service.PersonService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @GetMapping("/findById")
    public Mono<String> findById(){
        return personService.findById();
    }
}
