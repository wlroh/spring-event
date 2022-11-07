package kitckenpos.coupons.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CouponTest {

    @DisplayName("쿠폰을 생성한다.")
    @Test
    void create() {
        // when
        final Coupon coupon = new Coupon(1L, 30);

        // then
        assertAll(
                () -> assertThat(coupon.getMemberId()).isEqualTo(1L),
                () -> assertThat(coupon.getDiscountRate()).isEqualTo(0.3)
        );
    }
}
