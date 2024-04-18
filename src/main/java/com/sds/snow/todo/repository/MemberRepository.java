package com.sds.snow.todo.repository;

import com.sds.snow.todo.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findFirstByEmail(String email);
}
