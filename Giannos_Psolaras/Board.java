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
       ArrayList<Tile> pin=new ArrayList<>();
        if(t.getX()+1<10 && t.getType()== Tile.TileType.SHIP){
            pin.add(b.board[t.getY()][t.getX() + 1]);}
       // else pin.add(new Tile(t.getY(),t.getX() + 1,Tile.TileType.SEA));
        if(t.getY()+1<10&& t.getType()== Tile.TileType.SHIP){
            pin.add(b.board[t.getY() + 1][t.getX()]);}
      //  else pin.add(new Tile(t.getY() + 1,t.getX(),Tile.TileType.SEA));
       if(t.getX()-1>=0 && t.getType()== Tile.TileType.SHIP){
        pin.add(b.board[t.getY()][t.getX() - 1]);}
      // else pin.add(new Tile(t.getY(),t.getX() - 1,Tile.TileType.SEA));
        if(t.getY()-1>=0&& t.getType()== Tile.TileType.SHIP){
        pin.add(b.board[t.getY() - 1][t.getX()]);}
      //  else pin.add(new Tile(t.getY() - 1,t.getX(),Tile.TileType.SEA));
      //  System.out.print(pin.get(0).getSymbol());
      //  System.out.print(pin.get(1).getSymbol());
      //  System.out.print(pin.get(2).getSymbol());
     //   System.out.print(pin.get(3).getSymbol());
        return pin;

    }

    public void placeAllShips()throws OversizeException,OverlapTilesException,AdjacentTilesException {
       Board c=this;
        int pin[] ;
        boolean check=false;
       char or=Game.getRandOrientation();
        Battleship battle = new Battleship();
int a=0;
     pin=Game.getRandInput();
    Tile t=new Tile(pin[0],pin[1],Tile.TileType.SEA);
    switch(a) {
        case 0: {
            while (!check) {

                check = battle.placeShip(t, or, c, false);
System.out.print(check);
                if (!check) {
                    pin = Game.getRandInput();
                    t.setY(pin[0]);
                    t.setX(pin[1]);
                } else {
                    a = 1;
                    break;
                }
            }
        }
        case 1: {
            check = false;
            Cruiser cru = new Cruiser();
            or = Game.getRandOrientation();
        //    pin = Game.getRandInput();
            while (!check) {
                check = cru.placeShip(t, or, c, false);
                System.out.print(check);
                if (!check) {
                    pin = Game.getRandInput();
                    t.setY(pin[0]);
                    t.setX(pin[1]);
                } else {
                    a = 2;
                    break;
                }
            }

        }
        case 2: {
            check = false;
            Destroyer des = new Destroyer();
            or = Game.getRandOrientation();
         //   pin = Game.getRandInput();
            while (!check) {
                check = des.placeShip(t, or, c, false);
                System.out.print(check);
                if (!check) {
                    pin = Game.getRandInput();
                    t.setY(pin[0]);
                    t.setX(pin[1]);
                } else {
                    a = 3;
                    break;
                }
            }
        }
        case 3: {
            check = false;
            Submarine sub = new Submarine();
            or = Game.getRandOrientation();
          //  pin = Game.getRandInput();

            while (!check) {
                check = sub.placeShip(t, or, c, false);
                System.out.print(check);
                if (!check) {
                    pin = Game.getRandInput();
                    t.setY(pin[0]);
                    t.setX(pin[1]);
                } else {
                    a = 4;
                    break;
                }
            }
        }
        case 4: {
            check = false;
            Carrier car = new Carrier();
            or = Game.getRandOrientation();
         //   pin = Game.getRandInput();

            while (!check) {
                check = car.placeShip(t, or, c, false);
                System.out.print(check);
                if (!check) {
                    pin = Game.getRandInput();
                    t.setY(pin[0]);
                    t.setX(pin[1]);
                } else break;
            }
        }
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