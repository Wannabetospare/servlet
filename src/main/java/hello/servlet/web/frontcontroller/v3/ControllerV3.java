package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;

import java.util.Map;



// v1, v2 랑 다르게 HTTP 서블릿에 의존하지 않음 - 서블릿 종속성 제거
public interface ControllerV3 {

    ModelView process(Map<String, String> paramMap);
}
