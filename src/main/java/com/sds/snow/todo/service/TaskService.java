package com.sds.snow.todo.service;

import com.sds.snow.todo.dto.TaskDto;
import com.sds.snow.todo.mapper.TaskMapper;
import com.sds.snow.todo.model.Task;
import com.sds.snow.todo.repository.TaskRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TaskService {

    private final TaskMapper mapper;
    private final TaskRepository repository;

    public Long createTask(TaskDto.CreateReq dto) {
        Instant now = Instant.now();

        Task task = Task.builder()
                .contents(dto.contents())
                .isDone(false)
                .createdDate(now)
                .modifiedDate(now)
                .build();

        task = repository.save(task);
        return task.getId();
    }

    @Transactional
    public void updateTask(Long id, TaskDto.UpdateReq dto) {
        repository.findById(id).ifPresent((task) -> {
            if (dto.contents() != null) {
                task.setContents(dto.contents());
            }
            task.setDone(dto.isDone());
            task.setModifiedDate(Instant.now());

            repository.save(task);
        });
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
    }

    public void deleteTasks() {
        repository.deleteAll();
    }

    public List<TaskDto.FindRes> getTasks() {
        var result = repository.findAllByOrderById();

        return result.stream().map(mapper::modelToFindRes).collect(Collectors.toList());
    }
}
