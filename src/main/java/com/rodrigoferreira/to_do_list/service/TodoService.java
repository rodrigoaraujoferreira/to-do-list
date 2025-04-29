package com.rodrigoferreira.to_do_list.service;

import java.util.List;


import org.springframework.stereotype.Service;
import com.rodrigoferreira.to_do_list.model.Todo;
import com.rodrigoferreira.to_do_list.repository.TodoRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
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
		log.info("Nova tarefa salva no banco de dados {}", todo);
		return listTasks();
	}
	
	public List<Todo> update(Todo todo){
		if (!todoRepository.existsById(todo.getId())) {
			log.warn("Tentativa de exclusão de tarefa inexistente ID: {}", todo.getId());
			throw new RuntimeException("Tarefa não encontrada para atualização.");
		}
		todoRepository.save(todo);
		log.info("Tarefa atualizada no banco de dados {}.", todo);
		return listTasks();
	}
	
	public List<Todo> delete(Long id) {
	    if (!todoRepository.existsById(id)) {
	    	log.warn("Tentatia de excluir tarefa com ID: {}.", id);
	        throw new RuntimeException("Tarefa não encontrada para exclusão.");
	    }

	    todoRepository.deleteById(id);
	    log.info("Tarefa com o ID: {} excluída com sucesso.", id);
	    return listTasks();
	}
	
}
