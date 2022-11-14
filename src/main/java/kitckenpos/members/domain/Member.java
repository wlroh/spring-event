package kitckenpos.members.domain;

import kitckenpos.common.event.MemberCreatedEvent;
import kitckenpos.members.domain.vo.Age;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;

@Entity
public class Member extends AbstractAggregateRoot<Member> {

    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Embedded
    private Age age;

    protected Member() {
    }

    public Member(final String name, final Integer age) {
        this(name, new Age(age));
    }

    public Member(final String name, final Age age) {
        this.name = name;
        this.age = age;
    }

    @PostPersist
    private void created() {
        registerEvent(new MemberCreatedEvent(id, name, age.toInt()));
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Age getAge() {
        return age;
    }
}
