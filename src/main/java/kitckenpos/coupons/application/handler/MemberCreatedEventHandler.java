package kitckenpos.coupons.application.handler;

import kitckenpos.common.event.MemberCreatedEvent;
import kitckenpos.coupons.application.CouponService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class MemberCreatedEventHandler {

    private static final int ADULT_DISCOUNT_PERCENT = 50;
    private static final int DEFAULT_DISCOUNT_PERCENT = 20;
    private final CouponService couponService;

    public MemberCreatedEventHandler(final CouponService couponService) {
        this.couponService = couponService;
    }

    @EventListener(condition = "#event.isAdult()")
    public void publishAdultCoupon(final MemberCreatedEvent event) {
        couponService.save(event.getId(), ADULT_DISCOUNT_PERCENT);
    }

    @EventListener
    public void publishCoupon(final MemberCreatedEvent event) {
        couponService.save(event.getId(), DEFAULT_DISCOUNT_PERCENT);
    }
}
