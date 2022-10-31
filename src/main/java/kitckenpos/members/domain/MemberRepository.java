package kitckenpos.members.domain;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MemberRepository {

    Member save(final Member member);

    Optional<Member> findById(final UUID id);

    List<Member> findAll();

    List<Member> findAllByIdIn(final List<UUID> ids);
}
