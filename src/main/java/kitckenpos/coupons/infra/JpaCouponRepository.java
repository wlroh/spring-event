package kitckenpos.coupons.infra;

import kitckenpos.coupons.domain.Coupon;
import kitckenpos.coupons.domain.CouponRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCouponRepository extends CouponRepository, JpaRepository<Coupon, Long> {
}
