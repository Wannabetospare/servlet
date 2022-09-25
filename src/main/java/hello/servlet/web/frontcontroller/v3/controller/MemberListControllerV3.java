package hello.servlet.web.frontcontroller.v3.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;

import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {

        List<Member> members = memberRepository.findAll();

        // 모델은 단순한 map이므로 모델에 뷰에서 필요한 member 객체를 담고 반환한다.
        // Map 에 String 에는 "members"(문자)를 넣고, Object 에는 members(리스트)를 넣는다.
        ModelView mv = new ModelView("members");
        mv.getModel().put("members", members);

        return mv;

    }
}
