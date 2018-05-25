public  class Ship {

    private char orient;
    protected int size=3;


    public void placeShip(Tile t,char or, Board b, boolean verbose)throws OverlapTilesException,OversizeException,AdjacentTilesException{



        verbose=false;

        if(( t.getX()+size>9 || t.getY()+size>9 || t.getX()>9 || t.getX()<0 || t.getY()>9 ||t.getY()<0  )) {
            throw new OversizeException();}


            if (or == 'h') {
                for (int j = t.getX(); j < (t.getX() + size); j++) {

                    if (b.board[t.getY()][j].getSymbol() == 's') {
                        throw new OverlapTilesException();
                    }
                    else if (b.getAdjacent(t)[0][0].getSymbol() == 's' || b.getAdjacent(t)[0][1].getSymbol() == 's' || b.getAdjacent(t)[1][0].getSymbol() == 's' || b.getAdjacent(t)[1][1].getSymbol() == 's') {
                        throw new AdjacentTilesException();
                    }
                    else b.board[t.getY()][j].setTileType(Tile.TileType.SHIP);
                }

            }
            //Case that Orientation is Vertical
            else if (or == 'v') {
                for (int i = t.getY(); i < (t.getY() + size); i++) {

                    b.board[i][t.getX()].setTileType(Tile.TileType.SHIP);
                }

            }

    }
}