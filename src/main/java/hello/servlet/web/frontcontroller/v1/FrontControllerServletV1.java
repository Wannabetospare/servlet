package hello.servlet.web.frontcontroller.v1;

import hello.servlet.web.frontcontroller.v1.controller.MemberFormControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberListControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberSaveControllerV1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


// 프론트 컨트롤러 무조건 이곳을 가장 먼저 거치고 다른 컨트롤러로 데이터를 주고 받는다.
// 먼저 urlPatterns 에 * 표시는 이 하위 경로의 모든 요청은 여기 서블릿에서 받아 들인다는 의미이다.
@WebServlet(name = "frontControllerServletV1", urlPatterns = "/front-controller/v1/*")
public class FrontControllerServletV1 extends HttpServlet {

    // 저장소에 문자형과 인터페이스를 키와 밸류 (짝)로 받는다.
    private Map<String, ControllerV1> controllerMap = new HashMap<>();


    // 클래스 생성자
    public FrontControllerServletV1(){
        controllerMap.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
        controllerMap.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
        controllerMap.put("/front-controller/v1/members", new MemberListControllerV1());
    }


    // 나중에 스프링으로 @Service 로 사용하게 될 부분 (지금은 컨트롤러에서 사용하지만 나중에는 서비스가 컨트롤러의 일을 위임받아 쓰인다.)
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServletV1.service");
        String requestURI = request.getRequestURI();

        // 주소를 받아서 저장된 맵에 있으면 구현체를 반환하고, 없으면 404 오류를 반환한다.
        // 만약 URI 주소로 /front-controller/v1/members/new-form를 받는다면, controllerMap 에서 value 로 new MemberFormControllerV1 를 받고
        // 만약 값이 없다면 404 오류를 띄우고, 있다면 MemberFormControllerV1.process 메서드를 실행한다.
        ControllerV1 controller = controllerMap.get(requestURI);
        if (controller == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        controller.process(request, response);


    }
}
