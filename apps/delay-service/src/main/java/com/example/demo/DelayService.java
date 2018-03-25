package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;

@SpringBootApplication
@RestController
public class DelayService {

  public static void main(String[] args) {
    SpringApplication.run(DelayService.class, args);
  }

  @GetMapping("/{delayMillis}")
  public Mono<String> get(@PathVariable int delayMillis) {
    return Mono.just("OK")
        .delayElement(Duration.ofMillis(delayMillis));
  }
}
