package moc.tem.model;

import java.util.List;
public class Doctor {

	private long doctorId ;
	private String name;
	private String specialization; 
	private String contactNumber ;
	private String availabilitySchedule;
	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", name=" + name + ", specialization=" + specialization
				+ ", contactNumber=" + contactNumber + ", availabilitySchedule=" + availabilitySchedule
				+ ", appointments=" + appointments + "]";
	}

	
	public List<Appointment> getAppointments() {
		return appointments;
	}


	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

    private List<Appointment> appointments;
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	
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

}
