package com.example.payment.client;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

// Implement FallbackFactory interface, specifying your Feign client interface
@Component
public class WelcomeOrderServiceFallbackFactory implements FallbackFactory<WelcomrFeign> {

    @Override
    public WelcomrFeign create(Throwable cause) {
        // Return a new instance of your concrete fallback implementation
        return new WelcomeOrderServiceFallback(cause);
    }
}