import java.util.*;

class Appointment {
    private Doctor doctor;
    private Patient patient;
    private Date appointmentDate; // Includes both date and time
    private int durationInMinutes; // Duration in minutes (default 60 minutes)

    public Appointment(Doctor doctor, Patient patient, Date appointmentDate) {
        this.doctor = doctor;
        this.patient = patient;
        this.appointmentDate = appointmentDate;
        this.durationInMinutes = 60;  // Default duration for a consultation
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    // Check if this appointment overlaps with another (same doctor)
    public boolean overlapsWith(Appointment other) {
        long thisStart = appointmentDate.getTime();
        long thisEnd = thisStart + durationInMinutes * 60 * 1000L; // Convert to milliseconds
        long otherStart = other.getAppointmentDate().getTime();
        long otherEnd = otherStart + other.getDurationInMinutes() * 60 * 1000L;

        return (thisStart < otherEnd && thisEnd > otherStart); // If times overlap
    }
}