package com.sds.snow.todo.controller;

import com.sds.snow.todo.dto.MemberDto;
import com.sds.snow.todo.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/member")
public class MemberController {

    private final MemberService service;

    @PostMapping
    public void saveMember(@RequestBody MemberDto.SaveReq req) {
        log.debug("email: {}", req.email());
        log.debug("username: {}", req.username());
        service.saveMember(req);
    }

    @PostMapping("/check")
    public MemberDto.CheckRes checkMember(@RequestBody MemberDto.CheckReq req) {
        return new MemberDto.CheckRes(service.checkUser(req));
    }
}
