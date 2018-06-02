public boolean checkOverlap(Tile t,Board b,char or,boolean verbose)throws OverlapTilesException{
int x=t.getX();
int y=t.getY();
boolean FLAG=true;

if(or=='h'){
     int i=x;
     while( i<(x+size)){
	 if(b.board[y][i].getSymbol() == 's'){
	 FLAG=false;
	 if(verbose){
	  throw new OverlapTilesException();
	 }
	 break;
	 }
	 else i++; FLAG=true;
   }
}

if(or=='v'){
     int i=y;
     while( i<(y+size)){
	 if(b.board[i][x].getSymbol() == 's'){
	 FLAG=false;
	 if(verbose){
	  throw new OverlapTilesException();
	 }
	 break;
	 }
	 else i++; FLAG=true;
   }
}
return FLAG;
}