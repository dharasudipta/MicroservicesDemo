package com.wien.microservices.limitservice.controller;

import com.wien.microservices.limitservice.bean.Limits;
import com.wien.microservices.limitservice.configuration.LimitsConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitResource {

    private LimitsConfiguration limitsConfiguration;

    @Autowired
    public LimitResource(LimitsConfiguration limitsConfiguration) {
        this.limitsConfiguration = limitsConfiguration;
    }

    @GetMapping("limits")
    public Limits getLimit() {
        return new Limits(this.limitsConfiguration.getMin(), this.limitsConfiguration.getMax());
    }
}
