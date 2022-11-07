package kitckenpos.coupons.application;

import kitckenpos.coupons.domain.Coupon;
import kitckenpos.coupons.domain.CouponRepository;
import org.springframework.stereotype.Service;

@Service
public class CouponService {

    private final CouponRepository couponRepository;

    public CouponService(final CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    public Coupon save(final Long memberId, final int discountPercent) {
        final Coupon coupon = new Coupon(memberId, discountPercent);
        couponRepository.save(coupon);
        return coupon;
    }
}
