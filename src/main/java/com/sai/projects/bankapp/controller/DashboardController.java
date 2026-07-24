package com.sai.projects.bankapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DashboardController {

    @GetMapping("/dashboard")
    public Map<String, Object> dashboard() {
        Map<String, Object> data = new HashMap<>();
        data.put("balance", 50000);
        data.put("transactions", List.of(1000, -500, 2000));
        return data;
    }
}