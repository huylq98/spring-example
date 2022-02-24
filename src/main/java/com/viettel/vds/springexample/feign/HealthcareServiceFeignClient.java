package com.viettel.vds.springexample.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "healthcare", url = "${wso2.training.url}")
@RequestMapping("/healthcare")
public interface HealthcareServiceFeignClient {

    @GetMapping("/{category}")
    List<Object> healthcare(@PathVariable("category") String category);
}
