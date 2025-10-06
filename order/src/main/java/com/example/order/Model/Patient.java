package com.example.order.Model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

// Removed unused Jackson relationship imports
// import com.fasterxml.jackson.annotation.JsonBackReference;
// import com.fasterxml.jackson.annotation.JsonManagedReference;

// Removed JPA relationship imports
// import jakarta.persistence.CascadeType;
// import jakarta.persistence.OneToMany;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ElementCollection; // To store a collection of simple types (Long)
import jakarta.persistence.CollectionTable;  // To define the table for the IDs
import jakarta.persistence.JoinColumn;       // To join the ID table back to Patient

@Entity
public class Patient {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long patientId ;

	@Column(unique = true)
	private String name ;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

	private String gender ;
    private String contactNumber ;
    private String address;
	private String medicalHistory;
    
    // --- Microservice Reference: Replaced @OneToMany with List of IDs ---
    
    /**
     * Stores the IDs of appointments related to this patient, which are managed
     * by a separate Appointment Microservice.
     */
    @ElementCollection 
    @CollectionTable(
        name = "patient_appointment_ids", // Separate table for the IDs
        joinColumns = @JoinColumn(name = "patient_id")
    )
    @Column(name = "appointment_id")
    private List<Long> appointmentIds;
    
    // --- End of Microservice ID Mapping ---

	public Patient() {
		super();
	}

	// --- Getters and Setters for Appointment IDs ---
	public List<Long> getAppointmentIds() {
		return appointmentIds;
	}
    
	public void setAppointmentIds(List<Long> appointmentIds) {
		this.appointmentIds = appointmentIds;
	}
    // Removed the old getAppointments/setAppointments which used List<Appointment>


	public long getPatientId() {
		return patientId;
	}
	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	@Override
	public String toString() {
		// Cleaned up toString() to exclude the collection field for safety
		return "Patient [patientId=" + patientId + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", gender="
				+ gender + ", contactNumber=" + contactNumber + ", address=" + address + ", medicalHistory="
				+ medicalHistory + "]";
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMedicalHistory() {
		return medicalHistory;
	}
	public void setMedicalHistory(String medicalHistory) {
		this.medicalHistory = medicalHistory;
	}
}