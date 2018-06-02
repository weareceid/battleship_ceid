import java.util.*;

public class Board {

    Tile board[][] = new Tile[10][10];  // The board Tile type that the game is played
    boolean hidden;  //usage for player identification

    public Board() {//constructor for board
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Tile v = new Tile(i, j, Tile.TileType.SEA);
                board[i][j] = v;
            }
        }
    }

    public void drawboards() {

        System.out.println("    - - Y O U - -   ");
        System.out.println("  0 1 2 3 4 5 6 7 8 9");

        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 11; j++) {
                if (j == 0) {
                    System.out.print(i);
                    System.out.print(" ");
                } else {
                    board[i][j - 1].draw(false);
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        System.out.println();
        System.out.println(" - O P P O N E N T -");
        System.out.println("  0 1 2 3 4 5 6 7 8 9");

        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 11; j++) {
                if (j == 0) {
                    System.out.print(i);
                    System.out.print(" ");
                } else {
                    board[i][j - 1].draw(true);
                    System.out.print(" ");
                }
            }
            System.out.println();

        }
    }

    public ArrayList<Tile> getAdjacent(Tile t,Board b) {  //give argument Tile and return array Tile
       ArrayList<Tile> pin=new ArrayList<Tile>();
       int x = t.getX();
       int y = t.getY();
       if(x-1>=0){
        pin.add(b.board[y][x - 1]);}
       //else pin.add(new Tile(0,0,Tile.TileType.SEA));
        if(x+1<10){
        pin.add(b.board[y][x + 1]);}
      //  else pin.add(new Tile(0,0,Tile.TileType.SEA));
        if(y+1<10){
        pin.add(b.board[y + 1][x]);}
      //  else pin.add(new Tile(0,0,Tile.TileType.SEA));
        if(y-1>=0){
        pin.add(b.board[y - 1][x]);}
       // else pin.add(new Tile(0,0,Tile.TileType.SEA));

        return pin;
    }

    public void placeAllShips(Board c)throws OversizeException,OverlapTilesException,AdjacentTilesException {
        int pin[] = new int[2];
        char or=Game.getRandOrientation();
        boolean FLAG=true;
        Battleship battle = new Battleship();
        pin=Game.getRandInput();
        Tile t=new Tile(pin[0],pin[1],Tile.TileType.SEA);
      while(FLAG==false){
        FLAG=battle.placeShip(t, or, c, false);
       if(FLAG==false){
          pin=Game.getRandInput();
           t.setY(pin[0]);
           t.setX(pin[1]);
       }
       else break;
        }

        FLAG=false;
        Cruiser cru = new Cruiser();
        or=Game.getRandOrientation();
        pin=Game.getRandInput();
        t.setY(pin[0]);
        t.setX(pin[1]);
        while(FLAG==false){
        FLAG=cru.placeShip(t, or, c, false);
            if(FLAG==false){
                pin=Game.getRandInput();
                t.setY(pin[0]);
                t.setX(pin[1]);
            }else break;
        }

        FLAG=false;
        Destroyer des = new Destroyer();
        or=Game.getRandOrientation();
        pin=Game.getRandInput();
        t.setY(pin[0]);
        t.setX(pin[1]);
        while(FLAG==false){
        FLAG=des.placeShip(t, or, c, false);
            if(FLAG==false){
                pin=Game.getRandInput();
                t.setY(pin[0]);
                t.setX(pin[1]);
            }
else break;
        }
        FLAG=false;
        Submarine sub = new Submarine();
        or=Game.getRandOrientation();
        pin=Game.getRandInput();
        t.setY(pin[0]);
        t.setX(pin[1]);

        while(FLAG==false){
        FLAG=sub.placeShip(t, or, c, false);
            if(FLAG==false){
                pin=Game.getRandInput();
                t.setY(pin[0]);
                t.setX(pin[1]);
            }
else break;
        }

        FLAG=false;
        Carrier car = new Carrier();
        or=Game.getRandOrientation();
        pin=Game.getRandInput();
        t.setY(pin[0]);
        t.setX(pin[1]);

        while(FLAG==false){
        FLAG=car.placeShip(t, or, c, false);
            if(FLAG==false){
                pin=Game.getRandInput();
                t.setY(pin[0]);
                t.setX(pin[1]);
            }
else break;
        }
    }

    public void setBoard(Tile[][] board) {
        this.board = board;
    }


    public boolean allShipsSunk() {
        boolean check=false;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 11; j++) {
                if (board[i][j].getSymbol() == 's') {
                     check=false;
                }
                else {
                        check=true;
                }
            }
        }
         return check;
    }
}
