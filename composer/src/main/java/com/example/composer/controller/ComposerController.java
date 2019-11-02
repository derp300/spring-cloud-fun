package com.example.composer.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ComposerController {

  @Autowired
  @LoadBalanced
  private RestTemplate restTemplate;

  @GetMapping("/test")
  public Integer test() {
    return restTemplate.getForObject("http://worker/worker", Integer.class);
  }

  //TODO remove
  abstract class ParameterizedWrapper implements List<Integer> {};
}
