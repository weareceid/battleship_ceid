import java.util.*;


public abstract class Ship {

    protected int size;
    protected int[] startCell = new int[2];
    protected char orientation;


    //Constructor
    public Ship(int size, char orientation, int[] startCell) {
        this.size = size;
        this.orientation = orientation;
        this.startCell = startCell;
    }

    //Getters & Setters
    public int getSize() { return size; }

    public void setSize(int size) { this.size = size; }

    public int[] getStartCell() { return startCell; }

    public void setStartCell(int[] startCell) { this.startCell = startCell; }

    public char getOrientation() { return orientation; }

    public void setOrientation(char orientation) { this.orientation = orientation; }

    public boolean PlaceShip(Board board, Boolean verbose) throws OverlapTilesException, OversizeException, AdjacentTilesException {
        boolean FLAG = true;

        ArrayList<Tile> b = new ArrayList<Tile>();
        Tile arr[][] = new Tile[10][10];
        arr = board.getBoard();
        int m = 0, n = 0;

        if (orientation == 'h' && startCell[1] + size > arr.length - 1) {
            FLAG = false;
            if (verbose) {
                throw new OversizeException();
            }
        } else if (orientation == 'v' && startCell[0] + size > arr.length - 1) {
            FLAG = false;
            if (verbose) {
                throw new OversizeException();
            }
        } else {
            int i = 0;
            while (i < size) {
                if (arr[startCell[0]][startCell[1]].getType() != Tile.Type.SEA) {
                    FLAG = false;
                    if (verbose) {
                        throw new OverlapTilesException();
                    }
                    break;
                } else if (orientation == 'h') {
                    n = i;
                } else {
                    m = i;
                }

                b = board.getAdjacentTiles(arr[startCell[0] + m][startCell[1] + n], arr);
                for (int j = 0; j < b.size(); j++) {
                    if (b.get(j).getType() != Tile.Type.SEA) {
                        FLAG = false;
                        if (verbose) {
                            throw new AdjacentTilesException();
                        }
                        break;
                    }

                }
                i++;
            }
        }

        if (FLAG) {
            for (int i = 0; i <= size - 1; i++) {
                if (orientation == 'h') {
                    arr[startCell[0]][startCell[1] + i].setType(Tile.Type.SHIP);
                } else {
                    arr[startCell[0] + i][startCell[1]].setType(Tile.Type.SHIP);
                }

            }
            board.setBoard(arr);
        }
        return FLAG;

    }
}
