package kitckenpos.common.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Events {

    private static ApplicationEventPublisher publisher = null;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @PostConstruct
    private void setPublisher() {
        publisher = applicationEventPublisher;
    }

    public static void registerEvent(Object any) {
        publisher.publishEvent(any);
    }
}
