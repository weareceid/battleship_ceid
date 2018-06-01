import java.util.*;

public  class Ship {

    private char orient;
    protected int size=3;


    public boolean placeShip(Tile t,char or, Board b, boolean verbose)throws OverlapTilesException,OversizeException,AdjacentTilesException{
ArrayList<Tile> ad=new ArrayList<>();
        boolean check=true;
        if(t.getX()+size>9 || t.getY()+size>9 || t.getX()>9 || t.getX()<0 || t.getY()>9 ||t.getY()<0  ) {
            check=false;
            if(verbose){
                throw new OversizeException();}}


        if (or == 'h' && check ) {
            for (int j = t.getX(); j < (t.getX() + size); j++) {
                ad=b.getAdjacent(b.board[t.getY()][j], b);
                if (b.board[t.getY()][j].getType() == Tile.TileType.SHIP ) {
                    check = false;
                    if (verbose) {
                        throw new OverlapTilesException();
                    }
                //   break;
                }
                int k=0;
while(k<ad.size()){
    if(ad.get(k).getType()== Tile.TileType.SHIP){
        check=false;
        System.out.print(ad.get(k).getSymbol());
        ad.remove(k);
        if(verbose){
            throw new AdjacentTilesException();
        }
    }else{
        System.out.print(ad.get(k).getSymbol());
        ad.remove(k);
        k++;
    }
}

                /*   else if (ad.get(0).getType()== Tile.TileType.SHIP ) {
                        check = false;
                        if (verbose) {
                            throw new AdjacentTilesException();
                        }
                        break ;
                    }

                else if (ad.get(1).getType()== Tile.TileType.SHIP) {
                    check = false;
                    if (verbose) {
                        throw new AdjacentTilesException();
                    }
                    break ;
                }

                else if (ad.get(2).getType()== Tile.TileType.SHIP) {
                    check = false;
                    if (verbose) {
                        throw new AdjacentTilesException();
                    }
                    break ;
                }
                else if (ad.get(3).getType()== Tile.TileType.SHIP) {
                    check = false;
                    if (verbose) {
                        throw new AdjacentTilesException();
                    }
                    break ;
                }

         ad.clear();*/

            }
            if(check) {
                for (int j = t.getX(); j < (t.getX() + size); j++) {
                    b.board[t.getY()][j].setTileType(Tile.TileType.SHIP);
                }
            }
        }
        //Case that Orientation is Vertical
        else if (or == 'v' &&check ) {
            for (int i = t.getY(); i < (t.getY() + size); i++) {
                ad = b.getAdjacent(b.board[i][t.getX()], b);
                if (b.board[i][t.getX()].getType() == Tile.TileType.SHIP) {
                    check = false;
                    if (verbose) {
                        throw new OverlapTilesException();
                    }
                  //  break;
                }
                int k=0;
                while(k<ad.size()){
                    if(ad.get(k).getType()== Tile.TileType.SHIP){
                        check=false;
                        System.out.print(ad.get(k).getSymbol());
                        ad.remove(k);
                        if(verbose){
                            throw new AdjacentTilesException();
                        }
                    }else{
                        System.out.print(ad.get(k).getSymbol());
                        ad.remove(k);
                        k++;
                    }
                }

                /*else if (ad.get(0).getType() == Tile.TileType.SHIP) {
                    check = false;
                    if (verbose) {
                        throw new AdjacentTilesException();
                    }
                    break;
                } else if (ad.get(1).getType() == Tile.TileType.SHIP) {
                    check = false;
                    if (verbose) {
                        throw new AdjacentTilesException();
                    }
                    break;
                } else if (ad.get(2).getType() != Tile.TileType.SHIP) {
                    check = false;
                    if (verbose) {
                        throw new AdjacentTilesException();
                    }
                    break;
                } else if (ad.get(3).getType() != Tile.TileType.SHIP) {
                    check = false;
                    if (verbose) {
                        throw new AdjacentTilesException();
                    }
                    break;
                }

//ad.clear();*/
            }
            if (check){
                for (int i = t.getY(); i < (t.getY() + size); i++) {
                    b.board[i][t.getX()].setTileType(Tile.TileType.SHIP);
                }
        }
        }

        return check;
    }
}
