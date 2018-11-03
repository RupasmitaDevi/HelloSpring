package com.example.exampleproject.controllers;

import com.example.exampleproject.GreetingService.Greeting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class WelcomeController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", defaultValue="World") String name) {
        LOGGER.info("This is a greeting message");
        Greeting greet = new Greeting(counter.incrementAndGet(),
                String.format(template, name));
        String result = greet.getContent();
        return result;
    }

}

