package moc.tem.model;

import java.time.LocalDate;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

public class Patient {
	
	private long patientId ;
    private String name ;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

	private String gender ;
    private String contactNumber ;
    private String address;
	private String medicalHistory;
    
//    @JsonManagedReference("patient-appointments")
    private List<Appointment> appointments;

    // Constructors
    public Patient() {}

    public Patient(long patientId, String name, LocalDate dateOfBirth, String gender, String contactNumber, String address, String medicalHistory, List<Appointment> appointments) {
        this.patientId = patientId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.address = address;
        this.medicalHistory = medicalHistory;
        this.appointments = appointments;
    }

    // Getters and Setters
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
    public List<Appointment> getAppointments() {
		return appointments;
	}
	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

    @Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", gender="
				+ gender + ", contactNumber=" + contactNumber + "]";
	}
}