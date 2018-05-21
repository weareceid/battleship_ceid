public class B{
    public static void main(String args[]){
        Board c=new Board();
          Ship p=new Ship();
/*for(int i=0; i<10; i++)
  for(int j=0; j<10; j++){
System.out.println(c.board[i][j].getSymbol());
}
}*/
    //    c.drawboards();

        p.placeShip(c.board[3][3],'h',c,false);
        c.drawboards();


    }
}
