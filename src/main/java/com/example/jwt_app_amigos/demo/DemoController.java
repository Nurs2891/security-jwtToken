package com.example.jwt_app_amigos.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class DemoController {

    @GetMapping("/demo")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello from secured endpoint");
    }

    @GetMapping("/admin")
    public ResponseEntity<String> helloAdmin() {
        return ResponseEntity.ok("Hello Admin");
    }

}
