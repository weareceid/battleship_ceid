import java.util.*;

public  class Ship {

    private char orient;
    protected int size=3;


   public boolean placeShip(Tile t,char or, Board b, boolean verbose)throws OverlapTilesException,OversizeException,AdjacentTilesException{

        int x = t.getX();
        int y = t.getY();
        boolean FLAG = true;

        if( x+size>9 || y+size>9 || x>9 || x<0 || y>9 ||y<0  ) {

                FLAG = false ;
            if(verbose){
                throw new OversizeException();}
        }

//For horisontal placement
if(FLAG == true){
        if(or == 'h'){
                if(FLAG == true ){

                        for(int i=x; i<(x+size); i++){

                                if ( b.board[y][i].getSymbol() == 's' ) {
                                        
                                        FLAG = false ;
                                        if(verbose == true ) {throw new OverlapTilesException();}
                                
                                }
                        }
                        if(FLAG == true) {
                                        ArrayList<Tile>  pin = new ArrayList<Tile>();
                                        pin =b.getAdjacent(b.board[y][x] , b);
                                        for(int m=0; m<pin.size(); m++){
                                        
                                        do{ 
                                                for (int k = x; k<( x + size ); k++){

                                                        b.board[y][k].setTileType(Tile.TileType.SHIP);
                                                }

                                        }while(pin.get(m).getSymbol() != 's');

                                }
                        } 
                } 
        
}

        //Case that Orientation is Vertical
       else if(or == 'v'){
                if(FLAG == true ){

                        for(int j=y; j<(y+size); j++){

                                if ( b.board[j][x].getSymbol() == 's' ) {
                                        
                                        FLAG = false ;
                                        if(verbose == true ) {throw new OverlapTilesException();}
                                
                 }               
                        }
                                if(FLAG == true) {
                                        ArrayList<Tile>  pin = new ArrayList<Tile>();
                                        pin =b.getAdjacent(b.board[y][x] , b);
                                        for(int l=0; l<pin.size(); l++){
                                        
                                        do{ 
                                                for (int k = y; k<( y + size ); k++){

                                                        b.board[k][x].setTileType(Tile.TileType.SHIP);
                                                }

                                        }while(pin.get(l).getSymbol() != 's');

                                }
                        } 
                 
        }
}
   }

  return FLAG;
}
}
        /*else if (or == 'v' && check ) {
            for (int i = y; i < (y + size) &&check; i++) {

                if (b.board[i][x].getSymbol() == 's') {
                    check=false;
                    if(verbose) {
                        throw new OverlapTilesException();
                    }
                }

                    ArrayList<Tile> sfa2 = new ArrayList<>();
                    sfa2 = b.getAdjacent(b.board[i][x], b);
                        
                    for (int k = 0; k < sfa2.size(); k++) {

                        if (sfa2.get(k).getSymbol() == 's') {
                            check = false;

                            if (verbose) {
                                throw new AdjacentTilesException();
                            }
                        }
                    }
                  //  sfa2.clear();


 //                   if(check==false) break;
            }

             for (int i = y; i < (y + size); i++){
                if(check){
                    b.board[i][x].setTileType(Tile.TileType.SHIP);
                }else break;
             }

        }

        return check;
    }*/


