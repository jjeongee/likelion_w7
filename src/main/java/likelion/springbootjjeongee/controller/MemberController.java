package likelion.springbootjjeongee.controller;

import likelion.springbootjjeongee.domain.*;
import likelion.springbootjjeongee.service.MemberService;

import likelion.springbootjjeongee.service.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**스프링 컨테이너 내부에 Controller 어노테이션 생성
 * MemberController 객체 생성, 스프링이 직접 관리함
 */
@org.springframework.stereotype.Controller
@RequestMapping("members")
public class MemberController {

    //매번 MemberService라는 객체를 생성할 필요 없이 하나의 객체를 공유해서 사용
    private final MemberService memberService;

    //생성자에 Autowired가 있으면 스프링과 스프링 컨테이너 서비스 연결
    @Autowired
    public MemberController(MemberServiceImpl memberService){
        this.memberService = memberService;
        //MemberController 생성시 memberSerivce 삽입(의존관계)
    }

    //"members/new"경로로 접근하면 createMemberForm 주소 찾아서 이동
    @GetMapping("members/new")
    public String createForm(Model model){
        model.addAttribute("memberForm",new Member());
        //model.addAttribute의 key,value 형태로 정보 전달
        return "members/createMemberForm";
    }
    //createMemberForm >> Post 넘긴 정보들을 PostMapping으로 받아서 처리
    //화면에 송출
    @PostMapping("new")
    public String create(Member member){
        memberService.save(member);
        return "redirect:/";
    }

    //GetMapping("members") >> templates/members/memberList로 이동
    @GetMapping("")
    public String findAll(Model model){
        List<Member> memberList = memberService.findAll();
        model.addAttribute("memberList",memberList);
        return "members/memberList";
    }

    //컨트롤러 통해서 외부요청 받고
    //서비스를 통해서 비즈니스 로직 생성하고
    //레포지토리에서 데이터 저장
}
