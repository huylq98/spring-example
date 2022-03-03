package com.viettel.vds.springexample.controller;

import com.viettel.vds.springexample.service.feign.HealthcareServiceFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${spring.application.name}/public/v1/healthcare")
public class HealthcareController {
    private final HealthcareServiceFeignClient healthcareServiceFeignClient;

    @GetMapping("/{category}")
    public List<Object> healthcare(@PathVariable("category") String category) {
        return healthcareServiceFeignClient.healthcare(category);
    }
}
