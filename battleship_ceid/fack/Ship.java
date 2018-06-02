import java.util.*;

public  class Ship {

    private char orient;
    protected int size;


    public boolean checkOversize (Tile t, boolean verbose)throws OversizeException{
        int x = t.getX();
        int y = t.getY();
        boolean oversize = true;

        if(x < 0  || x > 10 || y < 0 || y > 10 || (x + size) > 10 || (y+size) > 10 ){
            oversize = false;
            if(verbose == true){	throw new OversizeException();}
        }
        return oversize;
    }

    public boolean checkOverlap(Tile t,Board b,char or,boolean verbose)throws OverlapTilesException{
        int x=t.getX();
        int y=t.getY();
        boolean FLAG=false;

        if(or=='h'){
            for(int i=x; i<(x+size); i++){
                if(b.board[y][i].getSymbol() == 's'){
                    FLAG=false;
                    if(verbose == true){
                        throw new OverlapTilesException();
                    }
                }
                else{
                FLAG=true; 
                break;
                }
            }
        }

        if(or=='v'){
            for(int i=y; i<(y+size); i++){
                if(b.board[i][x].getSymbol() == 's'){
                    FLAG=false;
                    if(verbose == true){
                        throw new OverlapTilesException();
                    }
                }
                else FLAG = true;
                break;
            }
        }
        return FLAG;
    }
    
    public boolean checkAdjacent(Tile t , Board b, boolean verbose) throws AdjacentTilesException{
        ArrayList<Tile> chad = new ArrayList<Tile>();
        chad=b.getAdjacent(t , b);
        boolean adjacent = false;

        for (Tile k : chad){
            if(k.getSymbol() == 's'){
                adjacent=false;
            }
            else{
                adjacent=true;
            }
                if(verbose == true){
                    throw new AdjacentTilesException();

                }
                break;
        }
        return adjacent;
    }

    public boolean placeShip(Tile t,char or, Board b, boolean verbose)throws OverlapTilesException,OversizeException,AdjacentTilesException{

        int x = t.getX();
        int y = t.getY();
        boolean FLAG = false;
						
					FLAG = checkOversize(t , verbose);



//For horisontal placement
if(FLAG == true){ 
                FLAG = checkOverlap(t , b , or , verbose); 
                    
                    if(FLAG == true){
                            FLAG = checkAdjacent(t , b , verbose);
                            }
    
                if(FLAG==true){
                    for(int i=x; i<(x+size); i++){
                        b.board[y][i].setTileType(Tile.TileType.SHIP);
                    }
                }
            

        //Case that Orientation is Vertical
                
                FLAG = checkOverlap(t , b , or , verbose); 

                    if(FLAG == true) {
                            FLAG = checkAdjacent(t , b, verbose);
                            }
                
                if(FLAG==true){
                    for (int j = y; j < (y + size); j++) {
                        b.board[j][x].setTileType(Tile.TileType.SHIP);
                    }
                }
            
}

    return FLAG;
    }
}
