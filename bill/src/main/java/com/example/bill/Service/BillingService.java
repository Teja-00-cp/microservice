package com.example.bill.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.bill.Model.Bill;
import com.example.bill.Model.Bill.PaymentStatus;
import com.example.bill.Repository.BillRepository;
import com.example.bill.controller.BillingController.BillData;
import com.example.bill.feign.WelcomrFeign;

import moc.tem.model.Patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.Date;
import java.util.Map;

@Service
public class BillingService {

    @Autowired
    private BillRepository billRepository;
    
    @Autowired
    private WelcomrFeign welcomrFeign;

    public Iterable<Bill> generateBill(Long patientId) {
        System.out.println("Generating bill for patient ID: " + billRepository.findByPatientId(patientId));
    	return billRepository.findByPatientId(patientId);

    }
    
    public String processPaymentafter(BillData data) {
        Patient feignpatient=welcomrFeign.getPatientDetails(data.getPatientId()).orElse(null);
    	String status=processPayment(data);
    	Bill bill=new Bill();
    	bill.setBillDate(LocalDate.now());
    	bill.setPatientId(data.getPatientId());
    	bill.setTotalAmount(data.getTotalAmount());
    	bill.setPaymentStatus(status=="fail"?PaymentStatus.UNPAID:PaymentStatus.PAID);
    	billRepository.save(bill);
    	
        return status;
    }

    public Bill getBillDetails(Long billId) {
        return billRepository.findById(billId)
                .orElseThrow(() -> new RuntimeException("Bill not found with ID: " + billId));
    }

    public String processPayment(BillData data) {
    	boolean bol=welcomrFeign.getPatientDetails(000L).isPresent();
    	
    	
        return System.currentTimeMillis()%2==0 && bol?"success":"fail";
    }
}