/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.69
 * Generated at: 2021-09-05 10:18:45 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.courier_002dv1_0_0.public_;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
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

      out.write('\r');
      out.write('\n');
response.setCharacterEncoding("UTF-8"); 
      out.write('\r');
      out.write('\n');
request.setCharacterEncoding("UTF-8"); 
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en-US\" dir=\"ltr\">\r\n");
      out.write("<!-- index.html > 버튼 클릭시 login.jsp로 이동 -->\r\n");
      out.write("\r\n");
      out.write("  <head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!-- ===============================================-->\r\n");
      out.write("    <!--    Document Title-->\r\n");
      out.write("    <!-- ===============================================-->\r\n");
      out.write("    <title>courier | Landing, Responsive &amp; Business Templatee</title>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!-- ===============================================-->\r\n");
      out.write("    <!--    Favicons-->\r\n");
      out.write("    <!-- ===============================================-->\r\n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"180x180\" href=\"assets/img/favicons/apple-touch-icon.png\">\r\n");
      out.write("    <link rel=\"icon\" type=\"image/png\" sizes=\"32x32\" href=\"assets/img/favicons/favicon-32x32.png\">\r\n");
      out.write("    <link rel=\"icon\" type=\"image/png\" sizes=\"16x16\" href=\"assets/img/favicons/favicon-16x16.png\">\r\n");
      out.write("    <link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"assets/img/favicons/favicon.ico\">\r\n");
      out.write("    <link rel=\"manifest\" href=\"assets/img/favicons/manifest.json\">\r\n");
      out.write("    <meta name=\"msapplication-TileImage\" content=\"assets/img/favicons/mstile-150x150.png\">\r\n");
      out.write("    <meta name=\"theme-color\" content=\"#ffffff\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!-- ===============================================-->\r\n");
      out.write("    <!--    Stylesheets-->\r\n");
      out.write("    <!-- ===============================================-->\r\n");
      out.write("    <link href=\"assets/css/theme.css\" rel=\"stylesheet\" />\r\n");
      out.write("\r\n");
      out.write("  </head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  <body>\r\n");
      out.write("\r\n");
      out.write("    <!-- ===============================================-->\r\n");
      out.write("    <!--    Main Content-->\r\n");
      out.write("    <!-- ===============================================-->\r\n");
      out.write("    <main class=\"main\" id=\"top\">\r\n");
      out.write("      <section class=\"py-xxl-10 pb-0\" id=\"home\">\r\n");
      out.write("        <div class=\"bg-holder bg-size\" style=\"background-image:url(assets/img/gallery/hero-header-bg.png);background-position:top center;background-size:cover;\">\r\n");
      out.write("        </div>\r\n");
      out.write("        <!--/.bg-holder-->\r\n");
      out.write("\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("          <div class=\"row align-items-center\">\r\n");
      out.write("            <div class=\"col-md-5 col-xl-6 col-xxl-7 order-0 order-md-1 text-end\"><img class=\"pt-7 pt-md-0 w-100\" id=\"storeImg\" src=\"assets/img/store.jpg\" alt=\"hero-header\" /></div>\r\n");
      out.write("            <div class=\"col-md-75 col-xl-6 col-xxl-5 text-md-start text-center py-8\">\r\n");
      out.write("              <h1 class=\"fw-normal fs-6 fs-xxl-7\">탕화쿵푸 YN점 </h1>\r\n");
      out.write("              <h1 class=\"fw-bolder fs-6 fs-xxl-7 mb-2\">배달 서비스 오픈!!</h1>\r\n");
      out.write("              <p class=\"fs-1 mb-5\">since.2021.08.26 <br />10일 간의 손맛으로 얼큰한 맛을 느껴보세요. </p><a class=\"btn btn-primary me-2\" href=\"login.jsp\" role=\"button\">Get started<i class=\"fas fa-arrow-right ms-2\"></i></a>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </section>\r\n");
      out.write("\r\n");
      out.write("    </main>\r\n");
      out.write("    <!-- ===============================================-->\r\n");
      out.write("    <!--    End of Main Content-->\r\n");
      out.write("    <!-- ===============================================-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!-- ===============================================-->\r\n");
      out.write("    <!--    JavaScripts-->\r\n");
      out.write("    <!-- ===============================================-->\r\n");
      out.write("    <script src=\"vendors/@popperjs/popper.min.js\"></script>\r\n");
      out.write("    <script src=\"vendors/bootstrap/bootstrap.min.js\"></script>\r\n");
      out.write("    <script src=\"vendors/is/is.min.js\"></script>\r\n");
      out.write("    <script src=\"https://polyfill.io/v3/polyfill.min.js?features=window.scroll\"></script>\r\n");
      out.write("    <script src=\"vendors/fontawesome/all.min.js\"></script>\r\n");
      out.write("    <script src=\"assets/js/theme.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css2?family=Raleway:wght@200;300;400;500;600;700;800&amp;display=swap\" rel=\"stylesheet\">\r\n");
      out.write("  </body>\r\n");
      out.write("\r\n");
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
