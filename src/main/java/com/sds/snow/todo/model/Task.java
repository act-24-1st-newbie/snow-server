package com.sds.snow.todo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private boolean isDone;

    @Column(nullable = false)
    private Instant modifiedDate;

    @Column(nullable = false)
    private Instant createdDate;
}
