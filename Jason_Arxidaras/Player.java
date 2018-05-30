import java.util.*;

public class Player {
    //Variables
    private String playerName;
    private int countShots;  //Counter of shots
    private int countMiss;   //Counter of missed shots
    private int countHit;    //Counter of successful hits
    private int countRep;    //Counter of repetitive shots
    private Board board = new Board();

    public Player(String name){
        playerName = name;
        this.countShots = 0;
        this.countMiss = 0;
        this.countHit = 0;
        this.countRep = 0;
    }
    
      //Getters
    public String getName(){ return name; }
    public int getCountShots() { return countShots; }
    public int getCountHit () { return countHit; }
    public int getCountMiss () { return countMiss; }
    public int getCountRep () { return countRep; }

    public void placeAllShips(Board b) throws OverlapTilesException, OversizeException, AdjacentTilesException{            //Board's method is called
        b.placeAllShips(board);
    }

    public void placeShip(Ship s, int Startx, int Starty) throws OverlapTilesException, OversizeException, AdjacentTilesException {       //Ship's method is called
        Tile t = new Tile(Startx, Starty, Tile.TileType.SHIP);
        s.placeShip(t, 'v',board,false);
    }


    public void getStats(){
        System.out.println("Number of shots: " + countShots + "\tNumber of missed shots: " + countMiss +
                "\tNumber of hits: " + countHit + "\tNumber of repetitive shots: " + countRep);
    }

    public void fire(Board b, int pin[]){
        countShots++;
        if(b.board[pin[0]][pin[1]].getSymbol() == 's'){ 	//If the attacked tile is SHIP tile it changes its type to HIT and adds to the counter
                b.board[pin[0]][pin[1]].setTileType(Tile.TileType.HIT);
                System.out.println("Hit!");
                countHit++;
            }else if(b.board[pin[0]][pin[1]].getSymbol() == '~'){  //If the attacked tile is SEA tile it changes its type to MISS and adds to the counter
                b.board[pin[0]][pin[1]].setTileType(Tile.TileType.MISS);
                System.out.println("Miss!");
                countMiss++;
            }else if(b.board[pin[0]][pin[1]].getSymbol() == 'x' || b.board[pin[0]][pin[1]].getSymbol() == 'o'){     //If the attacked tile is HIT or MISS tile it adds to the counter
                System.out.println("Already hit the spot!");
                countRep++;
            }
        }
}

