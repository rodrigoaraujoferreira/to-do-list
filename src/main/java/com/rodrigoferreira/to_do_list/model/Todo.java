package com.rodrigoferreira.to_do_list.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "todos")
public class Todo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "tarefa é obrigatorio")
	@Column(name = "task")
	private String task;
	
	@NotBlank(message = "descrição da tarefa é obrigario")
	@Column(name = "task_description")
	private String taskDescription;
	
	@NotNull(message = "o status da tarefa é obrigatio")
	@Column(name = "task_completed")
	private Boolean taskCompleted = false;
}
