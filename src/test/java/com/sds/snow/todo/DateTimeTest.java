package com.sds.snow.todo;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class DateTimeTest {

    @Test
    public void test1() {
        LocalDateTime now = LocalDateTime.now();

        System.out.println(now.atZone(ZoneId.of("UTC+9")).toEpochSecond());
        System.out.println(now.toString());

        Instant i = Instant.now();

        System.out.println(i.toEpochMilli());
    }
}
