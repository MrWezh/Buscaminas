package Buscaminas;
import java.util.*;

public class Tablero {

    Scanner wz; 
    
    private boolean[][] mines; 
    private Square[][] box; 
    private int[][] tablero; 

    private int x; // Las filas que tendran las matrices
    private int y;//las columnas que tendran las mastrices
    private int q; //Cantidad de minas que abrá


    Tablero(){
        wz = new Scanner(System.in);
        
    }

    public Square getBox(int a, int b){

        return this.box[a][b];

    }
    

public int getX() {
    return x;
}

public void setX(int a){
    
   if (a>=2) {this.x = a;}
   else {System.out.println("ERROR, MÍNIMO hay que tener 2 filas!"); 
            while (true){
        System.out.println("Indroduzca el número de filas CORRECTAMENTE: ");
        a = wz.nextInt();
        if (a >= 0) {this.x = a; break;}
        else {System.out.println("ERROR, MÍNIMO hay que tener 2 filas!");}     
        }
    }
    
}

public int getY() {
    return y;
}


public void setY(int a){
    
    if (a>=2) {this.y = a;}
   else {System.out.println("ERROR, MÍNIMO hay que tener 2 columnas!"); 
            while (true){
        System.out.println("Indroduzca el número de columnas CORRECTAMENTE: ");
        a = wz.nextInt();
        if (a >= 0) {this.y = a; break;}
        else {System.out.println("ERROR, MÍNIMO hay que tener 2 columnas!");}     
        }
    }
    
}


    public int getQ() {
    return q;
}


public void setQ(int a) {
    if (a>=1&&a<(this.x*this.y)) {this.q = a;}
   else {System.out.println("ERROR, MINIMO hay que tener 1 minas en el campo!"); 
            while (true){
        System.out.println("Indroduzca el número de columnas CORRECTAMENTE: ");
        a = wz.nextInt();
        if (a >= 0) {this.q = a; break;}
        else {System.out.println("ERROR, MINIMO hay que tener 1 minas en el campo!");}     
        }
    }
}

public Square[][] getBox() {
    return box;
}

public void setBox(int a, int b, Square squares) {
    this.box[a][b] = squares;
}

public int getTablero(int a, int b) {
    return tablero[a][b];
}


public void setTablero(int a,int b,int tablero) {
    this.tablero[a][b] = tablero;
}

public boolean getMines(int x, int y) {

        return mines[x][y];
    }

 public void setMines(boolean[][] mines) {
        this.mines = mines;
    }

    public void click(int a, int b){

       if (box[a][b] != Square.Nohidden){ 
            
            box [a][b] =Square.Nohidden;
            this.DescubrirHidden();
            this.print(false);
        }

        else {this.print(false);} 
    }


    public void DescubrirHidden(){

        //Cuando ecuentre una casilla descubierta y es 0, descubre las casillas de su alrededor

            for (int k = 0; k < this.x; k++) {
                for (int k2 = 0; k2 < this.y; k2++) {

                    
                    if (this.tablero[k][k2]==0 && box[k][k2] == Square.Nohidden){
                        if (k2 - 1 >= 0&&(box[k][k2-1]!=Square.mine)){box[k][k2-1]=Square.Nohidden;}
                        if (k2 + 1 < y&&(box[k][k2+1]!=Square.mine)){box[k][k2+1]=Square.Nohidden;}
                        if (k - 1 >= 0&&(box[k-1][k2]!=Square.mine)){box[k-1][k2]=Square.Nohidden;}
                        if (k + 1 < x&&(box[k+1][k2]!=Square.mine)){box[k+1][k2]=Square.Nohidden;}
            
                        if (k2 - 1 >= 0 && k - 1 >= 0&&(box[k-1][k2-1]!=Square.mine)){box[k-1][k2-1]=Square.Nohidden;}
                        if (k2 + 1  < y && k - 1 >= 0&&(box[k-1][k2+1]!=Square.mine)){box[k-1][k2+1]=Square.Nohidden;}
                        if (k2 - 1 >= 0 && k + 1 < x&&(box[k+1][k2-1]!=Square.mine)){box[k+1][k2-1]=Square.Nohidden;}
                        if (k2 + 1 < y && k + 1 < x&&(box[k+1][k2+1]!=Square.mine)){box[k+1][k2+1]=Square.Nohidden;}
                    }
                }
        }

        for (int k = this.x-1; k >= 0; k--) {
                for (int k2 = this.y-1; k2 >= 0; k2--) {
                    
                    if (this.tablero[k][k2]==0 && box[k][k2] == Square.Nohidden){
                        if (k2 - 1 >= 0&&(box[k][k2-1]!=Square.mine)){box[k][k2-1]=Square.Nohidden;}
                        if (k2 + 1 < y&&(box[k][k2+1]!=Square.mine)){box[k][k2+1]=Square.Nohidden;}
                        if (k - 1 >= 0&&(box[k-1][k2]!=Square.mine)){box[k-1][k2]=Square.Nohidden;}
                        if (k + 1 < x&&(box[k+1][k2]!=Square.mine)){box[k+1][k2]=Square.Nohidden;}
            
                        if (k2 - 1 >= 0 && k - 1 >= 0&&(box[k-1][k2-1]!=Square.mine)){box[k-1][k2-1]=Square.Nohidden;}
                        if (k2 + 1  < y && k - 1 >= 0&&(box[k-1][k2+1]!=Square.mine)){box[k-1][k2+1]=Square.Nohidden;}
                        if (k2 - 1 >= 0 && k + 1 < x&&(box[k+1][k2-1]!=Square.mine)){box[k+1][k2-1]=Square.Nohidden;}
                        if (k2 + 1 < y && k + 1 < x&&(box[k+1][k2+1]!=Square.mine)){box[k+1][k2+1]=Square.Nohidden;}
                    }
                }
        }

    }

   public void print(boolean gameOver){

    System.out.printf("%-6s", " ");
    for (int n = 0; n < this.x; n++) {
        System.out.printf("%-4s",n);
        
        
    }
    System.out.println();
    System.out.printf("%-6s", " ");
    for (int n = 0; n < this.x; n++) {
        System.out.printf("%-4s", "─");

    }
   
    System.out.println();

    System.out.printf("%-4s", " ");
    for (int n = 0; n < this.x*4+1 ; n++) {

        System.out.print("▄");
        
    }
    System.out.println();

    for (int i = 0; i < this.x; i++) {

        System.out.printf("%-4s", i+" |");
        System.out.print("█ ");

        
        for (int j = 0; j < this.y; j++) {

            if (gameOver){

                if (this.tablero[i][j] == -1) {
                    if (j == this.x-1){System.out.print("@ █");}
                    else {System.out.printf("%-4s","@");}
                }
                else if (this.tablero[i][j] == 0) {
                    if (j == this.x-1) {System.out.print("  █");}
                    else {System.out.printf("%-4s"," ");}
                }
                else {
                    if (j == this.x-1) {System.out.print(this.tablero[i][j]+" █");}
                    else System.out.printf("%-4s",this.tablero[i][j]);
                }

            }

            else{

                if (this.box[i][j]==Square.flag){
                    if (j == this.x-1){System.out.print("X █");}
                    else {System.out.printf("%-4s","X");}
                }
                else if (box[i][j] != Square.Nohidden){
                    if (j == this.x-1){System.out.print("# █");}
                    else{ System.out.printf("%-4s","#");}
                }
                else {
                    if (this.tablero[i][j] == 0) {
                        if (j == this.x-1) {System.out.print("  █");}
                        else {System.out.printf("%-4s"," ");}
                    }
                    else {
                        if (j == this.x-1) {System.out.print(this.tablero[i][j]+" █");}
                        else{ System.out.printf("%-4s",this.tablero[i][j]);}
                    }

                }

            }

        }
        
        System.out.println();
    }

    System.out.printf("%-4s", " ");
    for (int n = 0; n < this.x*4+1 ; n++) {

        System.out.print("▀");
        
    }
    System.out.println();

}


    public void init(){

      this.box = new Square[this.x][this.y];
       this.mines = new boolean[this.x][this.y];
       this.tablero = new int[this.x][this.y];


        //Marcar todo el tablero como water(casillas sin numeros de pista ni minas)
        for (int l = 0; l < this.x; l++) {
            for (int m = 0; m < this.y; m++) {

                this.box[l][m] = Square.water; 
                this.mines[l][m] = false; 
                this.tablero[l][m] = 0; 

            }
        }
            
        //colocar las mnas en sitios radoms de la matriz tablero.

        Random random = new Random();

        for (int i = 0; i < q; i++) {
        int CoordenadaXRadoms = random.nextInt(0,this.x);
        int CoordenadaYRadoms = random.nextInt(0,this.y);

        if (this.mines[CoordenadaXRadoms][CoordenadaYRadoms]) i--;

        this.mines[CoordenadaXRadoms][CoordenadaYRadoms] = true; 
        this.box[CoordenadaXRadoms][CoordenadaYRadoms] = Square.mine; 
        this.tablero[CoordenadaXRadoms][CoordenadaYRadoms] = -1; 
        }

        //Inicializar la matriz tablero
        for (int i = 0; i < this.tablero.length; i++){
            for(int j = 0; j < this.tablero[i].length; j++){

                if (tablero[i][j] == -1){
                if (j - 1 >= 0&&tablero[i][j-1] != -1){tablero[i][j-1]++;box[i][j-1]=Square.clue;}
                if (j + 1 < y&&tablero[i][j+1] != -1){tablero[i][j+1]++;box[i][j+1]=Square.clue;}
                if (i - 1 >= 0&&tablero[i-1][j] != -1){tablero[i-1][j]++;box[i-1][j]=Square.clue;}
                if (i + 1 < x&&tablero[i+1][j] != -1){tablero[i+1][j]++;box[i+1][j]=Square.clue;}

                if (j - 1 >= 0 && i - 1 >= 0&&tablero[i-1][j-1] != -1){tablero[i-1][j-1]++;box[i-1][j-1]=Square.clue;}
                if (j + 1  < y && i - 1 >= 0&&tablero[i-1][j+1] != -1){tablero[i-1][j+1]++;box[i-1][j+1]=Square.clue;}
                if (j - 1 >= 0 && i + 1 < x&&tablero[i+1][j-1] != -1){tablero[i+1][j-1]++;box[i+1][j-1]=Square.clue;}
                if (j + 1 < y && i + 1 < x&&tablero[i+1][j+1] != -1){tablero[i+1][j+1]++;box[i+1][j+1]=Square.clue;}
            }
            }
        }

    }

    public boolean winGame(){

        int contador = 0; 
        int contadorFlag = 0; 

        for (int l = 0; l < this.x; l++) {
            for (int m = 0; m < this.y; m++) {

                if (this.box[l][m] == Square.Nohidden){
                    contador++;
                }
                if (this.box[l][m] == Square.flag&&this.mines[l][m] == true){
                    contadorFlag++;
                }
                
            }
            
        }

        if (contador == this.q){return true;} 
        else if (contadorFlag == this.q) {return true;}
        else {return false;} 

    }



   public void flag(int a, int b){

    int contadorFlag = 0;

    for (int l = 0; l < this.x; l++) {
        for (int m = 0; m < this.y; m++) {
            if (this.box[l][m] == Square.flag){
                contadorFlag++;
            }
        }
    }
        
       if (contadorFlag <= this.q) {box[a][b] = Square.flag;}
        else{System.out.println("Bandera insuficiente");} 

    }


}
    


