public class Doctor{
    private String doctorID;
    private String doctorName;
    private Specialization specialization;
    private String phoneNumber;
    private int experience;
    private DoctorStatus status = DoctorStatus.AVAILABLE;

    public Doctor(String doctorID, String doctorName, Specialization specialization,
                  String phoneNumber, int experience) {
        this.doctorID = doctorID;
        this.doctorName = doctorName;
        this.specialization = specialization;
        this.phoneNumber = phoneNumber;
        this.experience = experience;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getExperience() {
        return experience;
    }

    public DoctorStatus getStatus() {
        return status;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setStatus(DoctorStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorID='" + doctorID + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", specialization=" + specialization +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", experience=" + experience +
                ", status=" + status +
                '}';
    }
}