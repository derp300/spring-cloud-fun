package com.example.worker.controller;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestController {

  @Value("${rand.amount}")
  Integer amount;

  private Random random = new Random();

  @GetMapping("/random")
  public List<Integer> exerciseList() {

    return Stream.generate(() -> random.nextInt(10))
        .limit(amount)
        .collect(Collectors.toList());
  }





  @Value("${foo.bar2}")
  String foo;

  @GetMapping("/test")
  public String test() {

    return foo;
  }



  @GetMapping("/worker")
  public Integer port() {

    return 2;
  }


}
