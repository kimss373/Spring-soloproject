package kss.solospring.repository;

import kss.solospring.domain.MemberMember;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    MemberMember save(MemberMember memberMember);
    Optional<MemberMember> findById(Long id);
    Optional<MemberMember> findByName(String name);
    Optional<MemberMember> findByEmail(String email);
    List<MemberMember> findAll();

}
