<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<c:url var="actionUrl" value="/member/login" />
<layout:main title="냥그인">
    <h1>냥그인</h1>
    <form method="POST" action="${actionURl}" autocomplete="off">
        <dl>
            <dt>이메일</dt>
            <dd>
                <input type="text" name="email">
            </dd>
        </dl>
        <dl>
            <dt>비밀번호</dt>
            <dd>
                <input type="password" name="password">
            </dd>
        </dl>
        <div>
            <input type="checkbox" name="saveEmail" value="true" id="saveEamil">
            <label for="saveEamil">이메일 기억하기</label>
        </div>
        <button type="submit">로그인</button>
    </form>
</layout:main>