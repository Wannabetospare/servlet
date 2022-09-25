package hello.servlet.web.frontcontroller.v3.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();


    // 오버라이드 해서 사용하는 메서드
    // 반환 타입은 ModelView 형
    @Override
    public ModelView process(Map<String, String> paramMap) {

        // 파라미터 정보는 map에 담겨있다. map에서 필요한 요청 파라미터를 조회하면 된다
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        // ModelView 를 생성할 때 new-form 이라는 view의 논리적인 이름을 지정한다.
        // 실제 물리적인 이름은 프론트 컨트롤러에서 처리한다.
        ModelView mv = new ModelView("save-result");

        // 모델은 단순한 map이므로 모델에 뷰에서 필요한 member 객체를 담고 반환한다.
        // Map 에 String 에는 "member"(문자)를 넣고, Object 에는 member(객체) 를 넣는다.
        mv.getModel().put("member", member);
        return mv;
    }


}
