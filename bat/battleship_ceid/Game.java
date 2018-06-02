import java.util.*;
import java.io.*;


public class Game {

    public static void main(String args[]) throws OverlapTilesException, OversizeException, AdjacentTilesException, IOException{
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        Player User = new Player("Player");
        Player Comp = new Player("Bot");

        System.out.println("Do you want to place your ships randomly or manually ? Press Y for randomly placement and N for manually placement : ");
        int pin[] = new int[2];

        if (randomPlace()) {
            User.placeAllShips();
            Comp.placeAllShips();
        } else {
            int cor[] = new int[2];
            boolean check;

            System.out.println("Give coordinates X Y for Carrier (size 5");
            cor = Game.getInput();
            Carrier Ca = new Carrier(5, Game.getOrientation(), cor);
            check = User.placeShip(Ca);
            Board.drawboards(User.getPlayerBoard().getBoard(), Comp.getPlayerBoard().getBoard());

            System.out.println("Give coordinates X Y for Battleship (size 4)");
            cor = Game.getInput();
            Battleship Ba = new Battleship(4, Game.getOrientation(), cor);
            check = User.placeShip(Ba);
            Board.drawboards(User.getPlayerBoard().getBoard(), Comp.getPlayerBoard().getBoard());

            System.out.println("Give coordinates X Y for Cruiser (size 3)");
            cor = Game.getInput();
            Cruiser Cr = new Cruiser(3, Game.getOrientation(), cor);
            check = User.placeShip(Cr);
            Board.drawboards(User.getPlayerBoard().getBoard(), Comp.getPlayerBoard().getBoard());

            System.out.println("Give coordinates X Y for Battleship (size 2)");
            cor = Game.getInput();
            Destroyer De = new Destroyer(2, Game.getOrientation(), cor);
            check = User.placeShip(De);
            Board.drawboards(User.getPlayerBoard().getBoard(), Comp.getPlayerBoard().getBoard());

            System.out.println("Give coordinates X Y for Battleship (size 3)");
            cor = Game.getInput();
            Submarine Su = new Submarine(3, Game.getOrientation(), cor);
            check = User.placeShip(Su);

            Comp.placeAllShips();

        }
        Board.drawboards(User.getPlayerBoard().getBoard(), Comp.getPlayerBoard().getBoard());

        boolean check = true;
        System.out.println("   Game Started");
        do {
            System.out.println("Give coordinates X Y for fire :");
            Comp.getPlayerBoard().setBoard(User.fire(Comp.getPlayerBoard().getBoard(), getInput()));
            User.getPlayerBoard().setBoard(Comp.fire(User.getPlayerBoard().getBoard(), getRandInput()));
            Board.drawboards(User.getPlayerBoard().getBoard(), Comp.getPlayerBoard().getBoard());

            if (Comp.getPlayerBoard().allShipsSunk()) {
                System.out.println("You Won !");
                check = false;
            } else if (User.getPlayerBoard().allShipsSunk()) {
                System.out.println("Game Over !");
            }

        } while (check);

        Comp.getStats();
        User.getStats();

    }


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

    static int[] getRandInput() {
        Random rand = new Random();
        int pin[] = new int[2];
        pin[0] = rand.nextInt(10);
        pin[1] = rand.nextInt(10);
        return pin;
    }

    static char getRandOrientation() {
        Random rand = new Random();
        int r = rand.nextInt(2);
        if (r == 0) {
            return 'h';
        } else return 'v';

    }

    static boolean randomPlace() throws IOException {
        boolean read = true;

        System.out.println("insert Y or N ");
        char c = (char) System.in.read();
        if (c == 'Y') {
            read = true;
        } else if (c == 'N') {
            read = false;
        }
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
}
