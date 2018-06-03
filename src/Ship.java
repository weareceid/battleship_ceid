import java.util.*;

public  class Ship {

    private char orient;
    protected int size;


    public boolean placeShip(Tile t,char or, Board b, boolean verbose)throws OverlapTilesException,OversizeException,AdjacentTilesException{
ArrayList<Tile> ad=new ArrayList<>();
        boolean check=true;
        if(t.getX()+size>9 || t.getY()+size>9 || t.getX()>9 || t.getX()<0 || t.getY()>9 ||t.getY()<0  ) {
            check=false;
            if(verbose){
                throw new OversizeException();}}
int k=0,j=0,i=0;

        if (or == 'h' && check ) {
            for (int j = t.getX(); j < (t.getX() + size)&& check; j++) {
ad= b.getAdjacent(b.board[t.getY()][j], b);
                if (b.board[t.getY()][j].getSymbol() == 's' ) {
                    check=false;
                    if(verbose){
                        throw new OverlapTilesException();}
                    break;
                }


                for (int k = 0; k <ad.size(); k++) {
                    if (ad.get(k).getSymbol() == 's') {
                        check = false;
                        if (verbose) {
                            throw new AdjacentTilesException();
                        }
                        ad.clear();
                        break ;
                    }
                }


            }
            ad.clear();
            if(check){
            for (int j = t.getX(); j < (t.getX() + size); j++) {

                    b.board[t.getY()][j].setTileType(Tile.TileType.SHIP);
                }
            }

        }
        //Case that Orientation is Vertical
        else if (or == 'v' &&check ) {
            for (int i = t.getY(); i < (t.getY() + size) &&check; i++) {
ad=b.getAdjacent(b.board[i][t.getX()], b);
                if (b.board[i][t.getX()].getSymbol() == 's') {
                    check=false;
                    if(verbose) {
                        throw new OverlapTilesException();
                    }
                      break;
                }


                for (int k = 0; k < ad.size(); k++) {
                    if (b.getAdjacent(b.board[i][t.getX()], b).get(k).getSymbol() == 's') {
                        check = false;
                        if (verbose) {
                            throw new AdjacentTilesException();
                        }
                        ad.clear();
                         break;
                    }
                }


            }
            ad.clear();
            if(check){

            for (int i = t.getY(); i < (t.getY() + size); i++){
                    b.board[i][t.getX()].setTileType(Tile.TileType.SHIP);
                }
            }

        }

ad.clear();
        return check;
    }
}

