<%-- 
    Document   : MenuInicio
    Created on : 29/09/2018, 02:25:38 PM
    Author     : Josue Rodriguez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Conecta4 Menu </title>
        <link rel='icon' href='http://icons.iconarchive.com/icons/treetog/i/24/Games-icon.png' type='image/x-icon'>
       
    </head>
    <body bgcolor="#151515">
        <h6 style="color:white; font-family:Georgia; font-size: 14px; font-style: normal; font-variant: normal">Desarrollador: Josue David Rodriguez A - 2018/ITCR</h6>
        <form style="text-align:center;"name="frm" method="get" action="Controlador" >
             <img src="https://image.ibb.co/bVWVye/ICON3.png" > 
             <br/><br/>
             <input type="hidden" name="iniciar" />
             <input type="submit" name="inicio" value= "INICIO JUEGO"  style="height:48px; width:170px; background-color:#B40404 ;border: 1.5px solid ;color: whitesmoke ;font-family: Georgia; font-size: 20px; font-style: normal; font-variant: normal " onclick="{document.frm.iniciar.value=this.name;document.frm.submit();}"  /> 
    
        </form>
    </body>
</html>
