package hello.servlet.web.frontcontroller.v2;

import hello.servlet.web.frontcontroller.MyView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 인터페이스 껍데기
public interface ControllerV2 {


    // 메서드 껍데기
    // 반환타입은 MyView 형 이다. !!!!!!!!!!!
    MyView process(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException;
}
