package com.rodrigoferreira.to_do_list.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.rodrigoferreira.to_do_list.ToDoListApplication;
import com.rodrigoferreira.to_do_list.model.Todo;
import com.rodrigoferreira.to_do_list.repository.TodoRepository;

@Service
public class TodoService {

	TodoRepository todoRepository;

	public TodoService(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}
	
	public List<Todo> listTasks(){
		return todoRepository.findAll();
	}
	
	public List<Todo> create(Todo todo){
		todoRepository.save(todo);
		return listTasks();
	}
	
	public List<Todo> update(Todo todo){
		todoRepository.save(todo);
		return listTasks();
	}
	
	public List<Todo> delete(Long id) {
	    if (!todoRepository.existsById(id)) {
	        throw new RuntimeException("Tarefa não encontrada para exclusão");
	    }

	    todoRepository.deleteById(id);
	    return listTasks();
	}
	
}
