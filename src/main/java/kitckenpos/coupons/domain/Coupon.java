package kitckenpos.coupons.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Coupon {

    private static final int PERCENT_UNIT = 100;

    @Id
    @Column(name = "coupon_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long memberId;
    private double discountRate;

    protected Coupon() {
    }

    public Coupon(final Long memberId, final int discountPercent) {
        this.memberId = memberId;
        this.discountRate = calculateDiscountRate(discountPercent);
    }

    private double calculateDiscountRate(final double discountPercent) {
        return discountPercent / PERCENT_UNIT;
    }

    public Long getId() {
        return id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Coupon coupon = (Coupon) o;
        return Objects.equals(id, coupon.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
