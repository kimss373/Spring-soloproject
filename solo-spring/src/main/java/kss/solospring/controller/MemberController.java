package kss.solospring.controller;


import kss.solospring.domain.MemberMember;
import kss.solospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){ return "members/createMemberForm";}
    @PostMapping("/members/new")
    public String create(MemberForm form){

        MemberMember memberMember = new MemberMember();

        memberMember.setId(form.getId());
        System.out.println("id");
        memberMember.setPw(form.getPw());
        System.out.println("pw");
        memberMember.setName(form.getName());
        System.out.println("name");
        memberMember.setEmail(form.getEmail());
        System.out.println("email");
        memberService.join(memberMember);
        System.out.println("11");


        return "redirect:/";
    }


    @GetMapping("/members")
    public String list(Model model){
        System.out.println(" members 접속 ");
        List<MemberMember> members = memberService.findMembers();
        System.out.println(" db 갔다옴ㅋ ");
        model.addAttribute("members", members);
        return "members/memberList";
    }


}
