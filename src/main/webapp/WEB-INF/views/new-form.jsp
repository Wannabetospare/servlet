<%--
  Created by IntelliJ IDEA.
  User: ahnhyunkyu
  Date: 2022/09/22
  Time: 5:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<!-- 상대경로 사용, [현재 URL이 속한 계층 경로 + /save] -->
<!-- action 주소에 /(슬러시)가 붙어 있지 않으면 상대경로로 적용된다. -->
<form action="save" method="post">
    username: <input type="text" name="username"/>
    age: <input type="text" name="age"/>
    <button type="submit">전송</button>
</form>

</body>
</html>
