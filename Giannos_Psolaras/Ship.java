import java.util.*;

public  class Ship {

  private int startCellx;
  private int startCelly;
  private char orient;
  private  int size=3;

     
  public void placeShip(int x,int y, char or, Board b, boolean verbose){
  
    this.startCellx = x; 
    this.startCelly = y;

    verbose=false;

   //Giving the orientation for ship's placement
   
    System.out.println("Please Give Orientation: ");

    //Case that Orientation is Horizontal
    if(or == 'h') {
Tile v=new Tile(0,0,Tile.TileType.SHIP);
        for( int j=startCellx; j<size; j++){
          
			
         b.board[startCelly][j]=v; 

			
        }

    }
    //Case that Orientation is Vertical
     else if( or== 'v' ) {
      Tile v=new Tile(0,0,Tile.TileType.SHIP);
       for(int i=startCelly; i<size; i++){
           
         b.board[i][startCellx]=v ;
       }
     
     }
  }
    
}