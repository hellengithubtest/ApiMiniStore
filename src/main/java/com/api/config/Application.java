package com.api.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
//@ComponentScan("com.api.endpoint" "com.api.repository")
@ComponentScan (basePackages = "com.api")
public class Application {
    public static void main(String[] args) {
            ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
    }
}