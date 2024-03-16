package com.intela.springjwtauth.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    private final RestTemplate restTemplate;

    public AdminController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/football-matches")
    public ResponseEntity<?> getFootballMatches() {
        System.out.println("====================> Api called");
        String apiUrl = "https://jsonmock.hackerrank.com/api/football_matches?year=2011&page=1";
        String response = restTemplate.getForObject(apiUrl, String.class);
        return ResponseEntity.ok(response);
    }
    }
