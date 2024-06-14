<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<c:set var="num" value="11" />
<c:if test="${num % 2 ==1}">
    냥공주입니다.
</c:if>
<c:if test="${!(num % 2 == 1)}">
    냥귀요미입니다
</c:if>

${num %2 == 1 ? '홀수입니다' : '짝수입니다'}