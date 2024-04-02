package com.sds.snow.todo.repository;

import com.sds.snow.todo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllByMemberIdOrderById(Long memberId);
}
