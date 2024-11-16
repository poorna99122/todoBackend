package com.todoBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todoBackend.model.Todo;
import com.todoBackend.service.TodoService;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
	
	private TodoService todoService = null;
	
	
	@Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }
	
	 @GetMapping
	    public List<Todo> getAllTodos() {
	        return todoService.getAllTodos();
	    }
	 
	 @GetMapping("/{id}")
	    public ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
	        return ResponseEntity.ok(todoService.getTodoById(id));
	    }
	 
	 @PostMapping
	    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
	        Todo createdTodo = todoService.createTodo(todo);
	        return new ResponseEntity<>(createdTodo, HttpStatus.CREATED);
	    }
	 
	 @PutMapping("/{id}")
	    public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
	        return ResponseEntity.ok(todoService.updateTodo(id, todo));
	    }
	 
	 @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
	        todoService.deleteTodo(id);
	        return ResponseEntity.noContent().build();
	    }
	

}
