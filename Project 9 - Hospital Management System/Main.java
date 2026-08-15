import java.util.Scanner;


class Main{
    public static void main(String args[])
    {
        boolean stop = false;
        Scanner sc = new Scanner(System.in);
        Handler handler = new Handler(sc);

        while (!stop)
        {
            System.out.println(
                "\n\n========== HOSPITAL MANAGEMENT SYSTEM ==========\n" +
                "1. Register Patient\n" + 
                "2. Register Doctor\n" +
                "3. View All Patients\n" + 
                "4. View All Doctors\n" + 
                "5. Search Patient\n" + 
                "6. Search Doctor\n" + 
                "7. Assign Patient to Doctor\n" +
                "8. Book Appointment\n" + 
                "9. Admit Patient\n" + 
                "10. Discharge Patient\n" + 
                "11. View Patient Details\n" + 
                "12. View Hospital Statistics\n" +
                "13. Manage Appointment\n"  +     
                "14. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice)
            {
                case 1:
                    handler.registerPatient();
                    break;

                case 2:
                    handler.registerDoctor();
                    break;

                case 3:
                    handler.viewAllPatients();
                    break;

                case 4:
                    handler.viewAllDoctors();
                    break;

                case 5:
                    handler.searchPatient();
                    break;

                case 6:
                    handler.searchDoctor();
                    break;

                case 7:
                    handler.assignPatientToDoctor();
                    break;

                case 8:
                    handler.bookAppointment();
                    break;

                case 9:
                    handler.admitPatient();
                    break;

                case 10:
                    handler.dischargePatient();
                    break;

                case 11:
                    handler.viewPatientDetails();
                    break;

                case 12:
                    handler.viewHospitalStatistics();
                    break;

                case 13:
                    handler.manageAppointment();
                    break;

                case 14:
                    stop = true;
                    System.out.println("Good Bye!");
                    break;

                default:
                    System.out.println("Invalid Choice !");
                    break;
            }
        }
    }
}