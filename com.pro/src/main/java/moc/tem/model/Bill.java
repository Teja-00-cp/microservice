package moc.tem.model;

import java.time.LocalDate;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class Bill {

	private Long billId;
	private long patientId; // Use ID
	private long totalAmount;

	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus;

	 private LocalDate billDate;
	 
	public enum PaymentStatus{
		PAID, UNPAID
	}

    // Constructors
    public Bill() {}

    public Bill(Long billId, long patientId, long totalAmount, PaymentStatus paymentStatus, LocalDate billDate) {
        this.billId = billId;
        this.patientId = patientId;
        this.totalAmount = totalAmount;
        this.paymentStatus = paymentStatus;
        this.billDate = billDate;
    }

    // Getters and Setters
	public Long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	public long getPatientId() {
		return patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
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
    
    @Override
	public String toString() {
		return "Bill [billId=" + billId + ", patientId=" + patientId + ", totalAmount=" + totalAmount
				+ ", paymentStatus=" + paymentStatus + ", billDate=" + billDate + "]";
	}
}