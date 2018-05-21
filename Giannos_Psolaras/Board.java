class Board{
 
 Tile board[][]=new Tile[10][10];  // The board Tile type that the game is played
 boolean hidden;  //usage for player identification
  
  public Board(){
	Tile s=new Tile(1,1,Tile.TileType.SHIP);
	//this.hidden=hidden; // i give if the player is human or pc
       for(int i=0; i<10; i++){
         for(int j=0; j<10; j++){
          board[i][j]=s;
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
		    
			
			/*getAdjacent(Tile t){
				
			}*/
			
   }	   
  }
