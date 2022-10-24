package com.dh.clinica.controller;

import com.dh.clinica.model.dto.País;
import org.apache.tomcat.util.json.ParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("{code}")
    public ResponseEntity<País> getCountryInfo(@PathVariable String code) throws ParseException, org.json.simple.parser.ParseException {

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("https://restcountries.com/v3.1/alpha/" + code, String.class);

        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) ((JSONArray) parser.parse(result)).get(0);

        return ResponseEntity.ok(new País(json.get("cca3").toString(), json.get("capital").toString()));

    }
}
