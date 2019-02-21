package com.todo.model;

import org.hibernate.validator.constraints.NotEmpty;

public class TodoInfo {
	
	@NotEmpty
	private String text;
	
	@NotEmpty
	private String priority;
	

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}	
}
