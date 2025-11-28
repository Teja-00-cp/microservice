package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
// @RestController
// @RequestMapping("/gateway-fallback")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	// @RequestMapping("/welcome")
    // public String welcomeServiceFallback() {
    //     return "The Welcome/Order service is currently unavailable. Please try again later.";
    // }

    // @RequestMapping("/bill")
    // public String billServiceFallback() {
    //     return "The Billing service is currently unavailable. Please try again later.";
    // }
    
    // @RequestMapping("/payment")
    // public String paymentServiceFallback() {
    //     return "The Payment/Appointment service is currently unavailable. Please try again later.";
    // }

}
