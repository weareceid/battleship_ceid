import java.util.*;

public abstract class Ship {

  private int startCellx;
  private int startCelly;
  private char orient;
  private  int size;

     
  public void placeShip(int x,int y, char or, Board b, boolean verbose){
  
    this.startCellx = x; 
    this.startCelly = y;

    verbose=false;


   //Giving the orientation for ship's placement
   
    System.out.println("Please Give Orientation: ");

    //Case that Orientation is Horizontal
    if(or == 'h') {
      
        for( int j=startCellx; j<(startCellx + size); j++){

         b[startCelly][j] = "s"; 

        }

    }
    //Case that Orientation is Vertical
     else if(or== 'v' ){
     
       for(int i=startCelly; i<(startCelly + size ); i++){

         b[i][startCellx] = "s" ;
       }
     
     }
  }
    
}
