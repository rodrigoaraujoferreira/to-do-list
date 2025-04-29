package com.rodrigoferreira.to_do_list.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rodrigoferreira.to_do_list.model.Todo;
import com.rodrigoferreira.to_do_list.service.TodoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/todo")
public class TodoController {
	
	TodoService todoService;
	
	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}

	@GetMapping
	public List<Todo> listTasks() {
		return todoService.listTasks();
	}
	
	@PostMapping
	public List<Todo> createTask(@RequestBody @Valid Todo todo) {
		return todoService.create(todo);
	}
	
	@PutMapping
	public List<Todo> updateTask(@RequestBody @Valid Todo todo) {
		return todoService.update(todo);
	}
	
	@DeleteMapping("/{id}")
	public List<Todo> deleteTask(@PathVariable Long id) {
		return todoService.delete(id);
	}
	
	
}
