package com.example.demo.helloworld.application;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("helloworld")
public class HelloWorldApi {

    @GetMapping
    public ResponseEntity<String> getHelloWorld() {
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }
}
