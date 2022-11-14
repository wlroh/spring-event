package kitckenpos.members.application;

import kitckenpos.common.event.MemberCreatedEvent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.ApplicationEvents;
import org.springframework.test.context.event.RecordApplicationEvents;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@RecordApplicationEvents
@SpringBootTest
public class MemberServiceEventTestV2 {

    @Autowired
    private MemberService memberService;

    @Autowired
    private ApplicationEvents events;

    @DisplayName("유저를 회원가입하면 MemberCreatedEvent 를 발행한다.")
    @Test
    void memberCreatedEvent() {
        memberService.join("홍길동", 20);

        assertAll(
                () -> assertThat(events.stream(MemberCreatedEvent.class).count()).isEqualTo(1),
                () -> assertThat(events.stream(MemberCreatedEvent.class).findFirst().get().getId()).isNotNull()
        );
    }
}
