package com.example.payment.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "Welcome-Order")
public interface WelcomrFeign {
    @GetMapping("/order/welcome")
	public String getWelcomeMsg();
}
