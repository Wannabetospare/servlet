package hello.servlet.web.frontcontroller.v3.controller;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {


    // 멤버 폼을 만드는 클래스, 상속받은 메서드
    // 반환타입은 ModelView 형
    @Override
    public ModelView process(Map<String, String> paramMap) {

        // ModelView 를 생성할 때 new-form 이라는 view의 논리적인 이름을 지정한다.
        // 실제 물리적인 이름은 프론트 컨트롤러에서 처리한다.
        return new ModelView("new-form");
    }
}




