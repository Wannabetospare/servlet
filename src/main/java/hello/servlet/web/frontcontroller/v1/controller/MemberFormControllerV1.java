package hello.servlet.web.frontcontroller.v1.controller;

import hello.servlet.web.frontcontroller.v1.ControllerV1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


// 회원등록 컨트롤러
public class MemberFormControllerV1 implements ControllerV1 {


    // ContollerV1 에서 상속받은 메서드를 구현하여 사용하는 메서드 부
    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 경로 ( WEB-INF 경로는 무조건 컨트롤러를 통해서만 열 수 있다. 직접 파일로 열 수 없음 )
        String viewPath = "/WEB-INF/views/new-form.jsp";
        //  request.getRequestDispatcher -> 경로를 담아서 운행(전달)해주는 역할
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        //  dispatcher.forward -> 다른 서블릿이나 JSP로 이동할 수 있는 기능, 서버 내부에서 다시 호출 !!!
        dispatcher.forward(request, response);

    }
}
