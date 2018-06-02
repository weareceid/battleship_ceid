import java.util.*;

public class Board {

    private Tile pin[][] = new Tile[10][10];

    public Board() {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                pin[i][j] = new Tile(i, j, Tile.Type.SEA);
            }
        }

    }

    public Tile[][] getPin() {
        return pin;
    }

    public void setPin(Tile[][] pin) {
        this.pin = pin;
    }

  static  public void drawboards(Tile[][] pin1,Tile[][] pin2) {

        System.out.println("    - - Y O U - -   ");
        System.out.println("  0 1 2 3 4 5 6 7 8 9");

        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 11; j++) {
                if (j == 0) {
                    System.out.print(i);
                    System.out.print(" ");
                } else {
                    pin1[i][j - 1].draw(false);
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        System.out.println();
        System.out.println(" - O P P O N E N T -");
        System.out.println("  0 1 2 3 4 5 6 7 8 9");

        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 11; j++) {
                if (j == 0) {
                    System.out.print(i);
                    System.out.print(" ");
                } else {
                    pin2[i][j - 1].draw(true);
                    System.out.print(" ");
                }
            }
            System.out.println();

        }
    }

    void placeAllShips() throws OverlapTilesException, OversizeException, AdjacentTilesException {
        Board b = this;
        int cor[] = new int[2];

        cor = Game.getRandInput();
        Carrier Ca = new Carrier(5, Game.getRandOrientation(), cor);
        boolean check = false;

        while (!check) {
            check = Ca.PlaceShip(b, false);
            cor = Game.getRandInput();
            if (!check) {
                Ca.setCellStart(cor);
            }
        }

        check = false;
        Battleship Ba = new Battleship(4, Game.getRandOrientation(), cor);
        while (!check) {
            check = Ba.PlaceShip(b, false);
            cor = Game.getRandInput();
            if (!check) {
                Ba.setCellStart(cor);
            }
        }

        check = false;
        Cruiser Cr = new Cruiser(3, Game.getRandOrientation(), cor);
        while (!check) {
            check = Cr.PlaceShip(b, false);
            cor = Game.getRandInput();
            if (!check) {
                Cr.setCellStart(cor);
            }
        }

        check = false;
        Destroyer De = new Destroyer(2, Game.getRandOrientation(), cor);
        while (!check) {
            check = De.PlaceShip(b, false);
            cor = Game.getRandInput();
            if (!check) {
                De.setCellStart(cor);
            }
        }

        check = false;
        Submarine Su = new Submarine(3, Game.getRandOrientation(), cor);
        while (!check) {
            check = Su.PlaceShip(b, false);
            cor = Game.getRandInput();
            if (!check) {
                Su.setCellStart(cor);
            }
        }
    }

    ArrayList<Tile> getAdjacentTiles(Tile t, Tile[][] pin) {
        ArrayList<Tile> b = new ArrayList();

        if (t.getY() + 1 < 10) {
            b.add(pin[t.getX()][t.getY() + 1]);
        }

        if (t.getX() + 1 < 10) {
            b.add(pin[t.getX() + 1][t.getY()]);
        }

        if (t.getY() - 1 >= 0) {
            b.add(pin[t.getX()][t.getY() - 1]);
        }

        if (t.getX() - 1 >= 0) {
            b.add(pin[t.getX() - 1][t.getY()]);
        }

        return b;

    }

    boolean allShipsSunk() {
        boolean b = true;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (pin[i][j].getType() == Tile.Type.SHIP) {
                    b = false;
                }
            }
        }
        return b;
    }

}
