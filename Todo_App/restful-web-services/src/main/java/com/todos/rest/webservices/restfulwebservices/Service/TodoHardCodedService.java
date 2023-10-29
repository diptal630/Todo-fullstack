package com.todos.rest.webservices.restfulwebservices.Service;

import com.todos.rest.webservices.restfulwebservices.Entity.Todo;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoHardCodedService {

    private static List<Todo> todos = new ArrayList<>();

    private static long idCounter = 0;

    static {
        todos.add(new Todo(++idCounter, "in28minutes", "Learn To Jenkins", new Date(), false));
        todos.add(new Todo(++idCounter, "in28minutes", "Learn To Angular", new Date(), false));
        todos.add(new Todo(++idCounter, "in28minutes", "Learn To AWS", new Date(), true));
    }

    public List<Todo> finalAll() {
        return todos;
    }

    public Todo deleteById(long id) {
        Todo todo = findById(id);
        if (todo == null) {
            return null;
        }
        if (todos.remove(todo)) {
            return todo;
        }
        return null;
    }

    public Todo findById(long id) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }

    public Todo save(Todo todo){
        if(todo.getId()==-1 || todo.getId()==0){
            todo.setId(++idCounter);
            todos.add(todo);
        }
        else{
            deleteById(todo.getId());
            todos.add(todo);
        }
        return todo;

    }

}
