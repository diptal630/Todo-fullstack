package com.todos.rest.webservices.restfulwebservices.Repository;

import com.todos.rest.webservices.restfulwebservices.Entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>
{
    List<Todo> findByUsername(String username);
}