package com.sds.snow.todo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity(name = "members")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private Instant signupDate;
}
