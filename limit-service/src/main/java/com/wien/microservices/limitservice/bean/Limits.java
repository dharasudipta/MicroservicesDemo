package com.wien.microservices.limitservice.bean;

public class Limits {
    private Integer min;
    private Integer max;

    public Limits(int min, int max) {
        this.min = min;
        this.max = max;
    }

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

    @Override
    public String toString() {
        return "Limits{" +
                "min=" + min +
                ", max=" + max +
                '}';
    }
}
