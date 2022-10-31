package kitckenpos.members.domain.vo;

import kitckenpos.common.annotation.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@ValueObject
public class Age {

    private static final Integer MIN_VALUE = 1;

    @Column(name = "age", nullable = false)
    private Integer value;

    protected Age() {
    }

    public Age(final Integer value) {
        if (value < MIN_VALUE) {
            throw new IllegalArgumentException();
        }
        this.value = value;
    }

    public Integer toInt() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Age age = (Age) o;
        return Objects.equals(value, age.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
