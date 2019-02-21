package com.todo.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.model.Todo;
import com.todo.model.TodoInfo;
import com.todo.repository.TodoRepository;

@Service
public class TodoService {
	
	private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

	public List<Todo> getAllTodos() {
		return this.todoRepository.findAll();
	}

	public Todo getTodo(Integer todoCode) {
		return this.todoRepository.findOne(todoCode);
	}

	public Todo addTodo(TodoInfo todoInfo) {
		Todo todo = getTodo(todoInfo);
		todo.setCreatedAt(new Date());
		todo.setUpdatedAt(new Date());
		this.todoRepository.saveAndFlush(todo);
		return todo;
	}

	public Todo updateTodo(Integer todoCode, TodoInfo todoInfo) {
		
		Todo todo = getTodo(todoCode);
		
		if (todo != null) {
			todo.setPriority(todoInfo.getPriority());
			todo.setText(todoInfo.getText());
			todo.setUpdatedAt(new Date());
			return this.todoRepository.saveAndFlush(todo);
		}
		return null;
	}

	public void deleteTodo(Integer todoCode) {
		this.todoRepository.delete(todoCode);
	}
	
	private Todo getTodo(TodoInfo todoInfo) {
		Todo todo = new Todo();
		todo.setText(todoInfo.getText());
		todo.setPriority(todoInfo.getPriority());
		return todo;
	}
	
}
