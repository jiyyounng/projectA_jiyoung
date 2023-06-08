package com.study.projectA.entity;

import com.study.projectA.web.dto.MemberResponseDto;
import com.study.projectA.web.dto.MemberSaveRequestDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsById(String id);
    Member findById(String id);
}
