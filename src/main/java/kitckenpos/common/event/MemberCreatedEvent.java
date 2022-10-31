package kitckenpos.common.event;

import java.util.Objects;

public class MemberCreatedEvent {

    private static final int MIN_ADULT_AGE = 20;

    private final Long id;
    private final String name;
    private final int age;

    public MemberCreatedEvent(final Long id, final String name, final int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public boolean isAdult() {
        return age >= MIN_ADULT_AGE;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final MemberCreatedEvent that = (MemberCreatedEvent) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
