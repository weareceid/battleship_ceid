import java.lang.String;
import java.util.*;



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
    public void setY(int y){
        Y = y;
    }
    public void setTileType(TileType type){
        this.type = type;
    }
    public int getY(){
        return Y;
    }
    public int getX(){
        return X;
    }
    public char getSymbol(){ return type.symbol; }

    public void draw(){
        boolean hidden;
        //οταν τυπωνει ship tile του αντιπαλου να γινεται hidden = true; και να τα εκτυπωνει ως sea tile
        System.out.println (this.getSymbol());}
}
