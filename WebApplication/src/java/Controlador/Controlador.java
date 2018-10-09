/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelo.Juego;


/**
 *
 * @author Josue Rodriguez
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {
    private Juego juego;
    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String nombreBoton =request.getParameter("hdnbt");
            int x= Integer.parseInt(nombreBoton);
            this.juego.mover(x);  // logica 
            if(!"".equals(this.juego.getGanador().getResultado())){
                //System.out.println("FINALIZANDO "+this.juego.getGanador().getResultado());
                request.setAttribute("juego", this.juego); 
                request.getRequestDispatcher("PartidaFin.jsp").forward(request, response);}
            
            else{
                this.juego.verificarTableroLleno();
                if(!"".equals(this.juego.getGanador().getResultado())){ // tablero lleno
                    request.setAttribute("juego", this.juego); 
                    request.getRequestDispatcher("PartidaFin.jsp").forward(request, response);}
                
                else{request.setAttribute("juego", this.juego);
                    request.getRequestDispatcher("Interfaz.jsp").forward(request, response);}  
            }      
        }
    }
    
    public void iniciarDatos(){
        this.juego =new Juego(6,7,7);
        this.juego.getJ1().setTurnoActivo(true); // inicia jugador Rojo la partida
        this.juego.getTablero().setMatriz(); // coloca todos los campos matriz en color blanco y seteados con su direccion
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //String partidaIniciada =request.getParameter("iniciar");// captura primer inicio en pantalla menu
        this.iniciarDatos();
        request.setAttribute("juego", this.juego);
        request.getRequestDispatcher("Interfaz.jsp").forward(request, response);}
    

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
