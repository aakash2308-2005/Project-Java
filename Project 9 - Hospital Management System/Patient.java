public class Patient{
    private String patientId;
    private String patientName;
    private int age;
    private String gender;
    private String phoneNumber;
    private String address;
    private String bloodGroup;
    private PatientStatus patientStatus =  PatientStatus.OUTPATIENT;
    private Doctor assignedDoctor = null;
    private String admissionInformation = "";

    public Patient(String patientId, String patientName, int age, String gender,
                   String phoneNumber, String address, String bloodGroup) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.age = age;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.bloodGroup = bloodGroup;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public PatientStatus getPatientStatus() {
        return patientStatus;
    }

    public Doctor getAssignedDoctor() {
        return assignedDoctor;
    }

    public String getAdmissionInformation() {
        return admissionInformation;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public void setPatientStatus(PatientStatus patientStatus) {
        this.patientStatus = patientStatus;
    }

    public void setAssignedDoctor(Doctor assignedDoctor) {
        this.assignedDoctor = assignedDoctor;
    }

    public void setAdmissionInformation(String admissionInformation) {
        this.admissionInformation = admissionInformation;
    }

    @Override
    public String toString() {
        return "Patient Id : " + patientId + "\n" + 
            "Patient Name : " + patientName + "\n" +
            "Age : " + age + "\n" +
            "Gender : " + gender + "\n" +
            "Phone Number : " + phoneNumber + "\n" +
            "Address : " + address + "\n" +
            "Blood Group : " + bloodGroup + "\n" +
            "Patient Status : " + patientStatus + "\n" +
            "Assigned Doctor : " + assignedDoctor + "\n" +
            "Admission Information : " + admissionInformation;
    }

}
