package com.postgres.flyway.demo.metrics;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class EmployeeGaugeMetrics {

    public static final AtomicInteger EMPLOYEE_COUNT = new AtomicInteger(-1);

    @Autowired
    private MeterRegistry meterRegistry;

    @PostConstruct
    public void initialize(){
        Gauge.builder("employee.count", this, i -> EMPLOYEE_COUNT.get()).register(meterRegistry);
    }
}
