package Buscaminas;

public class Main {
    public static void main(String[] args){
 
         InOut inout = new InOut();
        Clear clear = new Clear();

        inout.initBoard(); 
        inout.getTablero_Inout().init();
        inout.getTablero_Inout().print(false);
       

         while (true){

            

                    inout.askCoordinateToClick();
                    clear.clearScreen();
                    if (inout.lose()){
                        inout.getTablero_Inout().print(true); 
                        System.out.println("BOOOOOOOOMM!!!!");break;}
        
                    if(inout.getTablero_Inout().winGame()){
                        inout.getTablero_Inout().print(false);
                        System.out.println("YOU WIN!!!!");break;}

                    inout.getTablero_Inout().print(false);

        }
    
    }
    
}
