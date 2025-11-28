package com.example.payment.client;

import moc.tem.model.Doctor;

// Implement your Feign client interface
public class WelcomeOrderServiceFallback implements WelcomrFeign {

    private final Throwable cause;

    // Constructor to capture the exception cause
    public WelcomeOrderServiceFallback(Throwable cause) {
        this.cause = cause;
        // Log the error to your console/logs
        System.err.println("Feign Fallback for WELCOME-ORDER-SERVICE triggered. Reason: " + cause.getMessage());
    }

    // Must implement all methods from WelcomrFeign
    
    // Changed to throw an exception instead of returning a default object
    @Override
    public Doctor getDoctorDetails(Long id) {
        System.err.println("FALLBACK: Downstream service is unavailable. Throwing exception for Circuit Breaker.");
        // Throw a RuntimeException to signal failure to the Circuit Breaker
        throw new RuntimeException("Service failure in Feign client: cannot fetch Doctor details. Fallback triggered.", cause);
    }

    // Changed to throw an exception instead of returning a default object
    @Override
    public Doctor getbyName(String name) {
        System.err.println("FALLBACK: Downstream service is unavailable. Throwing exception for Circuit Breaker.");
        // Throw a RuntimeException to signal failure to the Circuit Breaker
        throw new RuntimeException("Service failure in Feign client: cannot fetch Doctor by name. Fallback triggered.", cause);
    }
}