<%@ page contentType="text/html; charset=UTF-8" %>
<%
 int num1 = 100;
 int num2 = 200;
 int result = num1 + num2;
 out.write("result=" + result);

 out.write("<br>이름:" + name);
 print();
%>
<%-- 주석(번역x) ... --%>
<br>
    <%=num1%> + <%=num2%> = <%=result%>

<%!

    String name ="이이름";
    void print(){
    System.out.println(name);
    }
%>
