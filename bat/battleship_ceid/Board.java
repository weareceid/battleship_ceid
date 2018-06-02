import java.util.*;

public class Board {

    private Tile[][] board = new Tile[10][10];

    public Board() {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = new Tile(i, j, Tile.Type.SEA);
            }
        }

    }
//Setter and Getter for board
    public Tile[][] getBoard() { return board;} 


    public void setBoard(Tile[][] board) {this.board = board;}

    //Method for drawing the Boards

    public static void drawboards(Tile board1[][], Tile board2[][]) {

        System.out.println("\t" + " ------------- YOU --------------");
        System.out.println("  0" + "1" + "2" + "3" + "4" + "5" + "6" + "7" + "8" + "9");

        for (int i = 0; i < 10; i++) {

            System.out.print(i + " ");

            for (int j = 0; j < 10; j++) {

                board1[i][j].draw(false);
                System.out.print(" ");
            }
              System.out.println();
        }

        System.out.println();
        System.out.println("\t" + " ------------- COMPUTER --------------");
        System.out.println("  0" + "1" + "2" + "3" + "4" + "5" + "6" + "7" + "8" + "9");

        for (int i = 0; i < 10; i++) {

            System.out.print(i + " ");

            for (int j = 0; j < 10; j++) {
                board2[i][j].draw(false);
                System.out.print(" ");
            }

            System.out.println();

        }
    }

    //Method for random ship placement.
    void placeAllShips() throws OverlapTilesException, OversizeException, AdjacentTilesException {
        Board b = this;
        int[] coord = new int[2];
        
//Creating Ships Objects.
        Carrier ca = new Carrier(5, Game.getRandOrientation(), coord);
        Battleship ba = new Battleship(4, Game.getRandOrientation(), coord);
        Cruiser cr = new Cruiser(3, Game.getRandOrientation(), coord);
        Destroyer de = new Destroyer(2, Game.getRandOrientation(), coord);
        Submarine su = new Submarine(3, Game.getRandOrientation(), coord);

        coord = Game.getRandInput();
        boolean FLAG = false;

        //For Carrier
        while (!FLAG) {

            FLAG = ca.PlaceShip(b, false);
            coord = Game.getRandInput();
            
            if (!FLAG) {

                ca.setStartCell(coord);
            }
        }

        FLAG = false;

        //For Battleship
        while (!FLAG) {
                
            FLAG = ba.PlaceShip(b, false);
            coord = Game.getRandInput();
            
            if (!FLAG) {
                    
                ba.setStartCell(coord);
            }
        }

        FLAG = false;
        
       //For Cruiser
        while (!FLAG) {
                
            FLAG = cr.PlaceShip(b, false);
            coord = Game.getRandInput();
            
            if (!FLAG) {
                    
                cr.setStartCell(coord);
            }
        }

        FLAG = false;

      //For Destroyer 
        while (!FLAG) {
                
            FLAG = de.PlaceShip(b, false);
            coord = Game.getRandInput();
            
            if (!FLAG) {
                    
                de.setStartCell(coord);
            }
        }

        FLAG = false;

        //For Submarine
        while (!FLAG) {
                
            FLAG = su.PlaceShip(b, false);
            coord = Game.getRandInput();
            
            if (!FLAG) {
                    
                su.setStartCell(coord);
            }
        }
    }
    

    //Putting near Tiles in ArrayList.
     public ArrayList<Tile> getAdjacentTiles(Tile t, Tile[][] board) {
        ArrayList<Tile> b = new ArrayList<Tile>();

        int x = t.getX();
        int y = t.getY();

        if (y + 1 < 10) { b.add(board[x][y + 1]); }

        if (x + 1 < 10) { b.add(board[x + 1][y]); }

        if (y - 1 >= 0) { b.add(board[x][y - 1]); }

        if (x - 1 >= 0) { b.add(board[x - 1][y]); }

        return b;

    }

    public boolean allShipsSunk() {
            
        boolean FLAG = true;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                if (board[i][j].getType() == Tile.Type.SHIP) {

                    FLAG = false;
                }
            }
        }
        return FLAG;
    }

}
