package com.todos.rest.webservices.restfulwebservices.Controller;

import com.todos.rest.webservices.restfulwebservices.Entity.Todo;
import com.todos.rest.webservices.restfulwebservices.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class JpaController {

    @Autowired
    TodoService todoService;

    @GetMapping("/jpa/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username){
        //return todoJpaRepository.findByUsername(username);
        return todoService.findAll();
    }

    @GetMapping("/jpa/users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username, @PathVariable long id){
        //return todoJpaRepository.findById(id).get();
        return todoService.findById(id);
    }

    //DELETE /users/{username}/todos/{id}
    @DeleteMapping("/jpa/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(
            @PathVariable String username, @PathVariable long id){

        Todo todo = todoService.deleteById(id);
        //todoJpaRepository.deleteById(id);

        return ResponseEntity.noContent().build();
        //return ResponseEntity.notFound().build();
    }


    //Edit/Update a Todo
    //PUT /users/{user_name}/todos/{todo_id}
    @PutMapping("/jpa/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(
            @PathVariable String username,
            @PathVariable long id, @RequestBody Todo todo){

        //Todo todoUpdated = todoService.save(todo);
        Todo todoUpdated = todoJpaRepository.save(todo);

        return new ResponseEntity<Todo>(todo, HttpStatus.OK);
    }

    @PostMapping("/jpa/users/{username}/todos")
    public ResponseEntity<Void> createTodo(
            @PathVariable String username, @RequestBody Todo todo){

        //Todo createdTodo = todoService.save(todo);
        todo.setUsername(username);
        //Todo createdTodo = todoJpaRepository.save(todo);

        //Location
        //Get current resource url
        ///{id}
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createdTodo.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

}
}
