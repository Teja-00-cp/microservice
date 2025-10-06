package moc.tem.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;

public class Doctor {
	
	private long doctorId ;
	private String name;
	private String specialization; 
	private String contactNumber ;
	private String availabilitySchedule;
	
//    @JsonManagedReference("doctor-appointments") 
    private List<Appointment> appointments;
    
    // Constructors
    public Doctor() {}

    public Doctor(long doctorId, String name, String specialization, String contactNumber, String availabilitySchedule, List<Appointment> appointments) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.contactNumber = contactNumber;
        this.availabilitySchedule = availabilitySchedule;
        this.appointments = appointments;
    }

    // Getters and Setters
	public long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getAvailabilitySchedule() {
		return availabilitySchedule;
	}
	public void setAvailabilitySchedule(String availabilitySchedule) {
		this.availabilitySchedule = availabilitySchedule;
	}
	public List<Appointment> getAppointments() {
		return appointments;
	}
	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
    
    @Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", name=" + name + ", specialization=" + specialization
				+ ", contactNumber=" + contactNumber + ", availabilitySchedule=" + availabilitySchedule + "]";
	}
}