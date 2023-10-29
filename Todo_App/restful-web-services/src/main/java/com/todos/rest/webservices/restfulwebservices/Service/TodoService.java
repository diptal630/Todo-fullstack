package com.todos.rest.webservices.restfulwebservices.Service;

import com.todos.rest.webservices.restfulwebservices.Entity.Todo;
import com.todos.rest.webservices.restfulwebservices.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService implements TodoServiceInterface{

    @Autowired
    TodoRepository todoRepository;

    @Override
    public List<Todo> getAllTodos(String username) {
       List<Todo> todoList =  todoRepository.findAll();
        return todoList;
    }

    @Override
    public Todo getTodo(String username, long id) {
        Todo todo =todoRepository.findById(id).get();
        return todo;
    }

    @Override
    public Void deleteTodo(String username, long id) {
        todoRepository.deleteById(id);
        return null;
    }

    @Override
    public Todo updateTodo(String username, long id, Todo todo) {
        Todo todoUpdated = todoRepository.save(todo);
        return todoUpdated;
    }

    @Override
    public Void createTodo(String username, Todo todo) {
        Optional<Todo> s1 = todoRepository.findById()
        Todo createdTodo = todoRepository.save(todo);
        return null;
    }
}
