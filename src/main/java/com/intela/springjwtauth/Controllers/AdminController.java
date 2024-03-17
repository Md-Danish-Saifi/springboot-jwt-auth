package com.intela.springjwtauth.Controllers;

import com.intela.springjwtauth.dto.FootballMatch;
import com.intela.springjwtauth.dto.FootballMatchesResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
    @Value("${api.url}")
    private String apiUrl;
    private final RestTemplate restTemplate;

    public AdminController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/get-draw-matches")
    public ResponseEntity<?> getFootballMatches(@RequestParam String year,@RequestParam String page) {
        Map<String,Object> data = new LinkedHashMap<>();

        String url = apiUrl + "year="+year+"&page="+page;
        FootballMatchesResponse response = restTemplate.getForObject(url, FootballMatchesResponse.class);
        assert response != null;
        List<FootballMatch> matchList = response.getData();
        List<FootballMatch> drawMatches = matchList.stream().filter(e-> e.getTeam1goals().equals(e.getTeam2goals()) ).collect(Collectors.toList());
        data.put("page",page);
        data.put("totalDrawMatches",drawMatches.size());
        data.put("totalMatches",response.getTotal());
        data.put("totalPages",response.getTotal_pages());
        data.put("perPage",response.getPer_page());
        data.put("data",drawMatches);
        return ResponseEntity.ok(data);
    }
    }
