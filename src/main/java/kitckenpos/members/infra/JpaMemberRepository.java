package kitckenpos.members.infra;

import kitckenpos.members.domain.Member;
import kitckenpos.members.domain.MemberRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMemberRepository extends MemberRepository, JpaRepository<Member, Long> {


}
