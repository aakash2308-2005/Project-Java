import java.util.ArrayList;
import java.util.List;

public class Student{
    public String studentId;
    public String name;
    public int age;
    public String department;
    public int yearOfStudy;
    public List<Subject> subjects = new ArrayList<>();

    public Student(String studentId, String name, int age, String department, int yearOfStudy)
    {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.department = department;
        this.yearOfStudy = yearOfStudy;
    }

    public String total(){
        float marks = 0.0f;
        float total = 0.0f;

        for (Subject sub : subjects)
        {
            marks += sub.marksObtained;
            total += sub.maximumMarks;
        }

        return marks + "/" + total;
    }


    public float percentage(){

        int subSize = subjects.size();

        if (subSize == 0)
        {
            return 0.0f;
        }

        else{
            float marks = 0.0f;
            float total = 0.0f;

            for (Subject sub : subjects)
            {
                marks += sub.marksObtained;
                total += sub.maximumMarks;
            }   

            return (marks / total) * 100;
        }
    }

    public String grade(){
        float average = percentage();

        if (average >= 90.0){
            return "A+";
        }

        else if (average >= 80.0){
            return "A";
        }

        else if (average >= 70.0){
            return "B";
        }

        else if (average >= 60.0){
            return "C";
        }

        else if (average >= 50.0){
            return "D";
        }

        else if (average >= 40.0){
            return "E";
        }

        else {
            return "F";
        }
    }

    public boolean passed(){

        if (subjects.size() == 0)
        {
            return false;
        }


        for (Subject sub : subjects)
        {
            float mark = sub.marksObtained;
            float total = sub.maximumMarks;

            if ((mark / total) * 100.0 < 40)
            {
                return false;
            }
        }

        return true;
    }

    @Override
    public String toString(){

        String report = "Student ID   : "+ studentId + "\n" + 
                        "Name         : "+ name + "\n" +
                        "Age          : "+ age +"\n" +
                        "Department   : "+ department+ "\n" +
                        "Year         : "+ yearOfStudy +"\n\n\n" + 
                        "----------------------------------------" +
                        "Subject       Marks\n" + 
                        "----------------------------------------\n";
        
        for (Subject sub : subjects)
        {
            report += sub.subjectName + "          "+ sub.marksObtained+ "/" +sub.maximumMarks + "\n";

        }

        report += 
            "\n\n\n----------------------------------------\n"+
            "Total         : "+ total() + "\n" +
            "Percentage    : "+ percentage() + "%\n" +
            "Grade         : "+ grade() + "\n" + 
            "Result        : " + (passed() ? "PASS" : "FAIL") +"\n\n" + 
            "========================================";
           
        return report;
    }

}