package kitckenpos.coupons.application.handler;

import kitckenpos.common.event.MemberCreatedEvent;
import kitckenpos.coupons.application.CouponService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
public class MemberCreatedEventHandler {

    private static final int ADULT_DISCOUNT_PERCENT = 50;
    private static final int DEFAULT_DISCOUNT_PERCENT = 20;
    private final CouponService couponService;

    public MemberCreatedEventHandler(final CouponService couponService) {
        this.couponService = couponService;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @TransactionalEventListener(condition = "#event.isAdult()")
    public void publishAdultCoupon(final MemberCreatedEvent event) {
        couponService.save(event.getId(), ADULT_DISCOUNT_PERCENT);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @TransactionalEventListener
    public void publishCoupon(final MemberCreatedEvent event) {
        couponService.save(event.getId(), DEFAULT_DISCOUNT_PERCENT);
    }
}
