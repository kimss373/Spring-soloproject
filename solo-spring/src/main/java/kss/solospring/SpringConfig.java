package kss.solospring;


import kss.solospring.repository.JpaMemberRepository;
import kss.solospring.repository.MemberRepository;
import kss.solospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {

    private EntityManager em;

    public SpringConfig(EntityManager em){
        this.em = em;
    }

    @Bean
    public MemberService memberService() {return new MemberService(memberRepository());}

    @Bean
    public MemberRepository memberRepository(){
        return new JpaMemberRepository(em);
    }
}
