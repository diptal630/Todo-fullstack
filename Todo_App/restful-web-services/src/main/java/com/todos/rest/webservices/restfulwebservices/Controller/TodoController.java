package com.todos.rest.webservices.restfulwebservices.Controller;


import com.todos.rest.webservices.restfulwebservices.Entity.Todo;
import com.todos.rest.webservices.restfulwebservices.Service.TodoHardCodedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class TodoController {

    @Autowired
    private TodoHardCodedService todoService;

    @GetMapping("/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable  String username){
        return  todoService.finalAll();
    }

    @GetMapping("/users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable  String username, @PathVariable long id){
        return  todoService.findById(id);
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String username,@PathVariable long id){
       Todo todo =  todoService.deleteById(id);
        if(todo!= null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(
            @PathVariable String username,@PathVariable long id , @RequestBody Todo todo){
        Todo updatedTodo = todoService.save(todo);
        return new ResponseEntity<Todo>(todo, HttpStatus.OK);
    }


    @PostMapping("/users/{username}/todos")
    public ResponseEntity<Todo> createTodo(
        @PathVariable String username, @RequestBody Todo todo){
        Todo createdTodo = todoService.save(todo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }


}