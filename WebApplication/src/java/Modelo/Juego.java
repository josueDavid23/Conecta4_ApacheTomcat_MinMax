
package Modelo;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Juego {
    private final Tablero tablero;
    private final  IA ai;
    private final Jugador j1=new Jugador(new Ficha(1,"https://image.ibb.co/dyzE8e/cuadroR.jpg","https://image.ibb.co/gp2ebz/cuadroRF.jpg")) ;;
    private final Jugador j2= new Jugador(new Ficha(2,"https://image.ibb.co/mN0yZK/cuadroA.jpg","https://image.ibb.co/eH37UK/cuadroAF.jpg")) ; 
    private Ganador ganador=new Ganador();;
    private boolean primerMovimientoIA=true;

    public void setPrimerMovimientoIA(boolean primerMovimientoIA) {
        this.primerMovimientoIA = primerMovimientoIA;
    }
    
    /*
    Juego cuenta con dos jugadores
        Ganador
        Tablero -> ficha
    */
    public Juego(int tamanoF, int tamanoC,int dificultad){
        this.ai= new IA(dificultad);
        this.tablero = new Tablero(tamanoF,tamanoC);   
    }

    //METODOS SET GET DEL DOSS//
    
    public void setGanador(Ganador ganador) {
        this.ganador = ganador;
    }

    public Ganador getGanador() {
        return ganador;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public Jugador getJ1() {
        return j1;
    }

    public Jugador getJ2() {
        return j2;
    }
    
    // Funcion en la cual se retorna el mensaje a mostrar en 
    // pantalla segun el jugador que haya sido el ganador
    // Al ser color tipo 1 muestra GANA IA ROJAS
    // Al ser colot tipo 2 muestra GANASTE AMARILLAS
    
    public String envioGanador(Jugador j){
        Map<Integer, String> map = new HashMap<>();
        map.put(this.j1.getTipoFicha().getColor(), "GANA IA: ROJAS");	map.put(this.j2.getTipoFicha().getColor(), "GANASTE: AMARILLAS");	
        return  map.get(j.getTipoFicha().getColor());
    }
    
    /*VALIDACIONES
        Llama a la funcion de validar diagonales izquierda
        validar diagonal derecha
        validar horizontales
        validar verticales
    
    */
    public void validaciones(Jugador j){
        ArrayList<Ganador> ganadoresLista = new ArrayList<>();
        ganadoresLista.add(this.validaColumnas(j));
        ganadoresLista.add(this.validaFilas(j));
        ganadoresLista.add(this.validaDiagonalSuperiorD(j));
        ganadoresLista.add(this.validaDiagonalSuperiorI(j));
        for(int i=0; i<ganadoresLista.size();i++){
            if(ganadoresLista.get(i).getContador()>=4){
                this.ganador.setFilas(ganadoresLista.get(i).getFilas());
                this.ganador.setCols(ganadoresLista.get(i).getCols());
                this.ganador.setResultado(this.envioGanador(j));
                this.tablero.setMatrizGane(this.ganador.cambiarFichas(this.tablero, j));break;} // cambian fichas del gane
        }
    }
   
    /* Valida Columnas Recorre la matriz desde la ultima pos del jugador i j hacia la derecha
    Recibe Jugador actual
    */
    public Ganador validaColumnas(Jugador j){
        Ganador g = new Ganador();
        for(int i=j.getUltimoMovimiento()[1]+1;i<this.getTablero().getColumnas();i++){
            if(this.tablero.getMatriz()[j.getUltimoMovimiento()[0]][i].getColor()==j.getTipoFicha().getColor()){
                g.setFilas(j.getUltimoMovimiento()[0]);g.setCols(i);g.setContador(); }
            else{break;}}
        return this.validaColumnasAux(j,g);
    }
    
    /* Valida Columnas Recorre la matriz desde la ultima pos del jugador i j hacia la izquierda
    Recibe Jugador actual
    */
    public Ganador validaColumnasAux(Jugador j, Ganador g){
        for(int i=j.getUltimoMovimiento()[1]-1;i>=0;i--){
            if(this.tablero.getMatriz()[j.getUltimoMovimiento()[0]][i].getColor()==j.getTipoFicha().getColor()){
                g.setFilas(j.getUltimoMovimiento()[0]);g.setCols(i);g.setContador(); }
            else{break;}}
        return g;
    }
    
     /* Valida Filas Recorre la matriz desde la ultima pos del jugador i j hacia la parte superior
    Recibe Jugador actual
    */
    
    public Ganador validaFilas(Jugador j){
        Ganador g = new Ganador();
        for(int i=j.getUltimoMovimiento()[0]+1;i<this.getTablero().getFilas();i++){
            if(this.tablero.getMatriz()[i][j.getUltimoMovimiento()[1]].getColor()==j.getTipoFicha().getColor()){
                g.setContador();g.setFilas(i);g.setCols(j.getUltimoMovimiento()[1]); }
            else{break;}}
        return this.validaFilasAux(j,g);
    }
      /* Valida Columnas Recorre la matriz desde la ultima pos del jugador i j hacia la parte inferior
    Recibe Jugador actual
    */
     public Ganador validaFilasAux(Jugador j, Ganador g){
        for(int i=j.getUltimoMovimiento()[0]-1;i>=0;i--){
            if(this.tablero.getMatriz()[i][j.getUltimoMovimiento()[1]].getColor()==j.getTipoFicha().getColor()){
                 g.setContador();g.setFilas(i);g.setCols(j.getUltimoMovimiento()[1]); }
            else{break;}}
        return g;
    }
     
      /* Valida Diagoanles Superior Derecha Recorre la matriz desde la ultima pos del jugador i j 
    Recibe Jugador actual
    */
    public Ganador validaDiagonalSuperiorD(Jugador j){
        Ganador g = new Ganador();
        int fila=j.getUltimoMovimiento()[0]-1; // fila
        int col=j.getUltimoMovimiento()[1]+1; // col
        while(fila>=0 && col < this.tablero.getColumnas()){
            if(this.tablero.getMatriz()[fila][col].getColor()==j.getTipoFicha().getColor()){
                g.setContador();g.setFilas(fila);g.setCols(col);fila--;col++; }
            else{break;}}
        
        return this.validaDiagonalInferiorD(j,g); 
    }
    
       /* Valida Diagoanles Inferior derecha Recorre la matriz desde la ultima pos del jugador i j 
    Recibe Jugador actual
    */
    public Ganador validaDiagonalInferiorD(Jugador j, Ganador g){
        int fila=j.getUltimoMovimiento()[0]+1; // fila
        int col=j.getUltimoMovimiento()[1]-1; // col
        while(fila<this.tablero.getFilas() && col >= 0){
            if(this.tablero.getMatriz()[fila][col].getColor()==j.getTipoFicha().getColor()){
                g.setContador();g.setFilas(fila);g.setCols(col); fila++;col--; }
            else{break;}}
        
        return g; 
    }
          /* Valida Diagoanles Superiores Izquierda Recorre la matriz desde la ultima pos del jugador i j 
    Recibe Jugador actual
    */
     public Ganador validaDiagonalSuperiorI(Jugador j){
        Ganador g = new Ganador();
        int fila=j.getUltimoMovimiento()[0]-1; // fila
        int col=j.getUltimoMovimiento()[1]-1; // col
        while(fila>=0 && col >= 0 ){
            if(this.tablero.getMatriz()[fila][col].getColor()==j.getTipoFicha().getColor()){
                g.setContador();g.setFilas(fila);g.setCols(col); fila--;col--; }
            else{break;}}
        
        return this.validaDiagonalInferiorI(j,g); 
    
     }
     
            /* Valida Diagoanles Inferior Izquierda Recorre la matriz desde la ultima pos del jugador i j 
    Recibe Jugador actual
    */
     public Ganador validaDiagonalInferiorI(Jugador j, Ganador g){
        int fila=j.getUltimoMovimiento()[0]+1; // fila
        int col=j.getUltimoMovimiento()[1]+1; // col
        while(fila<this.tablero.getFilas() && col < this.tablero.getColumnas()){
            if(this.tablero.getMatriz()[fila][col].getColor()==j.getTipoFicha().getColor()){
                g.setContador();g.setFilas(fila);g.setCols(col); fila++;col++; }
            else{break;}}
        
        return g; 
    }
     
     /*Turno, encargada de realizar el movimiento de 
     inteligencia artificial y del jugador 
     tambien  se llama a la  funcion encargada de verificar el gane
     Al recibir la opcion del boton se envia a realizar movimiento para hacer el cambio de la matriz
     */
     
     public void mover(int x){ // si j1 activo aplicar minimax cambiar tablero movimiento por min max OJO
         if(this.j1.getTurnoActivo() == true){
             if(this.primerMovimientoIA == true){
                 
                 this.tablero.movimiento(this.j1,this.j2, 3); this.validaciones(this.j1); this.primerMovimientoIA=false;
             }
             else{
                Instant inicio = Instant.now();
                this.tablero.movimiento(this.j1,this.j2, ai.getAIMove(this)); 
                Instant fin = Instant.now();
                System.out.println("Duracion jugada: "+Duration.between(inicio, fin));
                this.validaciones(this.j1);} }
         else{this.tablero.movimiento(this.j2,this.j1, x); this.validaciones(this.j2);  }
    }
    
     
      public void verificarTableroLleno(){ 
        this.ganador.setResultado(this.getTablero().esLleno());
      
    }
     // Funcione en la que se cuenta la cantidad de fichas del jugador y tambien del IA
    public int valida(int aiScore, int humanScore, int i , int j, int [] filas, int []cols ){
       OUTER:
            for (int k = 0; k<filas.length; ++k) {
                switch (this.getTablero().getMatriz()[i+filas[k]][j+cols[k]].getColor()) {
                case 1:aiScore++;break;
                case 2: humanScore++; break;
                default: break OUTER;}
            }
    if(aiScore==4)return 1; else if (humanScore==4)return 2;
    else{return -1;}
   }
    
   //Funcion de game result encargada de validar el gane del juego 
    // progrsa de 4 en 4 desde i=0
   public int gameResult(){ // Board b es Tablero t
        for(int i=this.getTablero().getFilas()-1;i>=0;--i){ // filas
           for(int j=0;j<=this.getTablero().getColumnas()-1;++j){ // columnas
               if(this.getTablero().getMatriz()[i][j].getColor()==0) continue;
               //Checking cells to the right
               if(j<=3){ int []filas={0,0,0,0}; int []cols={0,1,2,3};int validacion= this.valida(0,0,i,j,filas,cols);
                   if (validacion!=-1){return (validacion);} } 
               //Checking cells up
               if(i>=3){int []filas={0,-1,-2,-3}; int []cols={0,0,0,0}; int validacion= this.valida(0,0,i,j,filas,cols);
                   if(validacion!=-1){return (validacion);} }   
               //Checking diagonal up-right
               if(j<=3 && i>= 3){int []filas={0,-1,-2,-3}; int []cols={0,1,2,3}; int validacion= this.valida(0,0,i,j,filas,cols);
                   if(validacion!=-1){return (validacion);} }   
                //Checking diagonal up-left
               if(j>=3 && i>=3){int []filas={0,-1,-2,-3}; int []cols={0,-1,-2,-3}; int validacion= this.valida(0,0,i,j,filas,cols);
                   if(validacion!=-1){return (validacion);} }   
           }
       }
       if("".equals(this.getTablero().esLleno())){return -1;} // tablero no lleno
       return 0;}
     
}
