package com.example.order.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.order.Model.Doctor;



public interface DocRe extends JpaRepository<Doctor, Long>{
	Doctor findByName(String name);
}
