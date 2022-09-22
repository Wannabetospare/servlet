package hello.servlet.web.servletmvc;


import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "mvcMemberListServlet", urlPatterns = "/servlet-mvc/members")
public class MvcMemberListServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        System.out.println("MvcMemberListServlet.service");
        List<Member> members = memberRepository.findAll();

        /*
           Model에 데이터를 보관한다.
           HttpServletRequest를 Model로 사용한다.
           request가 제공하는 setAttribute() 를 사용하면 request 객체에 데이터를 보관해서 뷰에 전달할 수 있다.
           뷰는 request.getAttribute() 를 사용해서 데이터를 꺼내면 된다.
         */
        request.setAttribute("members", members);

        // 위 모델을 싣어서 보낼 경로(주소)
        String viewPath = "/WEB-INF/views/members.jsp";
        // 주소에 데이터를 요청해서 옮기는 운행자
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        // 다른 서블릿이나 JSP로 이동할 수 있는 기능
        dispatcher.forward(request, response);
    }



}
