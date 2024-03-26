package com.sds.snow.todo.dto;

import java.time.Instant;

public class TaskDto {

    public record CreateReq(
            String contents
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
