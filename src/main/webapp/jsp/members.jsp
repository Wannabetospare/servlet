
<%--import 하는 부분이 자바와 비슷함--%>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="java.util.List" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    // 여기는 자바코드로 사용, 필요한 객체나 메모리를 선언해놓는다.
    MemberRepository memberRepository = MemberRepository.getInstance();
    List<Member> members = memberRepository.findAll();
%>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
<a href="/index.html">메인</a>
<table>
    <thead>
    <th>id</th>
    <th>username</th>
    <th>age</th>
    </thead>
    <tbody><%

        // 사용할떄마다  JSP 괄호를 열어서 사용한다.
        for (Member member : members) {
            out.write("    <tr>");
            out.write("         <td>" + member.getId() + "</td>");
            out.write("         <td>" + member.getUsername() + "</td>");
            out.write("         <td>" + member.getAge() + "</td>");
            out.write("    <tr>");
        }
    %>
    </tbody>
</table>
</body>
</html>

<%--
JSP - 이 파일 하나로 저장된 멤버들의 데이터를 가져와서 HTML로 보여줌
-%>