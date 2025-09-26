package moc.tem.model;

import java.time.LocalDate;

public class Bill {

	private Long billId;

	private Patient patient;

	private long totalAmount;
	private PaymentStatus paymentStatus;
	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bill(Long billId, Patient patient, long totalAmount, PaymentStatus paymentStatus, LocalDate billDate) {
		super();
		this.billId = billId;
		this.patient = patient;
		this.totalAmount = totalAmount;
		this.paymentStatus = paymentStatus;
		this.billDate = billDate;
	}

	public Long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public long getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(long totalAmount) {
		this.totalAmount = totalAmount;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public LocalDate getBillDate() {
		return billDate;
	}

	public void setBillDate(LocalDate billDate) {
		this.billDate = billDate;
	}

	public enum PaymentStatus{
		PAID,
	    UNPAID
	}

	 private LocalDate billDate;
}