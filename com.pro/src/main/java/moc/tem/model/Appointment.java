package moc.tem.model;

import java.time.LocalDate;

public class Appointment {

    private long appointmentId;


    private Patient patient;


    private Doctor doctor;

    private LocalDate appointmentDate;
    private String timeSlot;
    
    // Corrected to use enum type

    private Status status;

    public enum Status {
        CONFIRMED, CANCELLED, PENDING;
    }
    
    // Getters and Setters
    public long getAppointmentId() {
        return appointmentId;
    }
    public void setAppointmentId(long appointmentId) {
        this.appointmentId = appointmentId;
    }
    public Patient getPatient() {
        return patient;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    public Doctor getDoctor() {
        return doctor;
    }
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }
    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
    public String getTimeSlot() {
        return timeSlot;
    }
    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }
    
    // Corrected getStatus method
    public Status getStatus() {
        return status;
    }
    
    // Corrected setStatus method
    public void setStatus(Status status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return "Appointment [appointmentId=" + appointmentId + ", appointmentDate=" + appointmentDate
                + ", timeSlot=" + timeSlot + ", status=" + status + "]";
    }
}