import java.util.ArrayList;

public class Player {
    //Variables
String name;
    private int numOfShots;  //Counter of shots
    private int numOfMiss;   //Counter of missed shots
    private int numOfHit;    //Counter of successful hits
    private int numOfRep;    //Counter of repetitive shots
    private Board board = new Board();
    static boolean FLAG;
//Constructor
    public Player(String name){
        this.name=name;
        this.numOfShots = 0;
        this.numOfMiss = 0;
        this.numOfHit = 0;
        this.numOfRep = 0;
    }

    public Board getPlayerBoard() { return board; }

    public void placeAllShips() throws OverlapTilesException, OversizeException, AdjacentTilesException{            //Board's method is called 
        getPlayerBoard().placeAllShips();
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
    //Fire Method
    public Tile[][] fire(Tile board[][], int arr[]) {
        numOfShots++;

        System.out.println(name + " ");

        if("Computer".equals(name)&& FLAG){
            if(k < tiles.size()){
                arr[0]=tiles.get(k).getX();
                arr[1]=tiles.get(k).getY();}

        }

        if (board[arr[0]][arr[1]].getType() == Tile.Type.SHIP) {
            numOfHit++;
            board[arr[0]][arr[1]].setType(Tile.Type.HIT);
            System.out.print("Hit");
            if("Computer".equals(name)){
                tiles =getPlayerBoard().getAdjacentTiles(board[arr[0]][arr[1]], board);
                j++;
                FLAG = true;
            }
        } else if (board[arr[0]][arr[1]].getType() == Tile.Type.SEA) {
            numOfMiss++;
            board[arr[0]][arr[1]].setType(Tile.Type.MISS);
            System.out.print("Miss");
            if("Computer".equals(name) ){
                if(FLAG)
                    k++;
                if(k>3||j>1){
                    k=0;
                    j=0;
                    FLAG=false;}

            }
        } else {
            numOfRep++;

            if (board[arr[0]][arr[1]].getType() == Tile.Type.MISS) {
                System.out.print("Already Miss");
            } else {
                System.out.print("Already Hit");
            }
            if("Computer".equals(name) ){
                if(FLAG)
                    k++;
                if(k>3||j>1){
                    k=0;
                    j=0;
                    FLAG=false;}

            }

        }
        System.out.println();


        return board;

    }
}
