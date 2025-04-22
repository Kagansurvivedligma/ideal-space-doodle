import java.util.ArrayList;
public class People{
    private int height;
    private int IQ;
    private String name;

    public People(){
        height = 60;
        IQ = 1;
        name = "???";

    }

    public People(int height, int IQ, String name){
        this.height = height;
        this.IQ = IQ;
        this.name = name;
    }
    public int getHeight(){
        return height;
    }
    public void setHeight(int height){
        this.height = height;
    }
    public int getIQ(){
        return IQ;
    }
    public void setIQ(int IQ){
        this.IQ = IQ;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String toString(){
        return "Hi, my name is " + getName() + ", I am " + getHeight() + " inches tall, and my IQ is " + getIQ() + ".";
    }
}


