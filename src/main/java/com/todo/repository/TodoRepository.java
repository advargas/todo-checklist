package com.todo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.model.Todo;

@Transactional
@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
	
}
