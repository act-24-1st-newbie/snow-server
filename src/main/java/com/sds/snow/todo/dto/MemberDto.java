package com.sds.snow.todo.dto;

public class MemberDto {

    public record CheckRes(Boolean isExist) {}

    public record FindReq(String email) {}

    public record FindRes(
            Long id,
            String email,
            String username
    ) {}

    public record SaveReq(
            String email,
            String username
    ) {}
}
