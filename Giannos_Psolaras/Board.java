import java.util.*;

public class Board{
 
 Tile board[][]=new Tile[10][10];  // The board Tile type that the game is played
 boolean hidden;  //usage for player identification
  
  public Board(){//constructor for board
    for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                Tile v=new Tile(i,j, Tile.TileType.SEA);
                board[i][j]=v;
            }
        }
  }
  
	   public  void drawboards(){
		   
			   System.out.println("    - - Y O U - -   ");
			   System.out.println(" 0 1 2 3 4 5 6 7 8 9");
			   
			  for(int i=0; i<10; i++){
               
				for(int j=0; j<11; j++){
				if(j==0){
					System.out.print(i);
					System.out.print(" ");
				}
					else{
						board[i][j-1].draw(false);
						System.out.print(" ");
					}
				}
				 System.out.println();
			  }
		   
		     System.out.println();
			   System.out.println(" - O P P O N E N T -");
			   System.out.println(" 0 1 2 3 4 5 6 7 8 9");
			   
			  for(int i=0; i<10; i++){
                
				for(int j=0; j<11; j++){
				if(j==0){
					System.out.print(i);
					System.out.print(" ");
				}
					else{
						board[i][j-1].draw(true);
						System.out.print(" ");
					}
				}System.out.println();
				
			  }
	   }
			public ArrayList<Tile> getAdjacent(Tile t,Tile pin[][]){  //give argument Tile and return arrayist Tile
			   ArrayList<Tile> check=new ArrayList<Tile>();
				check.add(pin[t.getY()][t.getX()-1]);
				check.add(pin[t.getY()+1][t.getX()]);
				check.add(pin[t.getY()][t.getX()+1]);
				check.add(pin[t.getY()-1][t.getX()]);
				 
				 return check;
			}
   }	   
  
