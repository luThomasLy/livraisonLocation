package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class jspCreationLivreur_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/jspHeader.jsp");
    _jspx_dependants.add("/jspFooter.jsp");
  }

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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"fr\">\n");
      out.write("    <head>\n");
      out.write("        <title>Location et Livraison</title>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <nav class=\"navbar navbar-inverse\">\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <div class=\"navbar-header\">\n");
      out.write("                    <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#myNavbar\">\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>                        \n");
      out.write("                    </button>\n");
      out.write("                    <a class=\"navbar-brand\" href=\"#\">locationLivraison</a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"collapse navbar-collapse\" id=\"myNavbar\">\n");
      out.write("                    <ul class=\"nav navbar-nav\">\n");
      out.write("                        <li class=\"active\"><a href=\"jspAccueil.jsp\">Accueil</a></li>\n");
      out.write("\n");
      out.write("                        <li><a href=\"jspProduit.jsp\">Produits</a></li>\n");
      out.write("                        <li><a href=\"jspCommande.jsp\">Commandes</a></li>\n");
      out.write("                        <li><a href=\"jspLivreur.jsp\">Livreurs</a></li>\n");
      out.write("\n");
      out.write("                        <li><a href=\"jspContact.jsp\">Contact</a></li>\n");
      out.write("                        <li><a href=\"#\">A propos</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                    <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                        <li><a href=\"jspLogin.jsp\"><span class=\"glyphicon glyphicon-log-in\"></span> Login</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </nav>");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"container\">\n");
      out.write("  <div class=\"row\">\n");
      out.write("    <div class=\"col\">\n");
      out.write("      <div class=\"form-row\">\n");
      out.write("    <div class=\"col\">\n");
      out.write("      <input type=\"text\" class=\"form-control\" placeholder=\"First name\">\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("    <div class=\"col\">\n");
      out.write("      2 of 2\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("  <div class=\"row\">\n");
      out.write("    <div class=\"col\">\n");
      out.write("      1 of 3\n");
      out.write("    </div>\n");
      out.write("    <div class=\"col\">\n");
      out.write("      2 of 3\n");
      out.write("    </div>\n");
      out.write("    <div class=\"col\">\n");
      out.write("      3 of 3\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<form>\n");
      out.write("  \n");
      out.write("    \n");
      out.write("  </div>\n");
      out.write("</form>\n");
      out.write("<form>\n");
      out.write("  <div class=\"form-row\">\n");
      out.write("    <div class=\"form-group col-md-6\">\n");
      out.write("      <label for=\"inputEmail4\">Email</label>\n");
      out.write("      <input type=\"email\" class=\"form-control\" id=\"inputEmail4\" placeholder=\"Email\">\n");
      out.write("    </div>\n");
      out.write("    <div class=\"form-group col-md-6\">\n");
      out.write("      <label for=\"inputPassword4\">Password</label>\n");
      out.write("      <input type=\"password\" class=\"form-control\" id=\"inputPassword4\" placeholder=\"Password\">\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("  <div class=\"form-group\">\n");
      out.write("    <label for=\"inputAddress\">Address</label>\n");
      out.write("    <input type=\"text\" class=\"form-control\" id=\"inputAddress\" placeholder=\"1234 Main St\">\n");
      out.write("  </div>\n");
      out.write("  <div class=\"form-group\">\n");
      out.write("    <label for=\"inputAddress2\">Address 2</label>\n");
      out.write("    <input type=\"text\" class=\"form-control\" id=\"inputAddress2\" placeholder=\"Apartment, studio, or floor\">\n");
      out.write("  </div>\n");
      out.write("  <div class=\"form-row\">\n");
      out.write("    <div class=\"form-group col-md-6\">\n");
      out.write("      <label for=\"inputCity\">City</label>\n");
      out.write("      <input type=\"text\" class=\"form-control\" id=\"inputCity\">\n");
      out.write("    </div>\n");
      out.write("    <div class=\"form-group col-md-4\">\n");
      out.write("      <label for=\"inputState\">State</label>\n");
      out.write("      <select id=\"inputState\" class=\"form-control\">\n");
      out.write("        <option selected>Choose...</option>\n");
      out.write("        <option>...</option>\n");
      out.write("      </select>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"form-group col-md-2\">\n");
      out.write("      <label for=\"inputZip\">Zip</label>\n");
      out.write("      <input type=\"text\" class=\"form-control\" id=\"inputZip\">\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("  <div class=\"form-group\">\n");
      out.write("    <div class=\"form-check\">\n");
      out.write("      <input class=\"form-check-input\" type=\"checkbox\" id=\"gridCheck\">\n");
      out.write("      <label class=\"form-check-label\" for=\"gridCheck\">\n");
      out.write("        Check me out\n");
      out.write("      </label>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("  <button type=\"submit\" class=\"btn btn-primary\">Sign in</button>\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<footer class=\"container-fluid text-center\">\n");
      out.write("    <p>Copyright Thomas LY</p>\n");
      out.write("</footer>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
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
