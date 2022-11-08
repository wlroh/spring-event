package kitckenpos.common.infra;

import kitckenpos.common.domain.MessageSender;
import kitckenpos.common.event.MemberCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EmailMessageSender implements MessageSender {

    @EventListener
    public void memberCreated(final MemberCreatedEvent event) {
        send(event.getName());
    }

    @Override
    public void send(final String name) {
        System.out.println("send email: " + name);
    }
}
