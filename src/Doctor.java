import java.util.*;

public class Doctor extends Person {
    private String specialty;
    private Map<Date, Appointment> appointments;

    public Doctor(String lastName, String firstName, String CNP, String specialty) {
        super(lastName, firstName, CNP);
        this.specialty = specialty;
        this.appointments = new HashMap<>();
    }

    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }

    public Map<Date, Appointment> getAppointments() {
        return appointments;
    }

    public boolean addAppointment(Appointment appointment) {
        for (Appointment existingAppointment : appointments.values()) {
            if (existingAppointment.overlapsWith(appointment)) {
                System.out.println("Appointment conflicts with an existing appointment.");
                return false;
            }
        }
        appointments.put(appointment.getAppointmentDate(), appointment);
        return true;
    }

    public List<Date> getUpcomingAppointments() {
        List<Date> upcoming = new ArrayList<>(appointments.keySet());
        Collections.sort(upcoming);
        return upcoming.size() > 10 ? upcoming.subList(0, 10) : upcoming;
    }

    public Map<Date, Appointment> getWeeklyCalendar(Date startOfWeek) {
        Map<Date, Appointment> weekSchedule = new TreeMap<>();
        for (Map.Entry<Date, Appointment> entry : appointments.entrySet()) {
            if (isInWeek(entry.getKey(), startOfWeek)) {
                weekSchedule.put(entry.getKey(), entry.getValue());
            }
        }
        return weekSchedule;
    }

    private boolean isInWeek(Date date, Date startOfWeek) {
        // Implement logic to check if date is within the same week as startOfWeek
        return true; // Simplified for the example
    }
}
