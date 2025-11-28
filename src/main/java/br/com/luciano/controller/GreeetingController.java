package br.com.luciano.controller;

import br.com.luciano.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreeetingController {
    private final String template = "Hello, %s";
    private final AtomicLong conter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeeting(@RequestParam(value = "name", defaultValue = "world") String name ){
        return new Greeting(conter.incrementAndGet(), String.format(template, name));
    }
}
