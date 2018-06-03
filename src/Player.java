public class Player {
    //Variables

    private int numOfShots;  //Counter of shots
    private int numOfMiss;   //Counter of missed shots
    private int numOfHit;    //Counter of successful hits
    private int numOfRep;    //Counter of repetitive shots
    private Board board = new Board();

    public Player(){
        this.numOfShots = 0;
        this.numOfMiss = 0;
        this.numOfHit = 0;
        this.numOfRep = 0;
    }

   /* public void placeAllShips(Board b) throws OverlapTilesException, OversizeException, AdjacentTilesException{            //Board's method is called
        b.placeAllShips(board);
    }*/

  /*  public void placeShip(Ship s, int Startx, int Starty) throws OverlapTilesException, OversizeException, AdjacentTilesException {       //Ship's method is called
        Tile t = new Tile(Startx, Starty, Tile.TileType.SHIP);
        s.placeShip(t, 'v',board,false);
    }*/


    public void getStats(){
        System.out.println("Number of shots: " + numOfShots + "\tNumber of missed shots: " + numOfMiss +
                "\tNumber of hits: " + numOfHit + "\tNumber of repetitive shots: " + numOfRep);
    }
/*
   public void fire(Tile t, Board b){
        numOfShots++;

            if(b.board[t.getY()][t.getX()].getSymbol() == 's'){                   //If the attacked tile is SHIP tile it changes its type to HIT and adds to the counter
                b.board[t.getY()][t.getX()].setTileType(Tile.TileType.HIT);
                System.out.println("Hit!");
                numOfHit++;
            }else if(b.board[t.getY()][t.getX()].getSymbol() == '~'){             //If the attacked tile is SEA tile it changes its type to MISS and adds to the counter
                b.board[t.getY()][t.getX()].setTileType(Tile.TileType.MISS);
                System.out.println("Miss!");
                numOfMiss++;
            }else if(b.board[t.getY()][t.getX()].getSymbol() == 'x' || b.board[t.getY()][t.getX()].getSymbol() == 'o'){     //If the attacked tile is HIT or MISS tile it adds to the counter
                System.out.println("Already hit the spot!");
                numOfRep++;
            }
    }*/
}