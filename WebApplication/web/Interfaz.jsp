<%-- 
    Document   : Interfaz
    Created on : 27/09/2018, 06:42:45 PM
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
         
        <form name="frmR" method="get" action="Controlador" >   
            <div style="float:right">
           
                <input type="button" name="reinicio" value= "Reiniciar"   style="height:30px; width:89px; background-color:#FF4000;border: 0px solid ;color: whitesmoke ;font-family: Times New Roman; font-size: 19px; font-style: normal; font-variant: normal" onclick="{document.frmR.submit();}"  />
            </div></form>
        <h1 style=" color:white; font-family:Georgia;font-size: 59px; " align="center" ><b>CONECTA - CUATRO</b></h1>
         
       <form style="text-align:center;"name="frm" method="post" action="Controlador" >
           <% Juego s = (Juego)request.getAttribute("juego");%>
            <table align="center"  >
                <% for (int i=0; i< s.getTablero().getFilas();i++) { %>
                    <% for (int j=0; j< s.getTablero().getColumnas();j++) { %>
                        <img src="<%=s.getTablero().getMatriz()[i][j].getDireccion()%>" id="<%=i %>">  <%}%>
                    <span class="break"></span> <%}%>
            </table > <br />
            <input type="hidden" name="hdnbt" />
            <%if (s.getJ2().getTurnoActivo()==true){ %> 
                <% for (int j=0; j<s.getTablero().getColumnas();j++) { %>
                    <input type="button" name="<%=j %>" value= "Inserta C<%=j %>"   style="height:42px; width:109px; background-color:#084B8A;border: 1px solid ;color: whitesmoke ;font-family: Times New Roman; font-size: 21px; font-style: normal; font-variant: normal"  onclick="{document.frm.hdnbt.value=this.name;document.frm.submit();}"  />
                <%}%> <%}%>
            <%if (s.getJ1().getTurnoActivo()==true ){%>
                <input type="button" name="0" value= "TURNO PC" style="height:48px; width:170px; background-color:#084B8A ;border: 1.5px solid ;color: whitesmoke ;font-family: Georgia; font-size: 20px; font-style: normal; font-variant: normal "  onclick="{document.frm.hdnbt.value=this.name;document.frm.submit();}"  />  <%}%>
              
        </form>

    </body>
</html>


