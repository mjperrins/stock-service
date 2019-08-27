package com.ibm.stock.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "stock")
public class StockConfig {
    private String pattern;

    public StockConfig() {
        super();
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public StockConfig withPattern(String pattern) {
        this.setPattern(pattern);
        return this;
    }

    public String toString() {
        return String.format("[HelloConfig: pattern=%s]", pattern);
    }
}
