package com.ashokit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ashokit.dto.Product;

@Repository
public interface ProductDao extends CrudRepository<Product, Integer> {

}
