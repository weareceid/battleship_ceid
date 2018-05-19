import java.lang.String;



public class Tile {
    enum TileType{
        SEA('~'), SHIP('s'), HIT('x'), MISS('o');

        private final char symbol;

        private TileType(char symbol) {
            this.symbol = symbol;
        }
    }
    //Coordinates
    private int X;
    private int Y;
    private TileType type;


    //Hidden variable
    private boolean tHidden;

    //Constructor
    public Tile(int X, int Y, TileType type){
        this.X = X;
        this.Y = Y;
        this.type = type;
    }

    //Getters and Setters Methods
    public void setX(int x){
        X = x;
    }
    public void setTileType(TileType type){
        this.type = type;
    }
    public void setY(int y){
        Y = y;
    }
    public int getY(){
        return Y;
    }
    public TileType getType(){
        return type;
    }
    public int getX(){
        return X;
    }
    public char getSymbol(){ return type.symbol; }

    





}
