package com.example.bill.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bill.Model.Bill;




@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
	Iterable<Bill>  findByPatientId(long patientId);
}