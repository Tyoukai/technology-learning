package com.springcloud.learning.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/rate")
    public Mono<String> rateLimit() {
        return Mono.just("rate-limit");
    }
}
