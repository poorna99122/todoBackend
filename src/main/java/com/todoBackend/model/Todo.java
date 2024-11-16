package com.todoBackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Todo {
	
	 	@Id
	 	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "todo_seq_gen")
	    @SequenceGenerator(name = "todo_seq_gen", sequenceName = "todos_seq", allocationSize = 1)
	    private Long id;

	    private String title;
	    
	    private Boolean completed;
	    
	    public Todo() {
	    }
	    
	    public Todo(String title, Boolean completed) {
	        this.title = title;
	        this.completed = completed;
	    }


	    public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public Boolean getCompleted() {
			return completed;
		}

		public void setCompleted(Boolean completed) {
			this.completed = completed;
		}

		
	    
	 

}
