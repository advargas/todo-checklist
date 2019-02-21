package com.todo.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.todo.model.Todo;
import com.todo.repository.TodoRepository;

@Configuration
@EntityScan(basePackageClasses = {Todo.class})
@EnableJpaRepositories( basePackageClasses = {TodoRepository.class})
@ComponentScan(basePackages="com.todo")
public class TodoConfig {

}
