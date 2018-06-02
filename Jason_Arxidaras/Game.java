import java.util.*;
import java.io.*;

public class Game {

     static int[] getInput(){
        int pin[]=new int[2];
        pin[0]=15;
        pin[1]=15;

        Scanner read=new Scanner(System.in).useDelimiter("\\D*\\D");   // doesn't read space

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

    public static char getRandOrientation(){
        Random rand=new Random();
        int r=rand.nextInt(2);
        if(r==0){
            return 'h';
        }
        else return'v';

    }

    static boolean randomPlace()throws IOException {
        boolean read = true;

        //try {
                char c = (char) System.in.read();
                if (c == 'Y') {
                    read = true;
                } else if (c == 'N') {
                read = false;
            }
        //} catch (IOException exc) {}
        return read;
    }

    static char getOrientation()throws IOException{
        char s=' ';
        System.out.println("Give h or v for orientation ");

        char c=(char)System.in.read();
        if(c=='h'){
            s= 'h' ;
        }
        else if(c=='v'){
            s= 'v' ;
        }
        return s;
    }

    /* ------ M A I N ------- M A I N ------ M A I N ------- M A I N ------ M A I N ------ M A I N ------- M A I N ------ M A I N ------- M A I N ------ M A I N ------ M A I N ------- M A I N -------- */
    public static void main(String[] args)throws OverlapTilesException, OversizeException, AdjacentTilesException, IOException{


        //Scanners
        Scanner scanName = new Scanner(System.in);

        //Creating Ships
        Battleship battleship = new Battleship();
        Carrier carrier = new Carrier();
        Cruiser cruiser = new Cruiser();
        Destroyer destroyer = new Destroyer();
        Submarine submarine = new Submarine();

        //Creating Player
        System.out.println("Give your username!");
        String name = scanName.nextLine(); //Player gives his own name
        Player user= new Player(name);

        //Creating Bot
        Player bot = new Player("bot");

        //bot.placeAllShips(bot.getPlayerBoard());

        /*while(randomPlace()) {

            user.placeAllShips(user.getPlayerBoard());
            user.getPlayerBoard().drawboards();
            break;

        }*/

        int[] coordin = new int[2];

        //Placement of Battleship
        System.out.println("Give coordinates for your Battleship.(First integer for y, second integer for x)");
        coordin = Game.getInput();
        Tile tilePlaceBattleship = new Tile(coordin[1] , coordin[0] , Tile.TileType.SHIP);
        System.out.println("Give orientation ('h' for horizontal and 'v' for vertical: ");
        char orientBattleship =  Game.getOrientation();
        user.placeShip(battleship ,tilePlaceBattleship, orientBattleship , user.getPlayerBoard(),false);

        //Placement of Carrier
        System.out.println("Give coordinates for your Carrier.(First integer for y, second integer for x)");
        coordin = Game.getInput();
        Tile tilePlaceCarrier = new Tile(coordin[1] , coordin[0] , Tile.TileType.SHIP);
        System.out.println("Give orientation ('h' for horizontal and 'v' for vertical: ");
        char orientCarrier =  Game.getOrientation();
        user.placeShip(carrier ,tilePlaceCarrier, orientCarrier , user.getPlayerBoard(),false);

        //Placement of Cruiser
        System.out.println("Give coordinates for your Cruiser.(First integer for y, second integer for x)");
        coordin = Game.getInput();
        Tile tilePlaceCruiser = new Tile(coordin[1] , coordin[0] , Tile.TileType.SHIP);
        System.out.println("Give orientation ('h' for horizontal and 'v' for vertical: ");
        char orientCruiser =  Game.getOrientation();
        user.placeShip(cruiser ,tilePlaceCruiser, orientCruiser , user.getPlayerBoard(),false);

        //Placement of Destroyer
        System.out.println("Give coordinates for your Destroyer.(First integer for y, second integer for x)");
        coordin = Game.getInput();
        Tile tilePlaceDestroyer = new Tile(coordin[1] , coordin[0] , Tile.TileType.SHIP);
        System.out.println("Give orientation ('h' for horizontal and 'v' for vertical: ");
        char orientDestroyer =  Game.getOrientation();
        user.placeShip(destroyer ,tilePlaceDestroyer, orientDestroyer , user.getPlayerBoard(),false);

        //Placement of Submarine
        System.out.println("Give coordinates for your Submarine.(First integer for y, second integer for x)");
        coordin = Game.getInput();
        Tile tilePlaceSubmarine = new Tile(coordin[1] , coordin[0] , Tile.TileType.SHIP);
        System.out.println("Give orientation ('h' for horizontal and 'v' for vertical: ");
        char orientSubmarine =  Game.getOrientation();
        user.placeShip(submarine ,tilePlaceSubmarine, orientSubmarine , user.getPlayerBoard(),false);


        while(!user.getPlayerBoard().allShipsSunk() || !bot.getPlayerBoard().allShipsSunk()){    //If either of them loses the game is over
            System.out.println("Give coordinates for firing: ");
            coordin = Game.getInput();
            user.fire(user.getPlayerBoard() , coordin);

            coordin = Game.getRandInput();
            bot.fire(bot.getPlayerBoard() , coordin);

            user.getPlayerBoard().drawboards();


        }

        if(user.getCountHit()==17){

            System.out.println(user.getName() + " is the WINNER!! " );
            user.getStats();
        }
        else if (bot.getCountHit() == 17) {
            System.out.println( "Bot is the WINNER!! " );
            bot.getStats();
        }
    }

}
