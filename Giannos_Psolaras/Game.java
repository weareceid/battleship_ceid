import java.util.*;

public class Game{
    public static void main(String args[]){
        Board c=new Board();
      //  Ship p=new Ship();
/*for(int i=0; i<10; i++)
  for(int j=0; j<10; j++){
System.out.println(c.board[i][j].getSymbol());
}
}*/
        //    c.drawboards();
c.placeAllShips(c);
       // p.placeShip(c.board[3][3],'h',c,false);
        c.drawboards();


    }


    static int []getRandInput(){
        Random rand=new Random();
        int pin[]=new int[2];
        pin[0]=rand.nextInt(10);
        pin[1]=rand.nextInt(10);
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
}