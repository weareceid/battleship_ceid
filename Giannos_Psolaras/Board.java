import java.util.*;

public class Board{

    Tile board[][]=new Tile[10][10];  // The board Tile type that the game is played
    boolean hidden;  //usage for player identification

    public Board(){//constructor for board
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                Tile v=new Tile(i,j, Tile.TileType.SEA);
                board[i][j]=v;
            }
        }
    }

    public  void drawboards(){

        System.out.println("    - - Y O U - -   ");
        System.out.println("  0 1 2 3 4 5 6 7 8 9");

        for(int i=0; i<10; i++){

            for(int j=0; j<11; j++){
                if(j==0){
                    System.out.print(i);
                    System.out.print(" ");
                }
                else{
                    board[i][j-1].draw(false);
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        System.out.println();
        System.out.println(" - O P P O N E N T -");
        System.out.println("  0 1 2 3 4 5 6 7 8 9");

        for(int i=0; i<10; i++){

            for(int j=0; j<11; j++){
                if(j==0){
                    System.out.print(i);
                    System.out.print(" ");
                }
                else{
                    board[i][j-1].draw(true);
                    System.out.print(" ");
                }
            }System.out.println();

        }
    }
    public ArrayList<Tile> getAdjacent(Tile t,Tile pin[][]){  //give argument Tile and return arraylist Tile
        ArrayList<Tile> check=new ArrayList<>();
        check.add(pin[t.getY()][t.getX()-1]);
        check.add(pin[t.getY()+1][t.getX()]);
        check.add(pin[t.getY()][t.getX()+1]);
        check.add(pin[t.getY()-1][t.getX()]);

        return check;
    }

    public void placeAllShips(Board c){
   int pin[]=new int[2];


        Battleship battle=new Battleship();
        battle.placeShip(c.board[Game.getRandInput()[0]][Game.getRandInput()[1]],Game.getRandOrientation(),c,false);

        Cruiser cru=new Cruiser();
        cru.placeShip(c.board[Game.getRandInput()[0]][Game.getRandInput()[1]],Game.getRandOrientation(),c,false);

        Destroyer des=new Destroyer();
        des.placeShip(c.board[Game.getRandInput()[0]][Game.getRandInput()[1]],Game.getRandOrientation(),c,false);

        Submarine sub=new Submarine();
        sub.placeShip(c.board[Game.getRandInput()[0]][Game.getRandInput()[1]],Game.getRandOrientation(),c,false);

        Carrier car=new Carrier();
        car.placeShip(c.board[Game.getRandInput()[0]][Game.getRandInput()[1]],Game.getRandOrientation(),c,false);
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
