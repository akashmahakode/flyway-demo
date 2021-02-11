package com.postgres.flyway.demo.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeCounterMetrics {

    @Autowired
    private MeterRegistry meterRegistry;

    public void incrementCounter(){
        Counter.builder("employee.increment.counter").register(meterRegistry).increment();
    }
}
