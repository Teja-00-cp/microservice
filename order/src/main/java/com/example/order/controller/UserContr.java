package com.example.order.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.order.Dto.AuthRequest;
import com.example.order.Dto.DoctorDao;
import com.example.order.Dto.PatientDao;
import com.example.order.Model.User;
import com.example.order.Service.UserSer;


@RestController
@RequestMapping("/order/user")
public class UserContr {


	
	@Autowired
	private UserSer userSer;

	@PostMapping("/addPatient")
	public void addUser(@RequestBody PatientDao patientDao){
		userSer.addPatient(patientDao);
		
	}
	@PostMapping("/addDoctor")
	public void addDoctor(@RequestBody DoctorDao doctorDao){
		userSer.addDoctor(doctorDao);
		
	}
//	@GetMapping("/get/{id}/{pass}")
//	public String getUser(@PathVariable long id, @PathVariable String pass) {
//		
//		return userSer.geDta(id, pass)?"Login-success":"Login-Fail";
//	}
	@GetMapping("/getall")
//    @PreAuthorize("hasAuthority('ADMIN')")
	public Iterable<User> getallData() {
		return userSer.getallData();
	}
	@PostMapping("/forgot/forgotreq/{name}")
	public void forGotrer(@PathVariable String name) {
		
		 userSer.forGot(name);
	}
	@PostMapping("/forgot/forgotreqotp/{num}/{pass}/{userName}")
	public String veOtp(@PathVariable int num, @PathVariable String pass, @PathVariable String userName) {
		System.out.println("clickeg");
		return userSer.veOtp(num,pass,userName);
	 }
	@GetMapping("/forall")
	public String forAll() {
		return "All can view";
	}
	@GetMapping("/alluservrr")
	public String forAllUsers() {
		return "All Users can vieew";
	}
	@PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        return userSer.authenticateAndGetToken(authRequest);
    }

}
