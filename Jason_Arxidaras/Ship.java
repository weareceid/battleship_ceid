import java.util.*;

public  class Ship {

    private char orient;
    protected int size=3;


    public boolean placeShip(Tile t,char or, Board b, boolean verbose)throws OverlapTilesException,OversizeException,AdjacentTilesException{
        ArrayList<Tile> ad;
        boolean check=true;
        int k = 0, l = 0;

        if (or == 'h' && t.getX() + size > b.board.length - 1) {
            check = false;
            if (verbose) {
                throw new OversizeException();
            }
        } else if (or == 'v' && t.getY() + size > b.board.length - 1) {
            check = false;
            if (verbose) {
                throw new OversizeException();
            }
        } else {
            int i = 0;
            while (i < size) {
                if (b.board[t.getY()][t.getX()].getType() != Tile.TileType.SEA) {
                    check = false;
                    if (verbose) {
                        throw new OverlapTilesException();
                    }
                    break;
                } else if (or == 'h') {
                    l = i;
                } else {
                    k = i;
                }

                ad = b.getAdjacent(b.board[t.getY() + k][t.getX() + l], b);
                for (int j = 0; j < ad.size(); j++) {
                    if (ad.get(j).getType() != Tile.TileType.SEA) {
                        check = false;
                        if (verbose) {
                            throw new AdjacentTilesException();
                        }
                        break;
                    }

                }
                i++;
            }
        }

        if (check) {
            for (int i = 0; i <= size - 1; i++) {
                if (or == 'h') {
                    b.board[t.getY()][t.getX() + i].setTileType(Tile.TileType.SHIP);
                } else {
                    b.board[t.getY() + i][t.getX()].setTileType(Tile.TileType.SHIP);
                }

            }

        }
        return check;

    }
}