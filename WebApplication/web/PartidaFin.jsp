<%-- 
    Document   : PartidaFin
    Created on : 02/10/2018, 02:30:10 AM
    Author     : Josue Rodriguez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="Modelo.Juego"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Conecta Cuatro</title>
        <link rel='icon' href='http://icons.iconarchive.com/icons/treetog/i/24/Games-icon.png' type='image/x-icon'>
    </head>
    <style type="text/css">
    .break{
        display:block;
        margin:0 0 0em;
    }
    </style>
    
    <body background="C:\Users\Josue Rodriguez\Documents\NetBeansProjects\WebApplication\web\Images\Iconos\fondo.jpg">
       
       <% Juego s = (Juego)request.getAttribute("juego");%>
        <h1 style=" color:white; font-family:Georgia;font-size: 60px; " align="center" ><b>"<%=s.getGanador().getResultado()%>"</b></h1>
         
       <form style="text-align:center;"name="frmR" method="get" action="Controlador" >
           
            <table align="center"  >
                <% for (int i=0; i< s.getTablero().getFilas();i++) { %>
                    <% for (int j=0; j< s.getTablero().getColumnas();j++) { %>
                        <img src="<%=s.getTablero().getMatriz()[i][j].getDireccion()%>" id="<%=i %>">  <%}%>
                    <span class="break"></span> <%}%>
            </table > <br />
            <input type="button" name="reinicio" value= "Reiniciar"   style="height:44px; width:170px; background-color:#FF4000;border: 1px solid ;color: whitesmoke ;font-family: Times New Roman; font-size: 21px; font-style: normal; font-variant: normal" onclick="{document.frmR.submit();}"  />   
        </form>

    </body>
</html>

