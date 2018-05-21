import java.util.*;

public  class Ship {

  private int startCellx;
  private int startCelly;
  private char orient;
  private  int size=3;


  public Ship(){}
//  Tile startCell;
     
  public void placeShip( char or, Board b, boolean verbose){
  
Tile  startCell = new Tile (2 , 2 , Tile.TileType.SEA);
    this.startCellx = startCell.getX(); 
    this.startCelly = startCell.getY();

    verbose=false;

   //Giving the orientation for ship's placement
   
    System.out.println("Please Give Orientation: ");

    //Case that Orientation is Horizontal
    if(or == 'h') {
        for( int j=startCellx; j<(startCellx+size); j++){
          
			
         b.board[startCelly][j].setTileType(Tile.TileType.SHIP);

			
        }

    }
    //Case that Orientation is Vertical
     else if( or== 'v' ) {
       for(int i=startCelly; i<(startCelly+size); i++){
           
         b.board[i][startCellx].setTileType(Tile.TileType.SHIP);
       }
     
     }
  }
}
