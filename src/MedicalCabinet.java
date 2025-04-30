import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

class MedicalCabinet {
    private final List<Patient> patients;
    private final List<Doctor> doctors;

    public MedicalCabinet() {
        patients = new ArrayList<>();
        doctors = new ArrayList<>();
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void removePatient(Patient patient) {
        patients.remove(patient);
    }

    public void modifyPatient(Patient oldPatient, Patient newPatient) {
        int index = patients.indexOf(oldPatient);
        if (index != -1) {
            patients.set(index, newPatient);
        }
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void removeDoctor(Doctor doctor) {
        doctors.remove(doctor);
    }

    public void modifyDoctor(Doctor oldDoctor, Doctor newDoctor) {
        int index = doctors.indexOf(oldDoctor);
        if (index != -1) {
            doctors.set(index, newDoctor);
        }
    }

    public Doctor findDoctorByName(String name) {
        for (Doctor doctor : doctors) {
            if (doctor.getName().equalsIgnoreCase(name)) {
                return doctor;
            }
        }
        return null;
    }

    public Patient findPatientByName(String name) {
        for (Patient patient : patients) {
            if (patient.getName().equalsIgnoreCase(name)) {
                return patient;
            }
        }
        return null;
    }

    public void displayDoctorAppointments(String doctorName) {
        Doctor doctor = findDoctorByName(doctorName);
        if (doctor != null) {
            List<Date> upcomingAppointments = doctor.getUpcomingAppointments();
            for (Date date : upcomingAppointments) {
                System.out.println("Appointment on " + date);
            }
        } else {
            System.out.println("Doctor not found.");
        }
    }

    public void displayDoctorWeeklyCalendar(String doctorName, Date startOfWeek) {
        Doctor doctor = findDoctorByName(doctorName);
        if (doctor != null) {
            Map<Date, Appointment> weekSchedule = doctor.getWeeklyCalendar(startOfWeek);
            for (Map.Entry<Date, Appointment> entry : weekSchedule.entrySet()) {
                System.out.println("Date: " + entry.getKey());
            }
        } else {
            System.out.println("Doctor not found.");
        }
    }
}