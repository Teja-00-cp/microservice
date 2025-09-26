package com.example.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.payment.client.WelcomrFeign;

import org.springframework.web.bind.annotation.GetMapping;



@SpringBootApplication

@RestController
// @RequestMapping(value = "/")
@EnableFeignClients
@EnableDiscoveryClient
@RequestMapping(value = "/payment")
public class PaymentApplication {
	@Autowired
	private WelcomrFeign welcomrFeign;

	

	@GetMapping("/order")
	public String payment(){
		String par=welcomrFeign.getWelcomeMsg();
		System.out.println(par);
		return par;
	}
	@GetMapping("/payment")
	public String getMethodName() {
		return new String("iam from payment");
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(PaymentApplication.class, args);
	}

}
