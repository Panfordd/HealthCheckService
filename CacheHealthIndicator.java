package com.oliviapanford.assignment.actuator;

import org.jspecify.annotations.Nullable;
import org.springframework.boot.health.contributor.Health;
import org.springframework.boot.health.contributor.HealthIndicator;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CacheHealthIndicator implements HealthIndicator {

    @Override
    public  Health health() {
        long startTime=System.currentTimeMillis();

        boolean isCacheUp=checkCache();

        long responseTime=System.currentTimeMillis()-startTime;

        if(isCacheUp){
            return Health.up().withDetail("service", "Cache Service" )
                    .withDetail("responseTime",responseTime +"ms")
                    .withDetail("lastChecked", LocalDateTime.now().toString())
                    .build();
        }
        else{
            return Health.down()
                    .withDetail("service","Cache Service")
                    .withDetail("responseTime",responseTime +"ms")
                    .withDetail("error", "Cache connection failed")
                    .withDetail("lastChecked", LocalDateTime.now().toString())
                    .build();
        }

    }

    private boolean checkCache() {
        return Math.random()>0.05;

    }
}
