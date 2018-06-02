public  class Ship {

    private char orient;
    protected int size=3;


   public boolean placeShip(Tile t,char or, Board b, boolean verbose)throws OverlapTilesException,OversizeException,AdjacentTilesException{

        boolean check=true;
        if(t.getX()+size>9 || t.getY()+size>9 || t.getX()>9 || t.getX()<0 || t.getY()>9 ||t.getY()<0  ) {
            check=false;
            if(verbose){
                throw new OversizeException();}}


        if (or == 'h' && check ) {
            for (int j = t.getX(); j < (t.getX() + size)&& check; j++) {

                if (b.board[t.getY()][j].getSymbol() == 's' ) {
                    check=false;
                    if(verbose){
                        throw new OverlapTilesException();}
                        break;
                }/*
                   else if ( j==t.getX() && (b.getAdjacent(b.board[t.getY()][j],b)[0][0].getSymbol() == 's' || b.getAdjacent(b.board[t.getY()][j],b)[0][1].getSymbol() == 's' || b.getAdjacent(b.board[t.getY()][j],b)[1][0].getSymbol() == 's' || b.getAdjacent(b.board[t.getY()][j],b)[1][1].getSymbol() == 's')) {
                        check = false;
                        if (verbose) {
                            throw new AdjacentTilesException();
                        }
                        break;
                    }


                   else if ( j>t.getX() && (b.getAdjacent(b.board[t.getY()][j],b)[0][1].getSymbol() == 's' || b.getAdjacent(b.board[t.getY()][j],b)[1][0].getSymbol() == 's' || b.getAdjacent(b.board[t.getY()][j],b)[1][1].getSymbol() == 's')) {
                        check = false;
                        if (verbose) {
                            throw new AdjacentTilesException();
                        }
                        break;
                    }*/

                    for (int k = 0; k < b.getAdjacent(b.board[t.getY()][j], b).size(); k++) {
                        if (b.getAdjacent(b.board[t.getY()][j], b).get(k).getSymbol() == 's') {
                            check = false;
                            if (verbose) {
                                throw new AdjacentTilesException();
                            }
                           break ;
                        }
                    }





            }

                    for (int j = t.getX(); j < (t.getX() + size); j++) {
                if(check){
                    b.board[t.getY()][j].setTileType(Tile.TileType.SHIP);
                       }
                    }

        }
        //Case that Orientation is Vertical
        else if (or == 'v' &&check ) {
            for (int i = t.getY(); i < (t.getY() + size) &&check; i++) {

                if (b.board[i][t.getX()].getSymbol() == 's') {
                    check=false;
                    if(verbose) {
                        throw new OverlapTilesException();
                    }
                 //   break;
                }
/*
                  else if ( i==t.getY() && (b.getAdjacent(b.board[i][t.getX()],b)[0][0].getSymbol() == 's' || b.getAdjacent(b.board[i][t.getX()],b)[0][1].getSymbol() == 's' || b.getAdjacent(b.board[i][t.getX()],b)[1][0].getSymbol() == 's' || b.getAdjacent(b.board[i][t.getX()],b)[1][1].getSymbol() == 's')) {
                        check = false;
                        if (verbose) {
                            throw new AdjacentTilesException();
                        }
                    break;
                    }

                   else if ( i>t.getY()  &&  (b.getAdjacent(b.board[i][t.getX()],b)[0][0].getSymbol() == 's' || b.getAdjacent(b.board[i][t.getX()],b)[0][1].getSymbol() == 's' || b.getAdjacent(b.board[i][t.getX()],b)[1][0].getSymbol() == 's') ){
                        check = false;
                        if (verbose) {
                            throw new AdjacentTilesException();
                        }
                    break;
                    }*/

                    for (int k = 0; k < b.getAdjacent(b.board[i][t.getX()], b).size(); k++) {
                        if (b.getAdjacent(b.board[i][t.getX()], b).get(k).getSymbol() == 's') {
                            check = false;
                            if (verbose) {
                                throw new AdjacentTilesException();
                            }
                           // break;
                        }
                    }


            }

             for (int i = t.getY(); i < (t.getY() + size); i++){
                if(check){
                    b.board[i][t.getX()].setTileType(Tile.TileType.SHIP);
                }else break;
             }

        }

        return check;
    }
}
