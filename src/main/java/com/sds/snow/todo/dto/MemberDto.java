package com.sds.snow.todo.dto;

public class MemberDto {

    public record CheckReq(String email) {}
    public record CheckRes(Boolean isExist) {}

    public record SaveReq(
            String email,
            String username
    ) {}
}
