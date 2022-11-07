package kitckenpos.coupons.domain;

import java.util.Optional;

public interface CouponRepository {

    Coupon save(final Coupon coupon);

    Optional<Coupon> findById(final Long id);
}
