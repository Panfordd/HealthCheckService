package com.oliviapanford.assignment.actuator;


import org.springframework.boot.health.contributor.Health;
import org.springframework.boot.health.contributor.HealthIndicator;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class DatabaseHealthIndicator implements HealthIndicator {



    @Override
    public  Health health() {
        long startTime=System.currentTimeMillis();

        boolean isDatabaseUp=checkDatabase();

        long responseTime=System.currentTimeMillis()-startTime;

        if(isDatabaseUp){
            return Health.up().withDetail("service", "Database" )
                    .withDetail("responseTime",responseTime +"ms")
                    .withDetail("lastChecked", LocalDateTime.now().toString())
                    .build();
        }
        else{
            return Health.down()
                    .withDetail("service","Database")
                    .withDetail("responseTime",responseTime +"ms")
                    .withDetail("error", "Connection timeout")
                    .withDetail("lastChecked", LocalDateTime.now().toString())
                    .build();
        }

    }

    private boolean checkDatabase() {
        return Math.random()>0.1;
        //for demo purposes
        //return false;


    }
}
