package kitckenpos.members.application;

import kitckenpos.members.domain.Member;
import kitckenpos.members.domain.MemberRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(final MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public void join(final String name, final int age) {
        final Member member = new Member(name, age);
        memberRepository.save(member);
    }
}
