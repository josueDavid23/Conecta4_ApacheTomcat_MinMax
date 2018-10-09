package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Modelo.Tablero;

public final class Interfaz_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Conecta Cuatro</title>\n");
      out.write("        <link rel='icon' href='http://icons.iconarchive.com/icons/treetog/i/24/Games-icon.png' type='image/x-icon'>\n");
      out.write("    </head>\n");
      out.write("    <style type=\"text/css\">\n");
      out.write("    .break{\n");
      out.write("        display:block;\n");
      out.write("        margin:0 0 0em;\n");
      out.write("    }\n");
      out.write("    </style>\n");
      out.write("    \n");
      out.write("    <body bgcolor=\"#2E2E2E\">\n");
      out.write("        <form name=\"frmR\" method=\"get\" action=\"Controlador\" >   \n");
      out.write("            <div style=\"float:right\">\n");
      out.write("               \n");
      out.write("                <input type=\"button\" name=\"reinicio\" value= \"Reiniciar\"   style=\"height:30px; width:89px; background-color:#084B8A;border: 2px solid ;color: whitesmoke ;font-family: Times New Roman; font-size: 16px; font-style: normal; font-variant: normal\" onclick=\"{document.frmR.submit();}\"  />\n");
      out.write("            </div></form>\n");
      out.write("        <h1 style=\" color:white; font-family:Georgia;font-size: 59px; \" align=\"center\" ><b>CONECTA-CUATRO</b></h1>\n");
      out.write("         \n");
      out.write("       <form style=\"text-align:center;\"name=\"frm\" method=\"post\" action=\"Controlador\" >\n");
      out.write("           ");
 Tablero s = (Tablero)request.getAttribute("student");
      out.write("\n");
      out.write("            <table align=\"center\"  >\n");
      out.write("                ");
 for (int i=0; i< s.getFilas();i++) { 
      out.write("\n");
      out.write("                    ");
 for (int j=0; j< s.getColumnas();j++) { 
      out.write("\n");
      out.write("                        <img src=\"");
      out.print(s.getMatriz()[i][j].getDireccion());
      out.write("\" id=\"");
      out.print(i );
      out.write("\">  ");
}
      out.write("\n");
      out.write("                    <span class=\"break\"></span> ");
}
      out.write("\n");
      out.write("            </table > <br />\n");
      out.write("            \n");
      out.write("            <input type=\"hidden\" name=\"hdnbt\" />\n");
      out.write("            ");
 for (int j=0; j<s.getColumnas();j++) { 
      out.write("\n");
      out.write("                <input type=\"button\" name=\"");
      out.print(j );
      out.write("\" value= \"Inserta C");
      out.print(j );
      out.write("\"   style=\"height:42px; width:109px; background-color:#084B8A;border: 2px solid ;color: whitesmoke ;font-family: Times New Roman; font-size: 21px; font-style: normal; font-variant: normal\"  onclick=\"{document.frm.hdnbt.value=this.name;document.frm.submit();}\"  />\n");
      out.write("           ");
}
      out.write("   \n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
