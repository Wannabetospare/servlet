
<%--import 하는 부분이 자바와 비슷함--%>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

 <%--    <% %> 를 사용하면 안에 부분은 전부 자바코드 처럼 사용가능하다.   --%>
<%
    // request, response 그냥 사용 가능
    // 여기는 자바 코드처럼 사용
    MemberRepository memberRepository = MemberRepository.getInstance();

    System.out.println("save.jsp");
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    Member member = new Member(username, age);
    System.out.println("member = " + member);
    memberRepository.save(member);


%>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
성공
<ul>
  <li>id=<%member.getId();%></li>
  <li>username=<%member.getUsername();%></li>
  <li>age=<%member.getAge();%></li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>

<%--
JSP - 이 파일 하나로 멤버를 저장하고  HTML로 열면서 데이터를 받아서 보여준다.
--%>
