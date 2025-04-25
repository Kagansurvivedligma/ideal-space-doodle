import java.util.ArrayList;
public class Teacher extends People{
    private ArrayList<String> questions;
    private String subject;
    private int ID;
    private String classroom;
    
public Teacher(int height, int IQ, String name, String subject, int ID, String classroom){
    super(height, IQ, name);
    this.subject = subject;
    this.ID = ID;
    this.classroom = classroom;

    
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
    return "Hi, i am" + getName() + ", and i teach " + getSubject();
}

}