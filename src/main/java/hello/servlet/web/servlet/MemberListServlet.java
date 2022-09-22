package hello.servlet.web.servlet;


import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


// 서블릿 방식 - 회원 리스트 - HTML 코드를 문자로 자바 클래스 안에 집어넣는다.

@WebServlet(name = "memberListServlet", urlPatterns = "/servlet/members")
public class MemberListServlet extends HttpServlet {

        private MemberRepository memberRepository = MemberRepository.getInstance();

        @Override
        protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

                response.setContentType("text/html");
                response.setCharacterEncoding("utf-8");
                List<Member> members = memberRepository.findAll();
                PrintWriter w = response.getWriter();
                w.write("<html>");
                w.write("<head>");
                w.write("    <meta charset=\"UTF-8\">");
                w.write("    <title>Title</title>");
                w.write("</head>");
                w.write("<body>");
                w.write("<a href=\"/index.html\">메인</a>");
                w.write("<table>");
                w.write("    <thead>");
                w.write("    <th>id</th>");
                w.write("    <th>username</th>");
                w.write("    <th>age</th>");
                w.write("    </thead>");
                w.write("    <tbody>");

                for (Member member : members) {
                                w.write("    <tr>");
                                w.write("        <td>" + member.getId() + "</td>");
                                w.write("        <td>" + member.getUsername() + "</td>");
                                w.write("        <td>" + member.getAge() + "</td>");
                                w.write("    </tr>");
                        }
                        w.write("    </tbody>");
                        w.write("</table>");
                        w.write("</body>");
                        w.write("</html>");



        }



}
