package com.study.projectA.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findById(String id);
    //boolean existsByEmail(String email);
    boolean existsById(String id);
}
