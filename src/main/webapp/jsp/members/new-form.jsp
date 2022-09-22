<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/jsp/members/save.jsp" method="post">
        username: <input type="text" name="username"/>
        age: <input type="text" name="age"/>
        <button type="submit">전송</button>
</form>
</body>
</html>

<%--
JSP - 이 파일 하나로 멤버 폼을 HTML로 열면서 동적인 데이터전송까지 끝냄-
-%>
