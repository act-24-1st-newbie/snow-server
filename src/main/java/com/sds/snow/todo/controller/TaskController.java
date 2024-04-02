package com.sds.snow.todo.controller;

import com.sds.snow.todo.dto.TaskDto;
import com.sds.snow.todo.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/v1/task")
public class TaskController {

    private final TaskService service;

    @PostMapping
    public Long createTask(@RequestBody TaskDto.CreateReq dto) {
        log.debug("contents = {}" , dto.contents());
        return service.createTask(dto);
    }

    @GetMapping("/{id}")
    public List<TaskDto.FindRes> getTasks(@PathVariable("id") Long memberId) {
        return service.getTasks(memberId);
    }

    @PatchMapping("/{id}")
    public void updateTask(@PathVariable("id") Long id, @RequestBody TaskDto.UpdateReq dto) {
        service.updateTask(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable("id") Long id) {
        service.deleteTask(id);
    }

    @DeleteMapping
    public void deleteTasks() {
        service.deleteTasks();
    }
}
