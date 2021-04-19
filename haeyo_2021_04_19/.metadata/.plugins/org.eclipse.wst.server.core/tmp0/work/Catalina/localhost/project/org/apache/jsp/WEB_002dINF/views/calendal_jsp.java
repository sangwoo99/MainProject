/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.54
 * Generated at: 2021-04-12 08:31:42 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class calendal_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset='utf-8' />\r\n");
      out.write("<link href='resources/packages/core/main.css' rel='stylesheet' />\r\n");
      out.write("<link href='resources/packages/daygrid/main.css' rel='stylesheet' />\r\n");
      out.write("<link href='resources/packages/timegrid/main.css' rel='stylesheet' />\r\n");
      out.write("<link href='resources/packages/list/main.css' rel='stylesheet' />\r\n");
      out.write("<script src='resources/packages/core/main.js'></script>\r\n");
      out.write("<script src='resources/packages/interaction/main.js'></script>\r\n");
      out.write("<script src='resources/packages/daygrid/main.js'></script>\r\n");
      out.write("<script src='resources/packages/timegrid/main.js'></script>\r\n");
      out.write("<script src='resources/packages/list/main.js'></script>\r\n");
      out.write("<script src=\"http://code.jquery.com/jquery-latest.min.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("//var sales = new Array();\r\n");
      out.write("document.addEventListener('DOMContentLoaded', function () {\r\n");
      out.write("  var calendarEl = document.getElementById('calendar');\r\n");
      out.write("  var calendar = new FullCalendar.Calendar(calendarEl, {\r\n");
      out.write("    headerToolbar: {\r\n");
      out.write("      // left: 'prevYear,prev,next,nextYear today',    // 클릭시 전달 한달치 데이터를 가져와야함 \r\n");
      out.write("      // center: 'title'\r\n");
      out.write("      // right: 'dayGridMonth,dayGridWeek,dayGridDay'\r\n");
      out.write("    },\r\n");
      out.write("    plugins: [ 'interaction', 'dayGrid', 'timeGrid', 'list' ],\r\n");
      out.write("    initialDate: new Date(),\r\n");
      out.write("    navLinks: true, // can click day/week names to navigate views\r\n");
      out.write("    editable: false,\r\n");
      out.write("    dayMaxEvents: true, // allow \"more\" link when too many events\r\n");
      out.write("    events: function (info, successCallback, failureCallback) {\r\n");
      out.write("      $.ajax({\r\n");
      out.write("        url: \"calendal.do\",\r\n");
      out.write("        data: {\"pNo\" : ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pNo.pNo}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("},\r\n");
      out.write("        type: 'get',\r\n");
      out.write("        success: function(data) {\r\n");
      out.write("          console.log('ajax 함수 완료');\r\n");
      out.write("         // let result = JSON.parse(data);\r\n");
      out.write("          console.log(data);\r\n");
      out.write("          var events = [];\r\n");
      out.write("          $.each(data, function (index, item) {\r\n");
      out.write("            events.push({\r\n");
      out.write("            \tid: item.rsvNo,\r\n");
      out.write("             \ttitle: item.title + \"님의 일정\",\r\n");
      out.write("             \tstart: item.start\r\n");
      out.write("            }); // push end\r\n");
      out.write("\r\n");
      out.write("          }); // each end\r\n");
      out.write("          console.log(events);\r\n");
      out.write("          successCallback(events);\r\n");
      out.write("        }// success end\r\n");
      out.write("      });  // ajax end\r\n");
      out.write("    }, // event end\r\n");
      out.write("\r\n");
      out.write("  }); // calender end\r\n");
      out.write("\r\n");
      out.write("  calendar.render();\r\n");
      out.write("}); // document end\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("<style>\r\n");
      out.write("html, body {\r\n");
      out.write("\toverflow: hidden; /* don't do scrollbars */\r\n");
      out.write("\tfont-family: Arial, Helvetica Neue, Helvetica, sans-serif;\r\n");
      out.write("\tfont-size: 14px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#calendar-container {\r\n");
      out.write("\tposition: fixed;\r\n");
      out.write("\ttop: 0;\r\n");
      out.write("\tleft: 0;\r\n");
      out.write("\tright: 0;\r\n");
      out.write("\tbottom: 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".fc-header-toolbar {\r\n");
      out.write("\tpadding-top: 1em;\r\n");
      out.write("\tpadding-left: 1em;\r\n");
      out.write("\tpadding-right: 1em;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id='calendar-container'>\r\n");
      out.write("\t\t<div id='calendar'></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
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