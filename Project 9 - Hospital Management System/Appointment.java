import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {

    private String appointmentId;
    private Patient patient;
    private Doctor doctor;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private AppointmentStatus appointmentStatus;

    public Appointment(String appointmentId, Patient patient, Doctor doctor,
                       LocalDate appointmentDate, LocalTime appointmentTime,
                       AppointmentStatus appointmentStatus) {
        this.appointmentId = appointmentId;
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.appointmentStatus = appointmentStatus;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }

    public AppointmentStatus getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public void setAppointmentTime(LocalTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    @Override
    public String toString() {
        return "Appointment Id : " + appointmentId + "\n" +
               "Patient : " + patient.getPatientName() + "\n" +
               "Doctor : " + doctor.getDoctorName() + "\n" +
               "Date : " + appointmentDate + "\n" +
               "Time : " + appointmentTime + "\n" +
               "Status : " + appointmentStatus;
    }
}