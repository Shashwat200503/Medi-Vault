package com.medivault.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/test") // ✅ removed /api prefix
public class ApiCheckController {

    @Value("${server.port:8080}")
    private int port;

    private final String BASE_URL = "http://localhost:8080/MediVault";

    @GetMapping("/all")
    public ResponseEntity<?> testAllEndpoints() {
        RestTemplate rest = new RestTemplate();

        List<String> endpoints = Arrays.asList(
            "/api/users",
            "/api/users/1",
            "/api/prescriptions",
            "/api/prescriptions/1",
            "/api/lab-reports",
            "/api/lab-reports/1",
            "/api/documents",
            "/api/documents/1"
        );

        List<Map<String, Object>> results = new ArrayList<>();

        for (String endpoint : endpoints) {
            String url = BASE_URL + endpoint;
            Map<String, Object> result = new LinkedHashMap<>();
            result.put("url", endpoint);
            try {
                ResponseEntity<String> response = rest.getForEntity(url, String.class);
                result.put("status", response.getStatusCode().value());
                result.put("statusName", response.getStatusCode().toString());
            } catch (Exception e) {
                result.put("status", "FAILED");
                result.put("error", e.getClass().getSimpleName());
                result.put("message", e.getMessage());
            }
            results.add(result);
        }

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("checked", results);
        return ResponseEntity.ok(response);
    }
}
