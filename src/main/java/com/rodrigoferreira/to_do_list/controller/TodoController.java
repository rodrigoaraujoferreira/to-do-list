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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/todo")
@Tag(name = "Tarefas", description = "Operaçoes relacionadas a tarefas.")
public class TodoController {
	
	TodoService todoService;
	
	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}

	@Operation(summary = "Listar Tarefas", description = "Retorna todos as tarefas cadastradas no sistema.")
	@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
	@GetMapping
	public List<Todo> listTasks() {
		return todoService.listTasks();
	}
	
	@Operation(summary = "Cadastra uma tarefa", description = "Cadastra uma nova tarefa no sistema e retorna uma lista atualizada.")
	@ApiResponse(responseCode = "200", description = "Tarefa cadastrada com sucesso.")
	@ApiResponse(responseCode = "400", description = "Erro ao cadastrar uma nova tarefa.")
	@PostMapping
	public List<Todo> createTask(@RequestBody @Valid Todo todo) {
		return todoService.create(todo);
	}
	
	@Operation(summary = "Atualizar Tarefa", description = "Atualizar uma nova tarefa no sistema e retorna uma lista atualizada.")
	@ApiResponse(responseCode = "200", description = "Tarefa atualizada com sucesso.")
	@ApiResponse(responseCode = "400", description = "Erro ao atualziar uma nova tarefa.")
	@PutMapping
	public List<Todo> updateTask(@RequestBody @Valid Todo todo) {
		return todoService.update(todo);
	}
	
	@Operation(summary = "Deletar Tarefa", description = "Deletar Tarefa por ID.")
	@ApiResponse(responseCode = "200", description = "Tarefa deletada com sucesso.")
	@ApiResponse(responseCode = "500", description = "Erro ao atualziar uma nova tarefa.")
	@DeleteMapping("/{id}")
	public List<Todo> deleteTask(@PathVariable Long id) {
		return todoService.delete(id);
	}
	
	
}
