package com.learn.business;


import java.util.ArrayList;
import java.util.List;

import com.learn.mockito.data.api.TodoService;

public class TodoBusinessImpl {
	private TodoService todoService;
	
	public List<String> retrieveTodosRelatedSpring(String user){
		List<String> filteredTodos = new ArrayList<String>();
		List<String> todos = todoService.retrieveTodos(user);
		for(String todo:todos) {
			if(todo.contains("spring")) {
				filteredTodos.add(todo);
			}
		}
		
		return todos;
	}

}
