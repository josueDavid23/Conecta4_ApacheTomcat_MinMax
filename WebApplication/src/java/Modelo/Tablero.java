/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Josue Rodriguez
 */
public class Tablero {
    private int filas;
    private int columnas;
    private Ficha[][] matriz;
    
    public Tablero (int filas, int columnas){
        this.filas=filas;
        this.columnas=columnas;
        this.matriz=new Ficha[filas][columnas]; // cada uno de los campos es null
       
     }
    
    public void setMatriz(){
        for (int i=0;i<this.filas;i++){
            for (int j=0;j<this.columnas;j++){
                this.matriz[i][j]= new Ficha();
            }
        }
    }
    public void setMatrizGane(Ficha[][] m){
       this.matriz=m;
    }
    public Ficha[][] getMatriz() {
        return matriz;
    }
  
    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    
    public void setCampoMatriz(int fila,int columna, Jugador j){
        this.matriz[fila][columna].setColor(j.getTipoFicha().getColor());
        this.matriz[fila][columna].setDireccion(j.getTipoFicha().getDireccion());
        j.setUltimoMovimiento(fila, columna);
    }
    
    public void movimiento(Jugador j, Jugador j2 ,int col){
        for (int i=this.filas-1;i>=0;i--){
            if(this.matriz[i][col].getColor() == 0){
                j.setTurnoActivo(false);
                j2.setTurnoActivo(true);
                this.setCampoMatriz(i, col, j);
                break;
             }
        }
    }
    
    public String esLleno(){ 
        for (int j=0; j < this.columnas; j++){
                if (this.matriz[0][j].getColor()==0){return "";}
                //System.out.print(this.matriz[i][j].getColor() + "   ");
        }
        
        return "NO existe ganador";
    }
    /*
    IA
    */
    public boolean isLegalMove(int column){
       return this.matriz[0][column].getColor()==0;
    }
   
       //Placing a Move on the board
    public boolean placeMove(int column, int player){ 
       if(!this.isLegalMove(column)) {System.out.println("Illegal move!"); return false;}
       for(int i=5;i>=0;--i){
           if(this.matriz[i][column].getColor() == 0) {
               this.matriz[i][column].setColor(player);
               return true;
           }
       }
       return false;
    }
   
    public void undoMove(int column){
       for(int i=0;i<=5;++i){
           if(this.matriz[i][column].getColor() != 0) {
               this.matriz[i][column].setColor(0);
               break;
           }
       }        
    }
        
}
