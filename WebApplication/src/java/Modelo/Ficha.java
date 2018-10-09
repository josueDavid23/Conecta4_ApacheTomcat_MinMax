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
public class Ficha {
    private int color;  // 1 = rojo 2 = amarillo 0 = blanco
    private String direccion;
    private final String direccionGane;
   
    /*
    Cuenta con atributos como el color de la ficha
    url en donde se encuentra la imagen de la ficha sea blanca amarillo o rojo
    y la direccion de la imagen a mostrar segun el color
    */
    
    public Ficha(){
        this.color = 0;
        this.direccion="https://image.ibb.co/jVmcBz/cuadroB.jpg"; // imagen cuadro blanco
        this.direccionGane = "";
    }
    
    
    /*
    El color puede tomar los siguientes valores:
    0: blanco
    1: rojo
    2: amarillo
    Direccion: es un url
    Direccion
    */
    public Ficha(int color, String direccion,String direccionGane){
        this.color=color;
        this.direccion=direccion;
        this.direccionGane=direccionGane;
  
    }
 
    
    //METODOS SET GET DE LOS ATRIBUTOS //
    public String getDireccionGane() {
        return direccionGane;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
}
