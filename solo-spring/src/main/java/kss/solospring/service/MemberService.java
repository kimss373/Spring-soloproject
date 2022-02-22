package kss.solospring.service;


import kss.solospring.domain.MemberMember;
import kss.solospring.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class MemberService {

    private final MemberRepository memberRepository;


    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public long join(MemberMember memberMember){
        validateDuplicateMember(memberMember);
        memberRepository.save(memberMember);
        return memberMember.getId();
    }

    private void validateDuplicateMember(MemberMember memberMember){
        memberRepository.findByName(memberMember.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("중복된 회원입니다.");
                });
    }

    public List<MemberMember> findMembers(){return memberRepository.findAll();}



}
