/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.54
 * Generated at: 2021-04-12 03:36:23 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.customer.profession;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class check_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/C:/Bitcamp/haeyo_2021_04_10_최종/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/haeyo/WEB-INF/lib/jstl-1.2.jar!/META-INF/c-1_0-rt.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1616565092596L));
  }

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
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("<script src=\"//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js\"></script>\r\n");
      out.write("<script src=\"//dapi.kakao.com/v2/maps/sdk.js?appkey=75d6c9cf371d5f0cd64d40592c350582&libraries=services\"></script>\r\n");
      out.write("<link href=\"resources/css/profession/checkList.css\" rel=\"stylesheet\">\r\n");
      out.write("<script>\r\n");
      out.write("window.onload = function() {\r\n");
      out.write("\twsOpen();\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("<!---------------------main--------------------->\r\n");
      out.write("<main>\r\n");
      out.write("\t<section id=\"conbg\" class=\"clearfix\">\r\n");
      out.write("\t\t<div id=\"checklistWrap\" class=\"clearfix\">\r\n");
      out.write("\t\t\t<div id=\"checklist\" class=\"clearfix\">\r\n");
      out.write("\t\t\t\t<p>전문가 체크 리스트</p>\r\n");
      out.write("\t\t\t\t<form action=\"recommend.do\" method=\"get\">\r\n");
      out.write("\t\t\t\t\t<div class=\"box\">\r\n");
      out.write("\t\t\t\t\t\t<label>어느 지역을 찾으시나요?</label><br> <input type=\"text\"\r\n");
      out.write("\t\t\t\t\t\t\tid=\"searchLoc\" name=\"serchloc\" /><input type=\"button\"\r\n");
      out.write("\t\t\t\t\t\t\tid=\"searchBtn\" onclick=\"PostCode()\" value=\"주소 검색\" />\r\n");
      out.write("\t\t\t\t\t\t<div id=\"map\"></div>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"hidden\" id=\"locX\" name=\"pickLocX\" value=\"\" /> <input\r\n");
      out.write("\t\t\t\t\t\t\ttype=\"hidden\" id=\"locY\" name=\"pickLocY\" value=\"\" />\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"box\">\r\n");
      out.write("\t\t\t\t\t\t<label>서비스 종류는 무엇인가요?</label><br>\r\n");
      out.write("\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t<li><input type=\"radio\" name=\"pCategory\" value=\"청소\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"radio_btn\"><span>청소</span></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><input type=\"radio\" name=\"pCategory\" value=\"이사\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"radio_btn\"><span>이사</span></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><input type=\"radio\" name=\"pCategory\" value=\"수리\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"radio_btn\"><span>수리</span></li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"box\">\r\n");
      out.write("\t\t\t\t\t\t<label>원하시는 일정이 있으시나요?</label><br> <input type=\"date\"\r\n");
      out.write("\t\t\t\t\t\t\tid=\"startDate\" name=\"startDate\" value=\"\" /> <input type=\"date\"\r\n");
      out.write("\t\t\t\t\t\t\tid=\"endDate\" name=\"EndDate\" max=\"\" />\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<button type=\"submit\" class=\"heayo_btn\">제출하기</button>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t<script src=\"resources/js/profession/checkList.js\"\r\n");
      out.write("\t\t\t\t\ttype=\"text/javascript\"></script>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"checkInfo\">\r\n");
      out.write("\t\t\t\t<h3>\r\n");
      out.write("\t\t\t\t\t<i class=\"far fa-check-circle\"></i> 전문가 체크\r\n");
      out.write("\t\t\t\t</h3>\r\n");
      out.write("\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t사소하고 작은 서비스가 필요하셨나요?<br /> 해요는 1인가구를 위한 전문 서비스입니다. 간단한 수리, 청소, 이사를\r\n");
      out.write("\t\t\t\t\t해요에게 맡겨주세요 <br /> <br /> 서비스가 필요한 고객과 서비스를 제공하는 전문가를 쉽고 빠르게\r\n");
      out.write("\t\t\t\t\t연결해드리는 전문가 매칭 서비스입니다.<br /> 1분 내외의 요청서를 작성하면, 고객님께 맞는 전문가 리스트를\r\n");
      out.write("\t\t\t\t\t뽑아드립니다. <br />\r\n");
      out.write("\t\t\t\t\t<br /> <span>맘에 드는 전문가의 맞춤형 서비스를 받아보세요!</span>\r\n");
      out.write("\t\t\t\t</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"chatbotWrap\">\r\n");
      out.write("\t\t\t\t<div id=\"chatTalk\">\r\n");
      out.write("\t\t\t\t\t<p>저에게 물어봐 주세요!</p>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div id=\"chatbot\">\r\n");
      out.write("\t\t\t\t\t<span><i class=\"far fa-smile fa-spin fa-fw\"></i></span>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</section>\r\n");
      out.write("</main>");
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
