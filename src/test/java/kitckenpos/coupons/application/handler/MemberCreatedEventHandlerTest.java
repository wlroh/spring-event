package kitckenpos.coupons.application.handler;

import kitckenpos.common.event.MemberCreatedEvent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.transaction.annotation.Transactional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@Transactional
class MemberCreatedEventHandlerTest {

    @Autowired
    private ApplicationEventPublisher publisher;

    @MockBean
    private MemberCreatedEventHandler handler;

    @DisplayName("성인이 가입하면 성인쿠폰, 일반쿠폰 모두 발급된다.")
    @Test
    void adultMemberCreatedEventHandler() {
        // when
        publisher.publishEvent(new MemberCreatedEvent(1L, "홍길동", 30));

        // then
        verify(handler, times(1)).publishAdultCoupon(any());
        verify(handler, times(1)).publishCoupon(any());
    }

    @DisplayName("학생이 가입하면 일반쿠폰만 발급된다.")
    @Test
    void memberCreatedEventHandler() {
        // when
        publisher.publishEvent(new MemberCreatedEvent(1L, "홍길동", 15));

        // then
        verify(handler, times(0)).publishAdultCoupon(any());
        verify(handler, times(1)).publishCoupon(any());
    }
}
