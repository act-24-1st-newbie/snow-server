package com.sds.snow.todo.service;

import com.sds.snow.todo.dto.MemberDto;
import com.sds.snow.todo.model.Member;
import com.sds.snow.todo.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository repository;

    @Transactional
    public void saveMember(MemberDto.SaveReq dto) {
        Member member = Member.builder()
                .email(dto.email())
                .userName(dto.username())
                .signupDate(Instant.now())
                .build();

        repository.save(member);
    }

    public boolean checkUser(MemberDto.CheckReq dto) {
        return repository.findFirstByEmail(dto.email()).isPresent();
    }
}
