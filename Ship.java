import java.util.*;

public  class Ship {

    private char orient;
    protected int size;


    public boolean checkOversize (Tile t, Board b, boolean verbose)throws OversizeException{
        int x = t.getX();
        int y = t.getY();
        boolean oversize = true;

        if(x < 0  || x >= 10 || y < 0 || y >= 10 || (x + size) >= 10 || (y+size) >= 10 ){
            oversize = true;
            if(verbose == true){	throw new OversizeException();}
        }
        return oversize;
    }

    public boolean checkOverlap(Tile t,Board b,char or,boolean verbose)throws OverlapTilesException{
        int x=t.getX();
        int y=t.getY();
        boolean FLAG=true;

        if(or=='h'){
            int i=x;
            while( i<(x+size)){
                if(b.board[y][i].getSymbol() == 's'){
                    FLAG=false;
                    if(verbose){
                        throw new OverlapTilesException();
                    }
                    break;
                }
                else i++; FLAG=true;
            }
        }

        if(or=='v'){
            int i=y;
            while( i<(y+size)){
                if(b.board[i][x].getSymbol() == 's'){
                    FLAG=false;
                    if(verbose){
                        throw new OverlapTilesException();
                    }
                    break;
                }
                else i++; FLAG=true;
            }
        }
        return FLAG;
    }
    public boolean checkAdjacent(Tile t , Board b, boolean verbose) throws AdjacentTilesException{
        ArrayList<Tile> chad = new ArrayList<Tile>();
        chad=b.getAdjacent(t , b);
        boolean adjacent = false;

        for (Tile k : chad){
            if(k.getSymbol() != 's'){
                adjacent=true;
            }
            else{
                adjacent=false;
                break;
            }
                if(verbose == true){
                    throw new AdjacentTilesException();

                }
        }
        return adjacent;
    }

    public boolean placeShip(Tile t,char or, Board b, boolean verbose)throws OverlapTilesException,OversizeException,AdjacentTilesException{

        int x = t.getX();
        int y = t.getY();
        boolean FLAG = true;
						
					FLAG = checkOversize(t , b , verbose);



//For horisontal placement
if(FLAG == true){ 
        if(or == 'h'){

                FLAG = checkOverlap(t , b , or , verbose); 

                    }
                    if(FLAG == true){
                            FLAG = checkAdjacent(t , b , verbose);
                            }
    
                if(FLAG==true){
                    for(int i=x; i<(x+size); i++){
                        b.board[y][i].setTileType(Tile.TileType.SHIP);
                    }
                }
            }

        //Case that Orientation is Vertical
        else if(or == 'v'){
                
                FLAG = checkOverlap(t , b , or , verbose); 

                    }
                    if(FLAG == true) {
                            FLAG = checkAdjacent(t , b, verbose);
                            }
                
                if(FLAG==true){
                    for (int j = y; j < (y + size); j++) {
                        b.board[j][x].setTileType(Tile.TileType.SHIP);
                    }
                }
            

    return FLAG;
    }
}
