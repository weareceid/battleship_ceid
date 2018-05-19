import java.util.*;

public abstract class Ship {

  private Tile startCell;
  private char orient;
  private  int size;

  startCell = new Tile(
      
  public void placeShip(Tile startCell, char or, Board b, boolean verbose){
  
    boolean verbose=false;


   //Giving the orientation for ship's placement
   
    System.out.println("Please Give Orientation: ");

    //Case that Orientation is Horizontal
    if(or =="h") {
      
        for( int j=startCell; j<(startCell+size); j++){

         b[startCell][j] = s; 

        }

    }
    //Case that Orientation is Vertical
     else if(or== "v" ){
     
       for(int i=startCell; i<(startCell + size ); j++){

         b[i][startCell] = s ;
       }
     
     }
  }
    
}
