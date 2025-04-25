import java.util.ArrayList;
public class Student extends People{
    private String grade;
    private double GPA;
    private ArrayList<String> schedule;

    public Student(int height, int IQ, String name, String grade, double GPA, ArrayList<String> schedule){
        super(height, IQ, name);
        this.grade = grade;
        this.GPA = GPA;
        this.schedule = schedule;
    }
    public String getGrade(){
        return grade;
    }
    public void setGrade(String grade){
        this.grade = grade;
    }
    public double getGPA(){
        return GPA;
    }
    public void setGPA(double GPA){
        this.GPA = GPA;
    }
    public ArrayList<String> getSchedule(){
        return schedule;
    }
  
}