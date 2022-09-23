package hello.servlet.web.frontcontroller.v1.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.v1.ControllerV1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberSaveControllerV1 implements ControllerV1 {


    private MemberRepository memberRepository = MemberRepository.getInstance();


    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // request 에서 파라미터를 가져온후 초기화 해준다.
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));


        // 위 에서 초기화한 파라미터로 생성자를 만들어주고, 저장소에 멤버를 저장한다.
        Member member = new Member(username, age);
        memberRepository.save(member);


        /*
           Model에 데이터를 보관한다.
           HttpServletRequest를 Model로 사용한다.
           request가 제공하는 setAttribute() 를 사용하면 request 객체에 데이터를 보관해서 뷰에 전달할 수 있다.
           뷰는 request.getAttribute() 를 사용해서 데이터를 꺼내면 된다.
         */
        request.setAttribute("member", member);

        // 위 모델을 옮길 경로(주소)
        String viewPath = "/WEB-INF/views/save-result.jsp";
        // 주소에 데이터를 요청해서 옮기는 운행자
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        // 다른 서블릿이나 JSP로 이동할 수 있는 기능
        dispatcher.forward(request, response);
    }
}
