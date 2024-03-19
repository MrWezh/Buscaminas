package Buscaminas;
import java.util.*;


public class InOut {

    private int x; 
    private int y; 

    private int a; 
    private int b; 

    private String options; 

    Scanner wz; 
   private Tablero tablero; 


    InOut(){
        wz = new Scanner(System.in);
        tablero = new Tablero();

    }

    public Tablero getTablero_Inout(){

        return this.tablero;
    }

    

    public boolean lose(){
        
        if (this.options.equals("d")){ return  tablero.getMines(this.a, this.b);}
        else{ return false;}
}
    public void initBoard() {

        System.out.println("Introduzca las dimensiones (x, y) del tablero: ");

        System.out.println("Introduzca el número de filas (x): ");
        int x = wz.nextInt();
        tablero.setX(x);
        this.x = x; 

        System.out.println("Introduzca el número de columnas (y): ");
        int y = wz.nextInt();
        tablero.setY(y);
        this.y = y;
        
        System.out.println("Introduzca la cantidad de minas: ");
        int q = wz.nextInt();
        tablero.setQ(q);
     


    }


  public void askCoordinateToClick() {
    int a, b;

    System.out.println("Indroduzca las coordenadas (SEPARADO POR ESPACIO): ");

    a = wz.nextInt();
    b = wz.nextInt();

    boolean incorrect = (a < 0 || b < 0 || a >= this.x || b >= this.y);

    while (incorrect) {
        System.out.println("Coordenada INCORRECTA!");
        System.out.println("Introduzca las coordenadas nuevamente (SEPARADO POR ESPACIO): ");
        a = wz.nextInt();
        b = wz.nextInt();
        incorrect = (a < 0 || b < 0 || a >= this.x || b >= this.y);
    }

    this.a = a;
    this.b = b;

    System.out.println("F poner flags, Q quitar flags y D  descubrir casillas:");
    String option = wz.next().toLowerCase();
    this.options = option; 
    switch (option) {
        case "d": 
            if (tablero.getBox(a,b) != Square.flag)tablero.click(this.a, this.b);
            else System.out.println("Hay un flag");
            break;
        case "f":
            if (tablero.getBox(this.a, this.b) == Square.Nohidden){
                System.out.println("No se puede poner flags en casillas ya DESCUBIERTAS");}
                
            else tablero.flag(this.a, this.b);
            break;
        case "q":
                if (tablero.getBox(a, b) == Square.flag) {
                    
                    if (tablero.getTablero(a, b) == -1) {
                        tablero.setBox(a, b, Square.mine);
                    } else if (tablero.getTablero(a, b) == 0)
                        tablero.setBox(a, b, Square.water);

                    else
                        tablero.setBox(a, b, Square.clue);
                    
                }
                
        default:
            System.out.println("Opción Incorrecta!");
            break;
    }
}

}
