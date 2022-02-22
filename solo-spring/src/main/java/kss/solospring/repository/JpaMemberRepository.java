package kss.solospring.repository;


import kss.solospring.domain.MemberMember;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    private final EntityManager em;


    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public MemberMember save(MemberMember memberMember) {
        em.persist(memberMember);
        return memberMember;
    }

    @Override
    public Optional<MemberMember> findById(Long id) {
        MemberMember memberMember = em.find(MemberMember.class, id);
        return Optional.ofNullable(memberMember);
    }

    @Override
    public Optional<MemberMember> findByName(String name) {
        List<MemberMember> result = em.createQuery("select m from MemberMember m where m.name = :name", MemberMember.class)
                .setParameter("name", name)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public Optional<MemberMember> findByEmail(String email) {
        List<MemberMember> result = em.createQuery("select m from MemberMember m where m.email = :email", MemberMember.class)
                .setParameter("email", email)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<MemberMember> findAll() {
        return em.createQuery("select m from MemberMember", MemberMember.class)
                .getResultList();
    }
}
