package com.learn.business;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.learn.mockito.data.api.TodoService;
import com.learn.mockito.data.api.TodoServiceStub;

public class TodoBusinessImplStubTest {

	@Test
	public void test1() {
		TodoService todoService = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = 
				new TodoBusinessImpl(todoService);
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedSpring("dummy");
		assertEquals(2, filteredTodos.size());
	}
}
