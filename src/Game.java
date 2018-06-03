import java.awt.*;
import java.util.*;
import java.io.*;
import javax.swing.*;

public class Game {

private int[] marks;
   private String[] marks1;
    private String[] marks2;
    private JTextField[] marksField;
    private JLabel resultLabel;

    public Game()
    {

        marksField = new JTextField[2];
        marksField[0] = new JTextField(10);
        marksField[1] = new JTextField(10);

    }


    private boolean randomPlace()
    {     boolean read=true;
       marks1=new String[1];

        int selection = JOptionPane.showConfirmDialog(
                null, getPanel1(), "Random or Not : "
                , JOptionPane.OK_CANCEL_OPTION
                , JOptionPane.PLAIN_MESSAGE);

        if (selection == JOptionPane.OK_OPTION)
        {

            marks1[0] = String.valueOf(marksField[0].getText());

            if (marks1[0].equals("Y")) {
                read = true;
            }
            else if (marks1[0].equals("N")) {
                read = false;
            }

        }
        else if (selection == JOptionPane.CANCEL_OPTION)
        {
            // Do something here.
        }

        return read;

    }


    private char getOrientation()
    {     char read='h';
        marks2=new String[1];
//char[] c=new char[1];
        int selection = JOptionPane.showConfirmDialog(
                null, getPanel2(), "Orientation : "
                , JOptionPane.OK_CANCEL_OPTION
                , JOptionPane.PLAIN_MESSAGE);

        if (selection == JOptionPane.OK_OPTION)
        {

            marks2[0] = String.valueOf(marksField[0].getText());
            if (marks2[0].equals("v")) {
                read = 'v';
            }

        }
        else if (selection == JOptionPane.CANCEL_OPTION)
        {
            // Do something here.
        }

        return read;

    }

    private int[] getInput()
    { marks=new int[2];
        int selection = JOptionPane.showConfirmDialog(
                null, getPanel(), "Coordinates : "
                , JOptionPane.OK_CANCEL_OPTION
                , JOptionPane.PLAIN_MESSAGE);

        if (selection == JOptionPane.OK_OPTION)
        {
            for ( int i = 0; i < 2; i++)
            {
                marks[i] = Integer.valueOf(marksField[i].getText());
            }

        }
        else if (selection == JOptionPane.CANCEL_OPTION)
        {
            // Do something here.
        }
        return marks;
    }

    private JPanel getPanel()
    {
        JPanel basePanel = new JPanel();
        //basePanel.setLayout(new BorderLayout(5, 5));
        basePanel.setOpaque(true);
        basePanel.setBackground(Color.BLUE.darker());

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3, 2, 5, 5));
        centerPanel.setBorder(
                BorderFactory.createEmptyBorder(5, 5, 5, 5));
        centerPanel.setOpaque(true);
        centerPanel.setBackground(Color.WHITE);

        JLabel mLabel1 = new JLabel("Enter X : ");
        JLabel mLabel2 = new JLabel("Enter Y : ");


        centerPanel.add(mLabel1);
        centerPanel.add(marksField[0]);
        centerPanel.add(mLabel2);
        centerPanel.add(marksField[1]);


        basePanel.add(centerPanel);

        return basePanel;
    }

    private JPanel getPanel1()
    {
        JPanel basePanel = new JPanel();
        //basePanel.setLayout(new BorderLayout(5, 5));
        basePanel.setOpaque(true);
        basePanel.setBackground(Color.BLUE.darker());

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3, 2, 5, 5));
        centerPanel.setBorder(
                BorderFactory.createEmptyBorder(5, 5, 5, 5));
        centerPanel.setOpaque(true);
        centerPanel.setBackground(Color.WHITE);

        JLabel mLabel1 = new JLabel("Enter Y or N  ");



        centerPanel.add(mLabel1);
        centerPanel.add(marksField[0]);



        basePanel.add(centerPanel);

        return basePanel;
    }



    private JPanel getPanel2()
    {
        JPanel basePanel = new JPanel();
        //basePanel.setLayout(new BorderLayout(5, 5));
        basePanel.setOpaque(true);
        basePanel.setBackground(Color.BLUE.darker());

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3, 2, 5, 5));
        centerPanel.setBorder(
                BorderFactory.createEmptyBorder(5, 5, 5, 5));
        centerPanel.setOpaque(true);
        centerPanel.setBackground(Color.WHITE);

        JLabel mLabel1 = new JLabel("Enter h or v for orientation : ");



        centerPanel.add(mLabel1);
        centerPanel.add(marksField[0]);



        basePanel.add(centerPanel);

        return basePanel;
    }

    public static void main(String args[]) throws OverlapTilesException, OversizeException, AdjacentTilesException, IOException{
        // TODO code application logic here
       // Scanner sc = new Scanner(System.in);

        Player User = new Player("Player");
        Player Comp = new Player("Bot");

        //System.out.println("Do you want to place your ships randomly or manually ? Press Y for randomly placement and N for manually placement : ");

        if (new Game().randomPlace()) {
            User.placeAllShips();
            Comp.placeAllShips();
        } else {
            int cor[] = new int[2];
            boolean check;

       //     System.out.println("Give coordinates X Y for Carrier (size 5");
            cor = new Game().getInput();
            Carrier Ca = new Carrier(5, new Game().getOrientation(), cor);
            check = User.placeShip(Ca);
            Board.drawboards(User.getPlayerBoard().getBoard(), Comp.getPlayerBoard().getBoard());

          //  System.out.println("Give coordinates X Y for Battleship (size 4)");
            cor =new Game().getInput();
            Battleship Ba = new Battleship(4, new Game().getOrientation(), cor);
            check = User.placeShip(Ba);
            Board.drawboards(User.getPlayerBoard().getBoard(), Comp.getPlayerBoard().getBoard());

           // System.out.println("Give coordinates X Y for Cruiser (size 3)");
            cor =new Game().getInput();
            Cruiser Cr = new Cruiser(3,new Game().getOrientation(), cor);
            check = User.placeShip(Cr);
            Board.drawboards(User.getPlayerBoard().getBoard(), Comp.getPlayerBoard().getBoard());

          //  System.out.println("Give coordinates X Y for Battleship (size 2)");
            cor =new Game().getInput();
            Destroyer De = new Destroyer(2, new Game().getOrientation(), cor);
            check = User.placeShip(De);
            Board.drawboards(User.getPlayerBoard().getBoard(), Comp.getPlayerBoard().getBoard());

           // System.out.println("Give coordinates X Y for Battleship (size 3)");
            cor =new Game().getInput();
            Submarine Su = new Submarine(3, new Game().getOrientation(), cor);
            check = User.placeShip(Su);

            Comp.placeAllShips();

        }
        Board.drawboards(User.getPlayerBoard().getBoard(), Comp.getPlayerBoard().getBoard());

        boolean check = true;
        System.out.println("   Game Started");
        do {
          //  System.out.println("Give coordinates X Y for fire :");
            Comp.getPlayerBoard().setBoard(User.fire(Comp.getPlayerBoard().getBoard(),new Game().getInput()));
            User.getPlayerBoard().setBoard(Comp.fire(User.getPlayerBoard().getBoard(), getRandInput()));
            Board.drawboards(User.getPlayerBoard().getBoard(), Comp.getPlayerBoard().getBoard());

            if (Comp.getPlayerBoard().allShipsSunk()) {
                System.out.println("You Won !");
                check = false;
            } else if (User.getPlayerBoard().allShipsSunk()) {
                System.out.println("Game Over !");
            }

        } while (check);

        Comp.getStats();
        User.getStats();

    }



    static int[] getRandInput() {
        Random rand = new Random();
        int pin[] = new int[2];
        pin[0] = rand.nextInt(10);
        pin[1] = rand.nextInt(10);
        return pin;
    }

   static char getRandOrientation() {
        Random rand = new Random();
        int r = rand.nextInt(2);
        if (r == 0) {
            return 'h';
        } else return 'v';

    }

   /* static boolean randomPlace() throws IOException {
        boolean read = true;

        System.out.println("insert Y or N ");
        char c = (char) System.in.read();
        if (c == 'Y') {
            read = true;
        } else if (c == 'N') {
            read = false;
        }
        return read;
    }*/

   /* static char getOrientation()throws IOException{
        char s=' ';
        System.out.println("Give h or v for orientation ");

        char c=(char)System.in.read();
        if(c=='h'){
            s= 'h' ;
        }
        else if(c=='v'){
            s= 'v' ;
        }
        return s;
    }*/
}
