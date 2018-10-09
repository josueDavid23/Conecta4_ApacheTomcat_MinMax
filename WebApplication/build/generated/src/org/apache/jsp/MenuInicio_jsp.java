package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class MenuInicio_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        \n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Conecta4 Menu </title>\n");
      out.write("        <link rel='icon' href='http://icons.iconarchive.com/icons/treetog/i/24/Games-icon.png' type='image/x-icon'>\n");
      out.write("       \n");
      out.write("    </head>\n");
      out.write("    <body bgcolor=\"#151515\">\n");
      out.write("        <h6 style=\"color:white; font-family:Georgia; font-size: 14px; font-style: normal; font-variant: normal\">Desarrollador: Josue David Rodriguez A - 2018/ITCR</h6>\n");
      out.write("        <form style=\"text-align:center;\"name=\"frm\" method=\"get\" action=\"Controlador\" >\n");
      out.write("             <img src=\"https://image.ibb.co/bVWVye/ICON3.png\" > \n");
      out.write("             <br/><br/>\n");
      out.write("             <input type=\"hidden\" name=\"iniciar\" />\n");
      out.write("             <input type=\"submit\" name=\"inicio\" value= \"INICIO JUEGO\"  style=\"height:48px; width:170px; background-color:#B40404 ;border: 1.5px solid ;color: whitesmoke ;font-family: Georgia; font-size: 20px; font-style: normal; font-variant: normal \" onclick=\"{document.frm.iniciar.value=this.name;document.frm.submit();}\"  /> \n");
      out.write("    \n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
