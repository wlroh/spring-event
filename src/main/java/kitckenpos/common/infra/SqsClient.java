package kitckenpos.common.infra;

import kitckenpos.common.event.MemberCreatedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class SqsClient {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @TransactionalEventListener
    public void memberCreated(final MemberCreatedEvent event) {
        // 이벤트를 전달받은뒤 다시 전달하는 방식으로 구현
        System.out.println("AWS SQS 요청" + event);
    }

}
