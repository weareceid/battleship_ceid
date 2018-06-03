
import java.lang.String;
import java.util.*;



public class Tile {

    //enum
    enum Type {
        SEA("~"), SHIP("s"), HIT("x"), MISS("o");  // Named constants

        private final String symbol;      // Private variable

        private Type(String symbol) {
            this.symbol = symbol;
        }

    }

    //Variables
    private int X, Y;
    private Type type;

    public Tile(int X, int Y, Type type) {
        this.X = X;
        this.Y = Y;
        this.type = type;
    }

    public int getX() {
        return X;
    }

    public void setX(int X) {
        this.X = X;
    }

    public int getY() {
        return Y;
    }

    public void setY(int Y) {
        this.Y = Y;
    }


    public String getSymbol(boolean hidden){
       String c;
        if (hidden && type==Tile.Type.SHIP) // Getter
        {
           c="~";
        } else {
            c=type.symbol;
        }
       return c;
    }


    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    void draw(boolean hidden) {
        if (hidden && type==Tile.Type.SHIP) // Getter
        {
            System.out.print("~");
        } else {
            System.out.print(type.symbol);
        }

    }

}
