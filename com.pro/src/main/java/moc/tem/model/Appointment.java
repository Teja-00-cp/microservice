package moc.tem.model;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class Appointment {
    
    private long appointmentId;

//    @JsonBackReference("patient-appointments")
    private long patientId; // Use ID
    
//    @JsonBackReference("doctor-appointments")
    private long doctorId; // Use ID

    private LocalDate appointmentDate;
    private String timeSlot;
    
    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        CONFIRMED, CANCELLED, PENDING;
    }

    // Constructors
    public Appointment() {}

    public Appointment(long appointmentId, long patientId, long doctorId, LocalDate appointmentDate, String timeSlot, Status status) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
        this.timeSlot = timeSlot;
        this.status = status;
    }

    // Getters and Setters
    public long getAppointmentId() {
        return appointmentId;
    }
    public void setAppointmentId(long appointmentId) {
        this.appointmentId = appointmentId;
    }
    public long getPatientId() {
        return patientId;
    }
    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }
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
        return "Appointment [appointmentId=" + appointmentId + ", appointmentDate=" + appointmentDate
                + ", timeSlot=" + timeSlot + ", status=" + status + ", patientId=" + patientId + ", doctorId=" + doctorId + "]";
    }
}