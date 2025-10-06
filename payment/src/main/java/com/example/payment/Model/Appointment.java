package com.example.payment.Model;

import java.time.LocalDate;

// Removed: com.fasterxml.jackson.annotation.JsonBackReference (no complex relationships needed here)
// Removed: moc.tem.model.Doctor and moc.tem.model.Patient imports (no direct object references)

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// Removed: jakarta.persistence.JoinColumn and jakarta.persistence.ManyToOne

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long appointmentId;

    // REPLACED: @ManyToOne Patient patient;
    // Use a simple ID (long) to store the foreign key.
    private long patientId;

    // REPLACED: @ManyToOne Doctor doctor;
    // Use a simple ID (long) to store the foreign key.
    private long doctorId;

    private LocalDate appointmentDate;
    private String timeSlot;
    
    @Enumerated(EnumType.STRING)
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
    
    // REVISED Getters and Setters for patientId
    public long getPatientId() {
        return patientId;
    }
    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    // REVISED Getters and Setters for doctorId
    public long getDoctorId() {
        return doctorId;
    }
    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
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
    
    public Status getStatus() {
        return status;
    }
    
    public void setStatus(Status status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return "Appointment [appointmentId=" + appointmentId 
                + ", patientId=" + patientId 
                + ", doctorId=" + doctorId 
                + ", appointmentDate=" + appointmentDate
                + ", timeSlot=" + timeSlot + ", status=" + status + "]";
    }
}