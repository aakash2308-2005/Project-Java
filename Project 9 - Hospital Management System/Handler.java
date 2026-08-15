import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Handler
{
    Scanner sc;
    public Handler(Scanner sc)
    {
        this.sc = sc;
    }

    private List<Patient> patients = new ArrayList<>();
    private Set<String> patientIds = new HashSet<>();
    private List<Doctor> doctors = new ArrayList<>();
    private Set<String> doctorIds = new HashSet<>();
    private List<Appointment> appointments = new ArrayList<>();
    private Set<String> appointmentIds = new HashSet<>();

    public void registerPatient()
    {
        System.out.println("Enter Patient Id: ");
        String patientId = sc.next();
        sc.nextLine();

        if (patientIds.contains(patientId))
        {
            System.out.println("Patient Id already exists.");
            return;
        }

        System.out.println("Enter Patient Name: ");
        String patientName = sc.nextLine();

        System.out.println("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter Gender: ");
        String gender = sc.next();
        sc.nextLine();

        System.out.println("Enter phone Number: ");
        String phoneNumber = sc.next();
        sc.nextLine();

        System.out.println("Enter Address: ");
        String address = sc.nextLine();

        System.out.println("Enter Blood Group: ");
        String bloodGroup = sc.next();
        sc.nextLine();

        Patient patient = new Patient(patientId, patientName, age, gender, phoneNumber, address, bloodGroup);
        patients.add(patient);
        patientIds.add(patientId);
    }

    public void registerDoctor()
    {
        
        System.out.println("Enter Doctor Id: ");
        String doctorId = sc.next();
        sc.nextLine();

        if (doctorIds.contains(doctorId))
        {
            System.out.println("Doctor Id already exists.");
            return;
        }
        
        System.out.println("Enter Doctor Name: ");
        String doctorName = sc.nextLine();

        System.out.println("Enter Specialization: ");
        String sp = sc.nextLine();
        
        Specialization specialization;

        if (sp.equalsIgnoreCase("CARDIOLOGIST"))
        {
            specialization = Specialization.CARDIOLOGIST;
        }

        else if (sp.equalsIgnoreCase("DERMATOLOGIST"))
        {
            specialization = Specialization.DERMATOLOGIST;
        }

        else if (sp.equalsIgnoreCase("NEUROLOGIST"))
        {
            specialization = Specialization.NEUROLOGIST;
        }

        else if (sp.equalsIgnoreCase("ORTHOPEDIC"))
        {
            specialization = Specialization.ORTHOPEDIC;
        }

        else if (sp.equalsIgnoreCase("PEDIATRICIAN"))
        {
            specialization = Specialization.PEDIATRICIAN;
        }

        else if (sp.equalsIgnoreCase("GENERAL_PHYSICIAN"))
        {
            specialization = Specialization.GENERAL_PHYSICIAN;
        }

        else
        {
            System.out.println("Invalid specialization");
            return;
        }

        System.out.println("Enter phone Number: ");
        String phoneNumber = sc.next();
        sc.nextLine();

        System.out.println("Enter experience: ");
        int experience = sc.nextInt();
        sc.nextLine();

        Doctor doctor = new Doctor(doctorId, doctorName, specialization, phoneNumber, experience);
        doctors.add(doctor);
        doctorIds.add(doctorId);
    }

    public void viewAllPatients()
    {

        if (patients.isEmpty())
        {
            System.out.println("No patients Available");
            return;
        }

        for (Patient patient : patients)
        {
            System.out.println(patient);
        }
    }

    public void viewAllDoctors()
    {
        if (doctors.isEmpty())
        {
            System.out.println("No doctors available.");
            return;
        }

        for (Doctor doctor : doctors)
        {
            System.out.println(doctor);
        }

    }

    public void searchPatient()
    {
        boolean found = false;

        System.out.println("1.Patient Name/2.Patient Id");

        int choice = sc.nextInt();
        sc.nextLine();

        if(choice == 1)
        {
            System.out.println("Enter Patient Name");
            String name = sc.nextLine();
                
            for (Patient patient: patients)
            {
                if (patient.getPatientName().equalsIgnoreCase(name))
                {
                    found = true;
                    System.out.println(patient);
                }
            }
        }

        else if(choice == 2)
        {
            System.out.println("Enter patient Id: ");
            String id = sc.next();
            sc.nextLine();

            for (Patient patient: patients)
            {
                if (patient.getPatientId().equalsIgnoreCase(id))
                {
                    found = true;
                    System.out.println(patient);
                    break;
                }
            }
        }

        if (!found)
        {
            System.out.println("No patient found.");
        }


    }

    public void searchDoctor()
    {
        boolean found = false;

        System.out.println("1. Specialization/2.Doctor Id");
        int choice = sc.nextInt();
        sc.nextLine();
        
        if(choice == 1)
        {
            System.out.println("Enter Specialization: ");
            String sp = sc.next();
            sc.nextLine();
            
            Specialization specialization;

            if (sp.equalsIgnoreCase("CARDIOLOGIST"))
            {
                specialization = Specialization.CARDIOLOGIST;
            }

            else if (sp.equalsIgnoreCase("DERMATOLOGIST"))
            {
                specialization = Specialization.DERMATOLOGIST;
            }

            else if (sp.equalsIgnoreCase("NEUROLOGIST"))
            {
                specialization = Specialization.NEUROLOGIST;
            }

            else if (sp.equalsIgnoreCase("ORTHOPEDIC"))
            {
                specialization = Specialization.ORTHOPEDIC;
            }

            else if (sp.equalsIgnoreCase("PEDIATRICIAN"))
            {
                specialization = Specialization.PEDIATRICIAN;
            }

            else if (sp.equalsIgnoreCase("GENERAL_PHYSICIAN"))
            {
                specialization = Specialization.GENERAL_PHYSICIAN;
            }

            else{
                System.out.println("Invalid Specialization.");
                return;
            }
                
            for (Doctor doctor : doctors)
            {
                if (doctor.getSpecialization() == specialization)
                {
                    found = true;
                    System.out.println(doctor);
                }
            }
        }

        else if(choice == 2)
        {
            System.out.println("Enter doctor Id: ");
            String id = sc.next();
            sc.nextLine();

            for (Doctor doctor : doctors)
            {
                if (doctor.getDoctorID().equalsIgnoreCase(id))
                {
                    found = true;
                    System.out.println(doctor);
                    break;
                }
            }
        }

        if (!found)
        {
            System.out.println("No Doctor found.");
        }
    }

    public void assignPatientToDoctor()
    {
        System.out.println("Enter patient id: ");
        String pId = sc.next();
        sc.nextLine();

        if (patientIds.contains(pId))
        {
            System.out.println("Enter Doctor id: ");
            String dId = sc.next();
            sc.nextLine();
            
            if (doctorIds.contains(dId))
            {
                for (Doctor doctor : doctors)
                {
                    if(doctor.getDoctorID().equals(dId))
                    {
                        if (doctor.getStatus() == DoctorStatus.AVAILABLE)
                        {
                            for (Patient patient : patients)
                            {
                                if(patient.getPatientId().equals(pId))
                                {
                                    if (patient.getAssignedDoctor() == null)
                                    {
                                        patient.setAssignedDoctor(doctor);
                                        patient.setAdmissionInformation("Patient is assigned to " + doctor.getDoctorName());
                                    }
                                    else
                                    {
                                        System.out.println("Patient already has been assigned a doctor.");
                                    }
                                }
                            }

                        }
                        else
                        {
                            System.out.println("Doctor not available");
                        }
                        break;
                    }
                }

            }

            else
            {
                System.out.println("Doctor Id does not exist");
            }
            

        }

        else
        {
            System.out.println("Patient Id does not exist");
        }
    }

    public void bookAppointment()
    {
        System.out.println("Enter patient id: ");
        String pId = sc.next();
        sc.nextLine();

        if (patientIds.contains(pId))
        {
            System.out.println("Enter Doctor id: ");
            String dId = sc.next();
            sc.nextLine();
            
            if (doctorIds.contains(dId))
            {
                for (Doctor doctor : doctors)
                {
                    if(doctor.getDoctorID().equals(dId))
                    {
                        if (doctor.getStatus() == DoctorStatus.AVAILABLE)
                        {
                            for (Patient patient : patients)
                            {
                                if(patient.getPatientId().equals(pId))
                                {
                                    System.out.println("Enter appointment Id: ");
                                    String aId = sc.next();
                                    sc.nextLine();

                                    if (appointmentIds.contains(aId))
                                    {
                                        System.out.println("Appointment Id already exists");
                                        return;
                                    }

                                    System.out.println("Enter appointment date: ");
                                    String date = sc.next();
                                    sc.nextLine();

                                    System.out.println("Enter appointment time: ");
                                    String time = sc.next();
                                    sc.nextLine();

                                    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                                    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
                                    Appointment appointment = new Appointment(aId, patient, doctor, LocalDate.parse(date, dateFormatter), LocalTime.parse(time, timeFormatter), AppointmentStatus.SCHEDULED);
                                    doctor.setStatus(DoctorStatus.BUSY);
                                    appointments.add(appointment);
                                    appointmentIds.add(aId);
                                    
                                }
                            }

                        }
                        else
                        {
                            System.out.println("Doctor not available");
                        }
                        break;
                    }
                }

            }

            else
            {
                System.out.println("Doctor Id does not exist");
            }
            

        }

        else
        {
            System.out.println("Patient Id does not exist");
        }
    }


    public void admitPatient()
    {
        System.out.println("Enter patient id: ");
        String pId = sc.next();
        sc.nextLine();
        boolean found = false;

        for (Patient patient : patients)
        {
            if (patient.getPatientId().equals(pId))
            {
                found = true;
                if(patient.getPatientStatus() == PatientStatus.ADMITTED)
                {
                    System.out.println("Already Admitted.");
                    return;
                }
                else
                {
                    System.out.println("Patient Admitted.");
                    patient.setPatientStatus(PatientStatus.ADMITTED);
                }
            }
        }

        if (!found)
        {
            System.out.println("Patient Id does not exist.");
            return;
        }

    }

    public void dischargePatient()
    {
        System.out.println("Enter patient id: ");
        String pId = sc.next();
        sc.nextLine();
        boolean found = false;

        for (Patient patient : patients)
        {
            if (patient.getPatientId().equals(pId))
            {
                found = true;
                if(patient.getPatientStatus() == PatientStatus.ADMITTED)
                {
                    System.out.println("Patient Discharged.");
                    patient.setPatientStatus(PatientStatus.DISCHARGED);
                }
                else
                {
                    System.out.println("Patient not admitted.");
                    return;
                }
            }
        }

        if (!found)
        {
            System.out.println("Patient Id does not exist.");
            return;
        }
    }

    public void viewPatientDetails()
    {
        boolean found = false;
        System.out.println("Enter patient id: ");
        String pId = sc.next();
        sc.nextLine();

        for (Patient patient :patients)
        {
            if(patient.getPatientId().equals(pId))
            {
                found = true;
                System.out.println(patient);
                break;
            }
        }

        if (!found)
        {
            System.out.println("Patient not available");
        }
    }

    public void viewHospitalStatistics()
    {
        System.out.println("========== HOSPITAL STATISTICS ==========");

        int totalPatients = patients.size();

        int admittedPatients = 0;
        int dischargedPatients = 0;
        int outPatient = 0;

        for (Patient patient : patients)
        {
            if (patient.getPatientStatus() == PatientStatus.ADMITTED)
            {
                admittedPatients += 1;
            }

            else if (patient.getPatientStatus() == PatientStatus.DISCHARGED)
            {
                dischargedPatients += 1;
            }

            else if (patient.getPatientStatus() == PatientStatus.OUTPATIENT)
            {
                outPatient += 1;
            }
        }

        System.out.println(
            "Total Patients       : " + totalPatients + "\n" +
            "Admitted Patients    : " + admittedPatients + "\n" + 
            "Discharged Patients  : " + dischargedPatients + "\n" +
            "Outpatients          : " + outPatient);

        int totalDoctors = doctors.size();

        int availableDoctors = 0;
        int busyDoctors = 0;
        int offDutyDoctors = 0;

        for (Doctor doctor : doctors)
        {
            if (doctor.getStatus() == DoctorStatus.AVAILABLE)
            {
                availableDoctors += 1;
            }

            else if (doctor.getStatus() == DoctorStatus.BUSY)
            {
                busyDoctors += 1;
            }

            else if (doctor.getStatus() == DoctorStatus.OFFDUTY)
            {
                offDutyDoctors += 1;
            }
        }

        System.out.println(
            "Total Doctors       : " + totalDoctors + "\n" +
            "Available Doctors   : " + availableDoctors + "\n" + 
            "Busy Doctors        : " + busyDoctors + "\n" +
            "Off Duty Doctors    : " + offDutyDoctors);

        int totalAppointments = appointments.size();

        int scheduled = 0;
        int completed = 0;
        int cancelled = 0;

        for (Appointment appointment : appointments)
        {
            if (appointment.getAppointmentStatus() == AppointmentStatus.SCHEDULED)
            {
                scheduled += 1;
            }

            else if (appointment.getAppointmentStatus() == AppointmentStatus.COMPLETED)
            {
                completed += 1;
            }

            else if (appointment.getAppointmentStatus() == AppointmentStatus.CANCELLED)
            {
                cancelled += 1;
            }

        }

        System.out.println(
            "Total Appointments   : " + totalAppointments + "\n" +
            "Scheduled            : " + scheduled + "\n" + 
            "Completed            : " + completed + "\n" + 
            "Cancelled            : " + cancelled + "\n"
            );
    }

    public void manageAppointment()
    {
        System.out.println("Enter appointment Id: ");
        String aId = sc.next();
        sc.nextLine();
        boolean found = false;

        for (Appointment appointment : appointments)
        {
            if (appointment.getAppointmentId().equals(aId))
            {
                found = true;
                System.out.println("1. Complete Appointment\n2. Cancel Appointment");
                int choice = sc.nextInt();
                sc.nextLine();

                if (choice == 1)
                {
                    if (appointment.getAppointmentStatus() != AppointmentStatus.COMPLETED && appointment.getAppointmentStatus() != AppointmentStatus.CANCELLED)
                    {
                        System.out.println("Appointment completed");
                        appointment.setAppointmentStatus(AppointmentStatus.COMPLETED);
                        appointment.getDoctor().setStatus(DoctorStatus.AVAILABLE);
                    }
                    else
                    {
                        System.out.println("Appointment cannot be modified.");
                        return;
                    }
                }

                else if(choice == 2)
                {
                    if (appointment.getAppointmentStatus() != AppointmentStatus.CANCELLED && appointment.getAppointmentStatus() != AppointmentStatus.COMPLETED)
                    {
                        System.out.println("Appointment cancelled");
                        appointment.setAppointmentStatus(AppointmentStatus.CANCELLED);
                        appointment.getDoctor().setStatus(DoctorStatus.AVAILABLE);
                    }
                    else
                    {
                        System.out.println("Appointment cannot be modified.");
                        return;
                    }

                }
                break;
            }
        }

        if (!found)
        {
            System.out.println("Appointment not found.");
        }
    }
}