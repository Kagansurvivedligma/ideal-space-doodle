import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

       // People kagan = new People(70, 190, "Kagan");
               //System.out.println(kagan.toString());


public class Main {
    static Teacher mrThai = new Teacher(84, 202, "Mr.Tie", "AP Computer Science", 1, "R211");
    static Teacher mrMurphy = new Teacher(81, 189, "Mr.Merfie", "AP World History", 2, "Q202");
    static Teacher mrRaman = new Teacher(100, 300, "Mr.Ramen", "Final BOss",3, "everywhere");
    static Teacher mrRa = new Teacher(12, 20, "Mr.Raah", "Engineering", 4, "D2");
    static Teacher mrsAnderson = new Teacher(67, 249, "Mrs.Ambersun", "AP World History", 5, "Q104");
    static Teacher mrsMarek = new Teacher(53, 400, "Mrs.Marick", "Honors Freshman English", 6, "none");
    static Teacher mrsReyes = new Teacher(2, 50, "Mrs.Raeis", "Honors Precalculus", 7, "R04");
    static ArrayList<Teacher> Teachers = new ArrayList<Teacher>();
   
    
    public static void main(String[] args) throws Exception { 
        ArrayList<Teacher> Teachers = new ArrayList<Teacher>();
        ArrayList<Teacher> holdTeachers = new ArrayList<Teacher>();
        holdTeachers.add()
    classSchedule(Teachers);;
    Collections.shuffle(Teachers);    
    for(int x = 0; x < 7; x++) {
            Teachers.add((int)(Math.random()*Teachers.size()));
    } 
        int place = 0;
         String userRespLow  = "";
         while(checkExit(userRespLow) == true){ 
          userRespLow = askQuestions();
          play(place);
         }
    }
   
    public static String askQuestions() {
                 Scanner in = new Scanner(System.in);// Creates scanner object.
                 String userRespLow = "";
                  userRespLow = in.nextLine().toLowerCase();
                 return userRespLow;
}
public static boolean checkExit(String response){
    if(response.contains("0")){
        return false;
    }else{
        return true;
    }

}
public static void classSchedule(ArrayList<Teacher> og){
    // ArrayList<Integer> numbers = new ArrayList <Integer>();
    // ArrayList<Teacher> holder = new ArrayList<Teacher>();
    // for(int i = 1; i < og.size(); i++){
    //     numbers.add(i);
    // }
    // for(int j = 0; j<og.size();j++){
    //     int currentNum = (int)(Math.random()*numbers.size());
    //     for(int l = 0; l<og.size(); l++){
    //         if(numbers.get(currentNum) == og.get(l).getID()){
    //             holder.add(og.get(l));
    //             numbers.remove(currentNum);
    //         }
            
    //     }
    // }
    // og = holder;
    }
        
    

public static void play(int x){
    if(x == 0){
        System.out.println("Welcome to Amador Valley, here is your class schedule: \n");
        for(int i = 0; i<Teachers.size(); i++){
            System.out.println(Teachers.get(i).getName());
        }
    }
}
 
}
