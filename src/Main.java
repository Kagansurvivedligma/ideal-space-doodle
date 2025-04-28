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
    static Teacher mrsReyes = new Teacher(2, 50, "Mrs.Arrayes", "Honors Precalculus", 7, "R04");
    static int x;
    
    public static void main(String[] args) throws Exception { 
        ArrayList<Teacher> Teachers = new ArrayList<Teacher>();
        ArrayList<Teacher> holdTeachers = new ArrayList<Teacher>();
        Teachers.add(mrThai);
        Teachers.add(mrMurphy);
        Teachers.add(mrRaman);
        Teachers.add(mrRa);
        Teachers.add(mrsAnderson);
        Teachers.add(mrsMarek);
        Teachers.add(mrsReyes);
    Collections.shuffle(Teachers);    
        while(Teachers.size() > 6){
            Teachers.remove(Teachers.size()-1);
        }
   
        int place = 0;
         String userRespLow  = "";
         while(checkExit(userRespLow) == true){ 
          userRespLow = askQuestions();
          play(Teachers, userRespLow);
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
        
    

public static void play(ArrayList<Teacher> Teachers, String userRespLow){
    if(x == 0){
        System.out.println("Welcome to Amador Valley, here is your class schedule:");
        for(int i = 0; i<Teachers.size(); i++){
            System.out.println(Teachers.get(i).getName());
        }

        System.out.println("Where would you like to go?");
        System.out.println("[1]" + Teachers.get(0).getName());
          if(userRespLow.contains("2")){
            x =2;
        }System.out.println("[2]" + " Leave School");
        x=1;
    }
    if(x==1){
     
    if(x==2){
        System.out.println("Mr Raman caught you. You have entered a battle with Mr Raman. Answer his questions and survive. Are you ready?");
        System.out.println("[1] no");
       System.out.println("[2] yes");
    }   System.out.println("You have gone to " + Teachers.get(0) + "class");
        System.out.println(Teachers.get(0).toString());
    }
}
 
}

