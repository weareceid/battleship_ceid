import java.util.*;
import java.io.*;

public class Game {
    public static void main(String args[])throws OverlapTilesException,OversizeException,AdjacentTilesException{
       int pon[];
      // pon=getInput();
  // System.out.print(pon[0]+" "+pon[1]);
       Board c=new Board();
        c.placeAllShips(c);
        c.drawboards();
    }


   static int[] getInput(){
        int pin[]=new int[2];
        pin[0]=15;
        pin[1]=15;

     Scanner read=new Scanner(System.in).useDelimiter("\\D*\\D");   // doesn`t read space

while(pin[0]<0 || pin[0]>9 || pin[1]<0 || pin[1]>9) {
    System.out.println("Give two numbers divided by some space between 0 and 9 :");
    pin[0] = read.nextInt();
    pin[1] = read.nextInt();
}
     return pin;
    }

    static int []getRandInput(){
        Random rand=new Random();
        int pin[]=new int[2];
        pin[0]=rand.nextInt(9);
        pin[1]=rand.nextInt(9);
        return pin;
    }
    static char getRandOrientation(){
        Random rand=new Random();
        int r=rand.nextInt(2);
        if(r==0){
            return 'h';
        }
        else return'v';

    }
     boolean randomPlace()throws IOException {
        boolean read = true;

        System.out.println("insert Y or N ");
           char c=(char)System.in.read();
            if(c=='Y'){
                read=true;
            }
            else if(c=='N'){
                read=false;
            }
            return read;
    }
    String getOrientation()throws IOException{
        String s="";
        System.out.println("Give h or v for orientation ");

          char c=(char)System.in.read();
        if(c=='h'){
            s="Orientation.horizontal";
        }
        else if(c=='v'){
            s="Orientation.vertical";
        }
        return s;
    }
}