import java.util.*;
import java.io.*;

public class Game {

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
     boolean randomPlace()throws IOException {
        boolean read = true;

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
    public static void main(String[] args){


            //Scanners
            Scan scname = new Scan(System.in);

            //Creating Player 
            String name = scname.nextLine(); //Player gives his own name
            Player user= new Player(name);

            //Creating Bot
            Player bot = new Player("bot");

            bot.placeAllShips();

            while(randomPlace()){

                    user.placeAllShips(user.getPlayerBoard());
                    user.drawboards();
                    break;

                    }

            int[] coordin = new int[2];
            coordin=user.getInput();

            Tile tileplaceship = new Tile(coordin[0] , coordin[1] , Tile.TileType.SHIP);

            user.placeShip(tileplaceship, user.getOrientation() , user.getPlayerBoard,false);
            

            while(!AllShipsSunk()){
                    coordin = user.getInput();
                    user.fire(user.getPlayerBoard() , coordin);
                    
                    coordin = bot.getRandInput();
                    bot.fire(bot.getPlayerBoard() , coordin);

                    user.drawboards();
            

            }

            if(user.countHits==17){

                    System.out.prinln(user.name + " is the WINNER!! " );
                    user.getStats();
            }
            else if (bot.countHits == 17) {
                    System.out.prinln( "Bot is the WINNER!! " );
                    bot.getStats();
            }
            }

}