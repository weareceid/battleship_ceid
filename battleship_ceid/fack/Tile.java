import java.lang.String;
import java.util.*;



public class Tile {
    enum TileType {
        SEA('~'), SHIP('s'), HIT('x'), MISS('o');

        private final char symbol;

        private TileType(char symbol) {
            this.symbol = symbol;
        }
    }

    //Coordinates
    private int X;
    private int Y;
    //Type of tile
    private TileType type;

    //Constructor
    public Tile(int X, int Y, TileType type) {
        this.X = X;
        this.Y = Y;
        this.type = type;
    }

    //Getters and Setters Methods
    public void setX(int x) {
        this.X = x;
    }

    public void setY(int y) {
        this.Y = y;
    }

    public void setTileType(TileType type) {
        this.type = type;
    }

    public int getY() {
        return Y;
    }

    public int getX() {
        return X;
    }

    public char getSymbol() {   //Returns the symbol assigned to the type of the tile
        return type.symbol;
    }

    public void draw(boolean opponent) {       //If opponent's  SHIP tile is to be drawn it draws SEA tile. Everything else is drawn normally.
                if (opponent == true) {
            boolean hidden = false;
            if (this.getSymbol() == 's') {
                hidden = true;
            }
            if (hidden == true) {
                System.out.print('~');
            } else {
                System.out.print(this.getSymbol());
            }
        }else {
            System.out.print(this.getSymbol());
         }
    }
    public TileType getType(){return type;}
}
