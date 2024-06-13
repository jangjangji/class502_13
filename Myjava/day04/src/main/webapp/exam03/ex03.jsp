<%@page contentType="text/html; charset=UTF-8" %>
<h1>ex03.jsp</h1>
<jsp:forward page="ex04.jsp">
    <jsp:param name="key1" value="이름1"/>
    <jsp:param name="key2" value="value2"/>
</jsp:forward>