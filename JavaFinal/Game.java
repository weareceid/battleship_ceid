import java.util.*;
import java.io.*;


public class Game {

    public static void main(String[] args) throws OverlapTilesException, OversizeException, AdjacentTilesException, IOException{
            //Scanners
            Scanner scname = new Scanner(System.in);

            //Creating Player 
            System.out.println("Creators: Tsakonas Konstantinos , Charalampous Ioannis , Pavlakis Iason-Georgios");
            System.out.println("Let us know your name fella: ");
            String name = scname.nextLine(); //Player gives his own name
            Player User= new Player(name);
            //Creating Bot
            Player Comp = new Player("bot");



        System.out.println( name + ", Would you want to place ships randomly (Y/N)? ");
        int pin[] = new int[2];

        if (randomPlace()) {
            User.placeAllShips();
            Comp.placeAllShips();
        } else {
            int cor[] = new int[2];
            boolean FLAG;

            //Creatin Ships Objects

            System.out.println("Give coordinates X Y for Carrier (size 5)");
            cor = Game.getInput();
            Carrier Ca = new Carrier(5, Game.getOrientation(), cor);
            FLAG = User.placeShip(Ca);
            Board.drawboards(User.getPlayerBoard().getBoard(), Comp.getPlayerBoard().getBoard());

            System.out.println("Give coordinates X Y for Battleship (size 4)");
            cor = Game.getInput();
            Battleship Ba = new Battleship(4, Game.getOrientation(), cor);
            FLAG = User.placeShip(Ba);
            Board.drawboards(User.getPlayerBoard().getBoard(), Comp.getPlayerBoard().getBoard());

            System.out.println("Give coordinates X Y for Cruiser (size 3)");
            cor = Game.getInput();
            Cruiser Cr = new Cruiser(3, Game.getOrientation(), cor);
            FLAG = User.placeShip(Cr);
            Board.drawboards(User.getPlayerBoard().getBoard(), Comp.getPlayerBoard().getBoard());

            System.out.println("Give coordinates X Y for Destroyer (size 2)");
            cor = Game.getInput();
            Destroyer De = new Destroyer(2, Game.getOrientation(), cor);
            FLAG = User.placeShip(De);
            Board.drawboards(User.getPlayerBoard().getBoard(), Comp.getPlayerBoard().getBoard());

            System.out.println("Give coordinates X Y for Submarine (size 3)");
            cor = Game.getInput();
            Submarine Su = new Submarine(3, Game.getOrientation(), cor);
            FLAG = User.placeShip(Su);

            Comp.placeAllShips();

        }
        Board.drawboards(User.getPlayerBoard().getBoard(), Comp.getPlayerBoard().getBoard());

        boolean FLAG = true;
        System.out.println("--------------------LET THE GAME BEGIN-----------------");
        do {
            System.out.println("FIREEEEE!!! (Give coordinates X Y : )");
            Comp.getPlayerBoard().setBoard(User.fire(Comp.getPlayerBoard().getBoard(), getInput()));
            User.getPlayerBoard().setBoard(Comp.fire(User.getPlayerBoard().getBoard(), getRandInput()));
            Board.drawboards(User.getPlayerBoard().getBoard(), Comp.getPlayerBoard().getBoard());

            if (Comp.getPlayerBoard().allShipsSunk()) {
                System.out.println("You Won !");
                FLAG = false;
            } else if (User.getPlayerBoard().allShipsSunk()) {
                System.out.println("Game Over !");
            }

        } while (FLAG);

        Comp.getStats();
        User.getStats();

    }


    //Coordinates input
    static int[] getInput() {
        int pin[] = new int[2];
        pin[0] = 15;
        pin[1] = 15;

        Scanner read = new Scanner(System.in).useDelimiter("\\D*\\D");   // doesn`t read space

        while (pin[0] < 0 || pin[0] > 9 || pin[1] < 0 || pin[1] > 9) {
            System.out.println("Give two numbers divided by some space between 0 and 9 :");
            pin[0] = read.nextInt();
            pin[1] = read.nextInt();
        }
        return pin;
    }

    // random coordinance
    static int[] getRandInput() {
        Random rand = new Random();
        int pin[] = new int[2];
        pin[0] = rand.nextInt(10);
        pin[1] = rand.nextInt(10);
        return pin;
    }

    //Random orientation input
    static char getRandOrientation() {
        Random rand = new Random();
        int r = rand.nextInt(2);
        if (r == 0) {
            return 'h';
        } else return 'v';

    }

    //Random placement decision
    static boolean randomPlace() throws IOException {
        boolean read = true;

            Scanner sc = new Scanner(System.in); 
        char c = sc.next().charAt(0);
        //char c = (char) System.in.read();
        if (c == 'Y') {
            read = true;
        } else if (c == 'N') {
            read = false;
        }
        return read;
    }

    //Orientation Input
    static char getOrientation()throws IOException{
            System.out.println("Give h(horizontal) or v(vertical) for orientation ");
        char s=' ';

        char c=(char)System.in.read();
        if(c=='h'){
            s= 'h' ;
        }
        else if(c=='v'){
            s= 'v' ;
        }
        return s;
    }
}
