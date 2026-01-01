package com.oliviapanford.assignment.actuator;

import org.jspecify.annotations.Nullable;
import org.springframework.boot.health.contributor.Health;
import org.springframework.boot.health.contributor.HealthIndicator;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class APIHealthIndicator implements HealthIndicator {
    @Override
    public  Health health() {
        long startTime=System.currentTimeMillis();

        boolean isApiUp=checkExternalApi();

        long responseTime=System.currentTimeMillis()-startTime;

        if(isApiUp){
            return Health.up().withDetail("service", "External API" )
                    .withDetail("responseTime",responseTime +"ms")
                    .withDetail("lastChecked", LocalDateTime.now().toString())
                    .build();
        }
        else{
            return Health.down()
                    .withDetail("service","External API")
                    .withDetail("responseTime",responseTime +"ms")
                    .withDetail("error", "Connection timeout")
                    .withDetail("lastChecked", LocalDateTime.now().toString())
                    .build();
        }

    }

    private boolean checkExternalApi() {
        return Math.random()>0.15;


    }
}
