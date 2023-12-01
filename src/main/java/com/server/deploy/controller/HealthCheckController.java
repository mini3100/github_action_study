package com.server.deploy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HealthCheckController {
// 모든 요청을 다 받을 수 있게 해줌
// 서버가 잘 돌아가고 있는가 체크해주는 역할

    @Value("${serverName}") // yml의 serverName을 가져와준다.
    private String serverName;
    @Value("${server.env}")
    private String env;
    private Integer visitedCount = 0;

    @GetMapping("/hc")
    public ResponseEntity<?> healthCheck() {
        visitedCount++;

        Map<String, Object> healthCheckData = new HashMap<>();
        healthCheckData.put("actor", "정가영");
        healthCheckData.put("serverName", serverName);
        healthCheckData.put("env", env);
        healthCheckData.put("visitedCount", visitedCount);
        return ResponseEntity.ok(healthCheckData);
    }

    @GetMapping("/env")
    public ResponseEntity<?> getEnv() {
        return ResponseEntity.ok(env);
    }

}
