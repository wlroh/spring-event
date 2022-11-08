package kitckenpos.members.application;

import kitckenpos.common.event.MemberCreatedEvent;
import kitckenpos.members.domain.Member;
import kitckenpos.members.domain.MemberRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final ApplicationEventPublisher publisher;

    public MemberService(final MemberRepository memberRepository, final ApplicationEventPublisher publisher) {
        this.memberRepository = memberRepository;
        this.publisher = publisher;
    }

    @Transactional
    public void join(final String name, final int age) {
        final Member member = new Member(name, age);
        memberRepository.save(member);
        final MemberCreatedEvent event = new MemberCreatedEvent(member.getId(), member.getName(), member.getAge().toInt());
        publisher.publishEvent(event);
    }
}
