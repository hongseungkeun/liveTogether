package com.develop.liveTogether.application.member.repository;

import com.develop.liveTogether.application.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {
    boolean existsByNickname(String memberNickname);
}
