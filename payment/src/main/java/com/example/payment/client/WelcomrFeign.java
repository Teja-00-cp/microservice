package com.example.payment.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import moc.tem.model.Doctor;

@FeignClient(
    name = "WELCOME-ORDER-SERVICE", 
    // CRITICAL: Link the client to the fallback factory
    fallbackFactory = WelcomeOrderServiceFallbackFactory.class 
)
public interface WelcomrFeign {
    
    @GetMapping("/order/get/{id}")
    Doctor getDoctorDetails(@PathVariable Long id); 
    
    @GetMapping("/order/getname/{name}")
    public Doctor getbyName(@PathVariable String name);
}