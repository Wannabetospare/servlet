package hello.servlet.web.servletmvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


// MVC 패턴으로 멤버 폼을 컨트롤한다.

@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 경로 ( WEB-INF 경로는 무조건 컨트롤러를 통해서만 열 수 있다. 직접 파일로 열 수 없음 )
        String viewPath = "/WEB-INF/views/new-form.jsp";
        //  request.getRequestDispatcher -> 경로를 담아서 운행(전달)해주는 역할
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        //  dispatcher.forward -> 다른 서블릿이나 JSP로 이동할 수 있는 기능, 서버 내부에서 다시 호출 !!!
        dispatcher.forward(request, response);


    }
}
