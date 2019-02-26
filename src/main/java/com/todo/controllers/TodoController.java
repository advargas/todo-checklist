package com.todo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.todo.exception.NotFoundException;
import com.todo.model.Todo;
import com.todo.model.TodoInfo;
import com.todo.model.TodoResponse;
import com.todo.services.TodoService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:3000","http://localhost"})
public class TodoController {
	
	private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }
    
	@RequestMapping(value = "/todo", method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
	public List<Todo> getAllTodos() {
		return this.todoService.getAllTodos();
	}

	@RequestMapping(value = "/todo/{todoCode}", method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
	public Todo getTodo(@PathVariable Integer todoCode) throws NotFoundException {
		return this.todoService.getTodo(todoCode);
	}
	
	@RequestMapping(value = "/todo", method = RequestMethod.POST, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Todo addTodo(@Valid @RequestBody final TodoInfo todoInfo) {
		return this.todoService.addTodo(todoInfo);
	}

	@RequestMapping(value = "/todo/{todoCode}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
	public Todo updateTodo(@PathVariable Integer todoCode, @Valid @RequestBody final TodoInfo todoInfo) throws NotFoundException {
		return this.todoService.updateTodo(todoCode, todoInfo);
	}

	@RequestMapping(value = "/todo/{todoCode}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
	public TodoResponse deleteTodo(@PathVariable Integer todoCode) throws NotFoundException {
		this.todoService.deleteTodo(todoCode);
		return new TodoResponse(true);
	}

}
