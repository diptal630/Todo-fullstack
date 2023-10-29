package com.todos.rest.webservices.restfulwebservices.Service;

import com.todos.rest.webservices.restfulwebservices.Entity.Todo;
import java.util.List;

public interface TodoServiceInterface {
    public List<Todo> getAllTodos(String username);
    public Todo getTodo(String username, long id);
    public Void deleteTodo(String username, long id);
    public Todo updateTodo(String username, long id, Todo todo);
    public Void createTodo(String username,Todo todo);
    }
