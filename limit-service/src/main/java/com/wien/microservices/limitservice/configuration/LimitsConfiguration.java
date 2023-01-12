package com.wien.microservices.limitservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limit-service")
public class LimitsConfiguration {
    private Integer min;
    private Integer max;

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }
}
