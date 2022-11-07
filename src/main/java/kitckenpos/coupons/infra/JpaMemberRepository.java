package kitckenpos.coupons.infra;

import kitckenpos.coupons.domain.Coupon;
import kitckenpos.coupons.domain.CouponRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMemberRepository extends CouponRepository, JpaRepository<Coupon, Long> {
}
