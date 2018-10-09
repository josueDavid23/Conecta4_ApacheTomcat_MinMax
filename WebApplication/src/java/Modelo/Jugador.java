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
public class Jugador {
    private final int []ultimoMovimiento=new int[2];
    private boolean turnoActivo = false;
    private Ficha tipoFicha=null;
 
     // clase jugador el cual tendra un tipo de ficha asignado 
    // el turno si se encuentra activo o no
    // el movimiento [] de acuerdo a fila y columna 
    // segun el ultimo boton presionado
    
    public Jugador(Ficha ficha){
        this.tipoFicha=ficha;
       
    }

    /*METODOS GET Y SET*/
    
    // get tipo ficha del jugador
    public Ficha getTipoFicha() {
        return tipoFicha;
    }
    
    //get del ultimo movimiento realizado
    public int [] getUltimoMovimiento() {
        return ultimoMovimiento;
    }

    // Setea el ultimo movimiento del jugador por la ultima fila o columna
    // segun el boton presionado y luego ultima fila corresponde al recorrido
    // de acuerdo a la columnna sera la fila con espacio en blanco
    public void setUltimoMovimiento(int ultimaFila,int ultimaColumna) {
        this.ultimoMovimiento[0] = ultimaFila;
        this.ultimoMovimiento[1] = ultimaColumna;  
    }

    public boolean getTurnoActivo() {
        return turnoActivo;
    }

    public void setTurnoActivo(boolean turnoActivo) {
        this.turnoActivo = turnoActivo;
    }
    
    
}
