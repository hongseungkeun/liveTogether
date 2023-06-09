package com.develop.liveTogether.application.member.repository;

import com.develop.liveTogether.application.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {
    boolean existsByMemberNickname(String memberNickname);
    Optional<Member> findByMemberNameAndMemberPhone(String memberName, String memberPhone);
    Optional<Member> findByMemberIdAndMemberPhone(String memberId, String memberPhone);
}
