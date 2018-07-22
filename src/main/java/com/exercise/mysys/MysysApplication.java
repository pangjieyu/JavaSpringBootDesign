package com.exercise.mysys;

import com.exercise.mysys.domain.SysUser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class MysysApplication extends WebMvcAutoConfiguration {

    public static void main(String[] args) {
        SpringApplication.run(MysysApplication.class, args);
    }
}
