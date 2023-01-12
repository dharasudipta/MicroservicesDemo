package com.wien.microservices.currencyconversionservice.beans;

import java.math.BigDecimal;

public class CurrencyConversionResponse {

    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    private Integer qty;
    private BigDecimal totalCalculatedAmount;
    private String environment;

    public CurrencyConversionResponse(Long id, String from, String to, Integer qty) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.qty = qty;
//        this.environment = environment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(BigDecimal conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public BigDecimal getTotalCalculatedAmount() {
        return totalCalculatedAmount;
    }

    public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
        this.totalCalculatedAmount = totalCalculatedAmount;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    @Override
    public String toString() {
        return "CurrencyConversionResponse{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", conversionMultiple=" + conversionMultiple +
                ", qty=" + qty +
                ", totalCalculatedAmount=" + totalCalculatedAmount +
                ", environment='" + environment + '\'' +
                '}';
    }
}
