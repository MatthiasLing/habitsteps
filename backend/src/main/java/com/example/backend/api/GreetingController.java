package com.example.backend.api;
import com.example.backend.model.Greeting;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class GreetingController {
    private static final String template = "Hello, %s!";

    private final AtomicLong counter = new AtomicLong();

    @CrossOrigin()
    @GetMapping(path="/greeting")
    public Greeting greeting(@RequestParam(required = false, defaultValue = "World") String name) {
        System.out.println("==== get greeting ====");
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
