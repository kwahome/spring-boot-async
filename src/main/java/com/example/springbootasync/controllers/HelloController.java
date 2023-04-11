package com.example.springbootasync.controllers;

import com.example.springbootasync.services.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("api/v1")
public class HelloController {
    private final HelloService helloService;

    @Autowired
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public String hello() throws InterruptedException, ExecutionException {
        CompletableFuture<Boolean> completableFuture = this.helloService.backgroundWork();

        return String.format("Hello! Result='%s'", completableFuture.get());
    }
}
