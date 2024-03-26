package com.sds.snow.todo.mapper;

import com.sds.snow.todo.dto.TaskDto;
import com.sds.snow.todo.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.Instant;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface TaskMapper {

    default Long mapToLong(Instant instant) {
        return instant == null ? null : instant.toEpochMilli();
    }

    @Mapping(target = "isDone", source = "done")
    TaskDto.FindRes modelToFindRes(Task task);
}
