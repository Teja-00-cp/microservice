package com.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import com.ashokit.dto.AuthRequest;
import com.ashokit.dto.AuthResponse;
import com.ashokit.dto.Product;
import com.ashokit.entity.UserInfo;
import com.ashokit.service.JwtService;
import com.ashokit.service.ProductService;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

// @CrossOrigin(originPatterns = {"http://localhost:3000"})
@RestController
@RequestMapping("/login")
@CrossOrigin(origins ="http://localhost:3000")
public class ProductController {

    @Autowired
    private ProductService service;
    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;
        // @GetMapping
	    // public String welcomwe() {
	    //     return "Welcome to Google !!";
	    // }
    public String token;
    @GetMapping("/welcome")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

    // @GetMapping("/user")
	// public Principal user(Principal principal) {
	//         System.out.println("username : " + principal.getName());
	//     return principal;
	// }

    @PostMapping("/new")
    public String addNewUser(@RequestBody UserInfo userInfo) {
        return service.addUser(userInfo);
    }

    @GetMapping("/all")

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Product> getAllTheProducts() {
        return (List<Product>) service.getProducts();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Product getProductById(@PathVariable int id) {
        return service.getProduct(id);
    }

    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest, HttpServletResponse response) throws IOException {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            String ans=jwtService.generateToken(authRequest.getUsername());
            System.out.println(ans);
            // response.sendRedirect("/products/welcome");
            return ans;
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }


    }

}
