import java.util.ArrayList;

public class Player {
    //Variables
String name;
    private int numOfShots;  //Counter of shots
    private int numOfMiss;   //Counter of missed shots
    private int numOfHit;    //Counter of successful hits
    private int numOfRep;    //Counter of repetitive shots
    private Board board = new Board();
static boolean check;
    Board b=new Board();
    public Player(String name){
        this.name=name;
        this.numOfShots = 0;
        this.numOfMiss = 0;
        this.numOfHit = 0;
        this.numOfRep = 0;
    }

    public Board getPlayerBoard() { return board; }

    public void placeAllShips() throws OverlapTilesException, OversizeException, AdjacentTilesException{            //Board's method is called 
        b.placeAllShips();
    }

   public boolean placeShip(Ship s) throws OverlapTilesException, OversizeException, AdjacentTilesException {       //Ship's method is called

     return  s.PlaceShip(board,true);
    }


    public void getStats(){
        System.out.println("Number of shots: " + numOfShots + "\tNumber of missed shots: " + numOfMiss +
                "\tNumber of hits: " + numOfHit + "\tNumber of repetitive shots: " + numOfRep);
    }
static int k=0,j=0;
    ArrayList<Tile> tiles=new ArrayList<Tile>();
    Tile[][] fire(Tile board[][], int pin[]) {
        numOfShots++;

        System.out.println(name + " ");

        if("Computer".equals(name)&& check){
            if(k < tiles.size()){
                pin[0]=tiles.get(k).getX();
                pin[1]=tiles.get(k).getY();}

        }

        if (board[pin[0]][pin[1]].getType() == Tile.Type.SHIP) {
            numOfHit++;
            board[pin[0]][pin[1]].setType(Tile.Type.HIT);
            System.out.print("Hit");
            if("Computer".equals(name)){
                tiles =b.getAdjacentTiles(board[pin[0]][pin[1]], board);
                j++;
                check = true;
            }
        } else if (board[pin[0]][pin[1]].getType() == Tile.Type.SEA) {
            numOfMiss++;
            board[pin[0]][pin[1]].setType(Tile.Type.MISS);
            System.out.print("Miss");
            if("Computer".equals(name) ){
                if(check)
                    k++;
                if(k>3||j>1){
                    k=0;
                    j=0;
                    check=false;}

            }
        } else {
            numOfRep++;

            if (board[pin[0]][pin[1]].getType() == Tile.Type.MISS) {
                System.out.print("Already Miss");
            } else {
                System.out.print("Already Hit");
            }
            if("Computer".equals(name) ){
                if(check)
                    k++;
                if(k>3||j>1){
                    k=0;
                    j=0;
                    check=false;}

            }

        }
        System.out.println();


        return board;

    }
}
