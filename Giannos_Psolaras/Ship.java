public  class Ship {

    private char orient;
    private  int size=3;


    public void placeShip(Tile t,char or, Board b, boolean verbose){



        verbose=false;

        //Giving the orientation for ship's placement

        System.out.println("Please Give Orientation: ");

        //Case that Orientation is Horizontal
        if(or == 'h') {
            for( int j=t.getX(); j<(t.getX()+size); j++){


                b.board[t.getY()][j].setTileType(Tile.TileType.SHIP);


            }

        }
        //Case that Orientation is Vertical
        else if( or== 'v' ) {
            for(int i=t.getY(); i<(t.getY()+size); i++){

                b.board[i][t.getX()].setTileType(Tile.TileType.SHIP);
            }

        }
    }
}


