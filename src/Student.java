import java.util.ArrayList;

public class Student extends People {
    private String grade;
    private double GPA;
    private ArrayList<String> schedule;

    public Student(int height, int IQ, String name, String grade, double GPA) {
        super(height, IQ, name);
        this.grade = grade;
        this.GPA = GPA;

    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getGPA() {
        return GPA;
    }

    public String getRoundedGPA() {
        return "%.2f".formatted(GPA);
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public ArrayList<String> getSchedule() {
        return schedule;
    }
}