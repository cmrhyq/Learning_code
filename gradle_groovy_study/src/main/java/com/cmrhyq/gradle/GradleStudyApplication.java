package com.cmrhyq.gradle;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@MapperScan(basePackages = {"com.cmrhyq.gradle.data.dao"})
public class GradleStudyApplication {

    public static void main(String[] args) {
        long beginTime = System.currentTimeMillis();
        SpringApplication.run(GradleStudyApplication.class, args);
        long endTime = System.currentTimeMillis();
        log.info("Program startup time consuming: {} ms", (endTime - beginTime));
    }

}
