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

    public Tile[][] getAdjacent(Tile t) {  //give argument Tile and return array Tile
       Tile pin[][]=new Tile[2][2];
       if(t.getX()-1>=0){
        pin[0][0]=board[t.getY()][t.getX() - 1];}
       else pin[0][0]=new Tile(0,0,Tile.TileType.SEA);
        if(t.getX()+1<10){
        pin[0][1]=board[t.getY() + 1][t.getX()];}
        else pin[0][1]=new Tile(0,0,Tile.TileType.SEA);
        if(t.getX()+1<10){
        pin[1][0]=board[t.getY()][t.getX() + 1];}
        else pin[1][0]=new Tile(0,0,Tile.TileType.SEA);
        if(t.getY()-1>=0){
        pin[1][1]=board[t.getY() - 1][t.getX()];}
        else pin[1][1]=new Tile(0,0,Tile.TileType.SEA);

        return pin;
    }

    public void placeAllShips(Board c) {
        int pin[] = new int[2];
        boolean a=true;
        boolean b=true;
        boolean l=true;
        boolean r=true;
        boolean w=true;

        Battleship battle = new Battleship();

while(a==true){
    try {
        a=battle.placeShip(c.board[Game.getRandInput()[0]][Game.getRandInput()[1]], Game.getRandOrientation(), c, false);
    } catch(OversizeException e){
    }catch(OverlapTilesException i){
    }catch(AdjacentTilesException u){
    }
        }

        Cruiser cru = new Cruiser();

        while(b==true){
            try {
        b=cru.placeShip(c.board[Game.getRandInput()[0]][Game.getRandInput()[1]], Game.getRandOrientation(), c, false);
            } catch(OversizeException e){
            }catch(OverlapTilesException i){
            }catch(AdjacentTilesException u){
            }
        }

        Destroyer des = new Destroyer();

        while(l==true){
            try {
        l=des.placeShip(c.board[Game.getRandInput()[0]][Game.getRandInput()[1]], Game.getRandOrientation(), c, false);
            } catch(OversizeException e){
            }catch(OverlapTilesException i){
            }catch(AdjacentTilesException u){
            }
        }

        Submarine sub = new Submarine();

        while(r==true){
            try {
        r=sub.placeShip(c.board[Game.getRandInput()[0]][Game.getRandInput()[1]], Game.getRandOrientation(), c, false);
            } catch(OversizeException e){
            }catch(OverlapTilesException i){
            }catch(AdjacentTilesException u){
            }
        }

        Carrier car = new Carrier();

        while(w==true){
            try {
        w=car.placeShip(c.board[Game.getRandInput()[0]][Game.getRandInput()[1]], Game.getRandOrientation(), c, false);
            } catch(OversizeException e){
            }catch(OverlapTilesException i){
            }catch(AdjacentTilesException u){}
        }
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