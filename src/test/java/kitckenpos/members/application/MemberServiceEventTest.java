package kitckenpos.members.application;

import kitckenpos.common.event.MemberCreatedEvent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MemberServiceEventTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private FakeEventListener fakeEventListener;

    @DisplayName("유저를 회원가입하면 MemberCreatedEvent 를 발행한다.")
    @Test
    void memberCreatedEvent() {
        memberService.join("홍길동", 20);

        assertThat(fakeEventListener.getCount()).isEqualTo(1);
    }
}

@Component
class FakeEventListener {

    private int count = 0;

    @EventListener
    public void memberCreated(final MemberCreatedEvent event) {
        count++;
    }

    public int getCount() {
        return count;
    }
}
