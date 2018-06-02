import java.util.*;

public  class Ship {

    private char orient;
    protected int size;


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

        if(or == 'h'){
            if(FLAG == true ){

                for(int i=x; i<(x+size); i++){

                    if ( b.board[y][i].getSymbol() == 's' ) {

                        FLAG = false ;
                        if(verbose == true ) {throw new OverlapTilesException();}

                    }
                    else {
                        ArrayList<Tile>  pin = new ArrayList<Tile>();
                        pin =b.getAdjacent(b.board[y][x] , b);
                        for(int m=0; m<pin.size(); m++){

                            if(pin.get(m).getSymbol() != 's'){


                                  FLAG=true;


                            }else{
                                FLAG=false;
                                if(verbose){
                                    throw new AdjacentTilesException();
                                }
                                break;
                            }

                        }
                    }
                }
              if(FLAG==true){
                    for(int i=x; i<(x+size); i++){
                        b.board[y][i].setTileType(Tile.TileType.SHIP);
                    }
                }
            }

            return FLAG;
        }

        //Case that Orientation is Vertical
        else if(or == 'v'){
            if(FLAG == true ){

                for(int j=y; j<(y+size); j++){

                    if ( b.board[j][x].getSymbol() == 's' ) {

                        FLAG = false ;
                        if(verbose == true ) {throw new OverlapTilesException();}

                    }
                    else {
                        ArrayList<Tile>  pin = new ArrayList<Tile>();
                        pin =b.getAdjacent(b.board[y][x] , b);
                        for(int l=0; l<pin.size(); l++){

                           if(pin.get(l).getSymbol() != 's'){


                                    FLAG=true;


                            }else{
                               FLAG=false;
                               if(verbose){
                                   throw new AdjacentTilesException();
                               }
                               break;
                           }

                        }
                    }
                }
                if(FLAG==true){
                    for (int j = y; j < (y + size); j++) {
                        b.board[j][x].setTileType(Tile.TileType.SHIP);
                    }
                }
            }
        }

        return FLAG;
    }
}

