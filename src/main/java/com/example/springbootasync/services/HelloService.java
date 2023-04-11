package com.example.springbootasync.services;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class HelloService {

    @Async
    public CompletableFuture<Boolean> backgroundWork() throws InterruptedException {
        Thread.sleep(4000);

        return CompletableFuture.completedFuture(true);
    }
}
