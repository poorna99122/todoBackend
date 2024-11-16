package com.todoBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoBackend.model.Todo;
import com.todoBackend.repository.TodoRepository;

@Service
public class TodoService {
	private TodoRepository todoRepository = null;
	
	 @Autowired
	    public TodoService(TodoRepository todoRepository) {
	        this.todoRepository = todoRepository;
	    }
	 
	 public List<Todo> getAllTodos() {
	        return todoRepository.findAll();
	    }
	 
	 public Todo getTodoById(Long id) {
	        return todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found with ID: " + id));
	    }
	 

	    public Todo createTodo(Todo todo) {
	        return todoRepository.save(todo);
	    }
	    
	    public Todo updateTodo(Long id, Todo updatedTodo) {
	        if (!todoRepository.existsById(id)) {
	            throw new RuntimeException("Todo not found with ID: " + id);
	        }
	        updatedTodo.setId(id);
	        return todoRepository.save(updatedTodo);
	    }
	    
	    public void deleteTodo(Long id) {
	        if (!todoRepository.existsById(id)) {
	            throw new RuntimeException("Todo not found with ID: " + id);
	        }
	        todoRepository.deleteById(id);
	    }
	
	
	
}
