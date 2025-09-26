package com.ashokit.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ashokit.dto.Product;
import com.ashokit.entity.UserInfo;
import com.ashokit.repository.ProductDao;
import com.ashokit.repository.UserInfoRepository;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ProductService {

    List<Product> productList = null;

    @Autowired
    private UserInfoRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private ProductDao productdao;

    @PostConstruct
    public void loadProductsFromDB() {
      /*  productList = IntStream.rangeClosed(1, 100)
                .mapToObj(i -> new Product(
                        i,
                        "product " + i,
                        new Random().nextInt(10),
                        new Random().nextInt(5000)
                       ).build()
                ).collect(Collectors.toList());*/
    }


    public Iterable<Product> getProducts() {
        //return productList;
    	return productdao.findAll();
    }

    public Product getProduct(int id) {
       /* return productList.stream()
                .filter(product -> product.getProductId() == id)
                .findAny()
                .orElseThrow(() -> new RuntimeException("product " + id + " not found"));*/
    	
    	return productdao.findById(id).orElse(new Product());
    }


    public String addUser(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        repository.save(userInfo);
        return "user added to system ";
    }
}
