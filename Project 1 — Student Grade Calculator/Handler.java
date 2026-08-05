import java.util.ArrayList;
import java.util.List;

public class Handler{
    List<Student> students = new ArrayList<>();
    
    public void addStudent(String studentId, String name, int age, String department, int yearOfStudy){

        for (Student s : students)
        {
            if (s.studentId.equals(studentId))
            {
                System.out.println("Student ID already exists.");
                return;
            }
        }
        Student std = new Student(studentId, name, age, department, yearOfStudy);

        students.add(std);
    }

    public void addSubjectAndMark(String studentId, String subjectName, float marksObtained, float maximumMarks){
        if (marksObtained > maximumMarks || marksObtained < 0){
            System.out.println("Invalid marks");
        } 

        else{
            boolean found = false;
            Subject sub = new Subject(subjectName, marksObtained, maximumMarks);
            for (Student s : students)
            {
                if (s.studentId.equals(studentId))
                {
                    found = true;
                    s.subjects.add(sub);
                    break;
                }
            }

            if (!found)
            {
                System.out.println("Student Id does not exist");
            }

        }

    }

    public void viewStudentReport(String studId){
        System.out.println("========================================\n");
        System.out.println("STUDENT GRADE REPORT\n");
        System.out.println("========================================\n\n\n");
        
        boolean found = false;

        for (Student s : students)
        {
            if (s.studentId.equals(studId))
            {
                System.out.println(s.toString());
                found = true;
                break;
            }
        }
    
        if (!found)
        {
            System.out.println("Invalid Student Id");
        }

    }

    public void viewAllStudents(){
        System.out.println(
            "Student ID    Name\n" + 
            "-------------------------\n"  
        );
        for (Student stud : students)
        {
            System.out.println(stud.studentId+ "            "+ stud.name);
        }
    }


    public void searchStudent(String studId){
        boolean found = false;

        for (Student s : students)
        {
            if (s.studentId.equals(studId))
            {
                System.out.println("Student found");
                viewStudentReport(studId);
                found = true;
                break;
            }
        }

        if (!found)
        {
            System.out.println("Student not found");
        }

    }

    public void viewClassStatistics(){
        int size = students.size();

        if (size == 0)
        {
            System.out.println("No students available.");
            return;
        }
        System.out.println("Total Students: " + size);

        int passed = 0;
        float totalPercentage = 0.0f;
        float topPercentage = 0.0f;
        String topName = "";
        String topStud = "";

        for (Student stud : students)
        {
            if (stud.passed())
            {
                passed += 1;
            }

            float percentage =  stud.percentage();

            if (percentage > topPercentage)
            {
                topPercentage = percentage;
                topName = stud.name;
                topStud = stud.studentId;
            }

            totalPercentage += percentage;  
        }
        System.out.println("Passed: " + passed);
        System.out.println("Failed: " + (size - passed));
        System.out.println("Class Average: " + totalPercentage / size + "%");
        System.out.println("Top Student: " + topStud + "-" + topName);
        System.out.println("Percentage: " + topPercentage +"%");

    }
}
