/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.69
 * Generated at: 2021-09-05 11:31:11 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.courier_002dv1_0_0.public_;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP?????? ?????? GET, POST ?????? HEAD ??????????????? ???????????????. Jasper??? OPTIONS ????????? ?????? ???????????????.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\n');
 request.setCharacterEncoding("UTF-8"); 
      out.write('\n');
      out.write(' ');

 	//???????????? ????????? ?????????, ?????? ?????????????????? ??????
 	if(session.getAttribute("ordermemberVO")!=null){
 		response.sendRedirect("control.jsp?action=list");
 	}
 
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en-US\" dir=\"ltr\">\n");
      out.write("\n");
      out.write("  <head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("\n");
      out.write("\n");
      out.write("    <!-- ===============================================-->\n");
      out.write("    <!--    Document Title-->\n");
      out.write("    <!-- ===============================================-->\n");
      out.write("    <title>courier | Landing, Responsive &amp; Business Templatee</title>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <!-- ===============================================-->\n");
      out.write("    <!--    Favicons-->\n");
      out.write("    <!-- ===============================================-->\n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"180x180\" href=\"assets/img/favicons/apple-touch-icon.png\">\n");
      out.write("    <link rel=\"icon\" type=\"image/png\" sizes=\"32x32\" href=\"assets/img/favicons/favicon-32x32.png\">\n");
      out.write("    <link rel=\"icon\" type=\"image/png\" sizes=\"16x16\" href=\"assets/img/favicons/favicon-16x16.png\">\n");
      out.write("    <link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"assets/img/favicons/favicon.ico\">\n");
      out.write("    <link rel=\"manifest\" href=\"assets/img/favicons/manifest.json\">\n");
      out.write("    <meta name=\"msapplication-TileImage\" content=\"assets/img/favicons/mstile-150x150.png\">\n");
      out.write("    <meta name=\"theme-color\" content=\"#ffffff\">\n");
      out.write("\n");
      out.write("\n");
      out.write("    <!-- ===============================================-->\n");
      out.write("    <!--    Stylesheets-->\n");
      out.write("    <!-- ===============================================-->\n");
      out.write("    <link href=\"assets/css/theme.css\" rel=\"stylesheet\" />\n");
      out.write("\n");
      out.write("  </head>\n");
      out.write("\n");
      out.write("\n");
      out.write("  <body>\n");
      out.write("\n");
      out.write("    <!-- ===============================================-->\n");
      out.write("    <!--    Main Content-->\n");
      out.write("    <!-- ===============================================-->\n");
      out.write("    <main class=\"main\" id=\"loginTop\">\n");
      out.write("      <section class=\"py-xxl-10 pb-0\" id=\"home\">\n");
      out.write("        <div class=\"bg-holder bg-size\" style=\"background-image:url(assets/img/gallery/hero-header-bg.png);background-position:top center;background-size:cover;\">\n");
      out.write("        \n");
      out.write("      <!-- control.jsp??? actiom:loginChck ??????????????? ????????????, -->\n");
      out.write("      <!-- ????????? ???????????? userID, userPW, mod??? ????????? -->\n");
      out.write("      \n");
      out.write("              <form class=\"row\" name=\"form1\" method=\"post\" action=\"control.jsp\">\n");
      out.write("              <input type=\"hidden\" name=\"action\" value=\"loginCheck\">\n");
      out.write("                <div class=\"mb-3\">\n");
      out.write("                  <label class=\"form-label visually-hidden\" for=\"inputName\">ID</label>\n");
      out.write("                  <input class=\"form-control form-quriar-control\" id=\"userID\" type=\"text\" name=\"userID\" placeholder=\"???????????? ???????????????.\" required minlength=\"4\" maxlength=\"10\"/>\n");
      out.write("                </div>\n");
      out.write("                 <div class=\"mb-3\">\n");
      out.write("                  <label class=\"form-label visually-hidden\" for=\"inputName\">PW</label>\n");
      out.write("                  <input class=\"form-control form-quriar-control\" id=\"userPW\" type=\"password\" name=\"userPW\" placeholder=\"??????????????? ???????????????.\" required minlength=\"4\" maxlength=\"10\"/>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"mb-3\">\n");
      out.write("                  <label class=\"form-label visually-hidden\" for=\"inputName\">????????????</label>\n");
      out.write("                  <span class=\"memberSelect\"><input type=\"radio\" name=\"mod\" value=\"?????????\" checked/>?????????</span>\n");
      out.write("                  <span class=\"memberSelect\"><input type=\"radio\" name=\"mod\" value=\"??????\"/>??????</span>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"d-grid\">\n");
      out.write("                  <button class=\"btn btn-primary\" type=\"submit\">????????? ??????<i class=\"fas fa-paper-plane ms-2\"></i></button>\n");
      out.write("                </div>\n");
      out.write("              </form>\n");
      out.write("              <div class=\"d-grid\">\n");
      out.write("                  <a href=\"signUp.html\"><button class=\"btn btn-primary signUpBtn\" type=\"submit\">???????????? ??????<i class=\"fas fa-paper-plane ms-2\"></i></button></a>\n");
      out.write("                </div>\n");
      out.write("                 <!-- <div class=\"d-grid\">\n");
      out.write("                  <a href=\"memberList.jsp\"><button class=\"btn btn-primary signUpBtn\" type=\"submit\">???????????? ??????<i class=\"fas fa-paper-plane ms-2\"></i></button></a>\n");
      out.write("                </div> -->\n");
      out.write("		  </div>\n");
      out.write("		</section>\n");
      out.write("    </main>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    <!-- ===============================================-->\n");
      out.write("    <!--    JavaScripts-->\n");
      out.write("    <!-- ===============================================-->\n");
      out.write("    <script src=\"vendors/@popperjs/popper.min.js\"></script>\n");
      out.write("    <script src=\"vendors/bootstrap/bootstrap.min.js\"></script>\n");
      out.write("    <script src=\"vendors/is/is.min.js\"></script>\n");
      out.write("    <script src=\"https://polyfill.io/v3/polyfill.min.js?features=window.scroll\"></script>\n");
      out.write("    <script src=\"vendors/fontawesome/all.min.js\"></script>\n");
      out.write("    <script src=\"assets/js/theme.js\"></script>\n");
      out.write("\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css2?family=Raleway:wght@200;300;400;500;600;700;800&amp;display=swap\" rel=\"stylesheet\">\n");
      out.write("  </body>\n");
      out.write("\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
