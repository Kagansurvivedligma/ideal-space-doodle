import java.lang.reflect.Array;
import java.util.ArrayList;
public class Teacher extends People{
    private ArrayList<Questions> x = new ArrayList<Questions>();
    private String subject;
    private int ID;
    private String classroom;
    private String coreSubject;
    
    
public Teacher(int height, int IQ, String name, String subject, int ID, String classroom, ArrayList<Questions> x, String coresubject){
    super(height, IQ, name);
    this.subject = subject;
    this.ID = ID;
    this.classroom = classroom;
    this.x = x;
    this.coreSubject = coresubject;

    
}
public String getSubject(){
    return subject;
}
public int getID(){
    return ID;
}
public String getClassroom(){
    return classroom;
}

public String toString(){
    return "Hi, I am " + getName() + ", and I teach " + getSubject();


}
public ArrayList<Questions> getArrayList(){
    return x;

}
}