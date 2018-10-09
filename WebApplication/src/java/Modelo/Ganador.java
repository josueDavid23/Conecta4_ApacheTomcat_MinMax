/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Josue Rodriguez
 */
public class Ganador {
    private int contador;
    private String resultado;
    private ArrayList<Integer> filas=new ArrayList<>();;
    private ArrayList<Integer> cols=new ArrayList<>();;
    
    //Clase en la cual se define un contador y el resultado "" 
    // al no haber un ganador
    
    public Ganador(){
        this.contador=1;
        this.resultado="";
   
    }
    
    
   /*
    Metodos set y get de acuerdo a la cantidad de filas ganadas y a las columnas con
    las quien gano
    */
    
    public void setFilas(ArrayList<Integer> filas) {
        this.filas = filas;
    }

    public void setCols(ArrayList<Integer> cols) {
        this.cols = cols;
    }

    public ArrayList<Integer> getFilas() {
        return filas;
    }

    public ArrayList<Integer> getCols() {
        return cols;
    }

  
    /*Metodos set get contador resultado*/
    public int getContador() {
        return contador;
    }

    public String getResultado() {
        return resultado;
    }
    
    public void iniciarContador(){
        this.contador=1;
    }
    public void setContador() {
        this.contador++;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public void setFilas(int valor) {
        this.filas.add(valor);
    }

    public void setCols(int valor) {
        this.cols.add(valor);
    }
    
    
    /*
    Funcion en la que las posiciones i j en que gano son cambiadas por nuevas
    imagenes para generar una mejor interfaz e indicar el gane
    */
    public Ficha[][] cambiarFichas(Tablero t,Jugador j){
        for(int i=0;i<this.filas.size();i++){
           // System.out.println("DIRECCION JUGADOR: "+j.getTipoFicha().getDireccionGane());
            t.getMatriz()[this.filas.get(i)][this.cols.get(i)].setDireccion(j.getTipoFicha().getDireccionGane());
        }
        t.getMatriz()[j.getUltimoMovimiento()[0]][j.getUltimoMovimiento()[1]].setDireccion(j.getTipoFicha().getDireccionGane());
        return t.getMatriz();
    }
 
}
