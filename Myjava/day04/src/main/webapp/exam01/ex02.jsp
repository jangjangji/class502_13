<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page buffer ="32kb" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page info = "재미있는 냥공주" %>
<%@ isErrorPage = ""%>
<%
    List<String> names = new ArrayList<>();
    names.add("이름");
    names.add("name2");
    out.write(names.toString());

    LocalDateTime now = LocalDateTime.now();
    out.write("<br>" + now.toString());
%>