package com.example.firstproject.members.controller;

import com.example.firstproject.members.dto.MemberDTO;
import com.example.firstproject.members.entity.Member;
import com.example.firstproject.members.repository.MemberRepository;
import com.sun.source.tree.MemberReferenceTree;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Slf4j
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/members/new")
    public String CreateMember(){
        return "members/new";
    }

    @PostMapping("/members/join")
    public String SignUpMember(MemberDTO form){
        log.info(form.toString());
        Member member = form.toEntity();
        log.info(member.toString());
        Member saved = memberRepository.save(member);
        log.info(saved.toString());
        return "redirect:/members/" + saved.getId();
    }

    @GetMapping("/members/{id}")
    public String show(@PathVariable Long id, Model model){
        Member memberEntity = memberRepository.findById(id).orElse(null);
        model.addAttribute("member", memberEntity);
        return "members/show";
    }

    @GetMapping("/members")
    public String index(Model model){
        List<Member> memberEntityList = memberRepository.findAll();
        model.addAttribute("memberList", memberEntityList);
        return "members/index";
    }

    @GetMapping("/members/{id}/edit")
    public String edit(@PathVariable Long id, Model model){
        Member memberEntity = memberRepository.findById(id).orElse(null);
        model.addAttribute("member", memberEntity);
        return "members/edit";
    }

    @PostMapping("/members/update")
    public String update(MemberDTO form){
        Member memberEntity =form.toEntity();
        Member target = memberRepository.findById(memberEntity.getId()).orElse(null);
        if(target != null){
            memberRepository.save(memberEntity);
        }
        return "redirect:/members/" + memberEntity.getId();
    }
}
