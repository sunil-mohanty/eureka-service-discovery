package com.ski.spring.cloud.eureka.service;

import org.springframework.web.bind.annotation.RequestMapping;

public interface ServiceController {
    @RequestMapping("/ping")
    String greeting();
}
