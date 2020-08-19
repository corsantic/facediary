package com.fonsoft.facediary.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    private static final String template = "Hello dsfskdh!";

    @GetMapping("/hello")
    public String hello() {
        return template;
    }
}
