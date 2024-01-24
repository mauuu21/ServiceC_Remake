package org.example.servicec_remake.common.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomMetrics {

    @Bean
    @Qualifier("userLoggedInCounter")
    public Counter userLoggedInCounter(MeterRegistry meterRegistry) {
        return Counter.builder("user.loggedIn")
                .tag("type", "user")
                .description("The number of logged in users")
                .register(meterRegistry);
    }
}
