package com.sds.snow.todo.dto;

public class TaskDto {

    public record CreateReq(
            String contents,
            Long memberId
    ) {}

    public record UpdateReq(
            String contents,
            boolean isDone
    ) {}

    public record FindRes(
            Long id,
            String contents,
            boolean isDone,
            Long createdDate,
            Long modifiedDate
    ) {}
}
