package com.example.mvvm_backend.controller;

import com.example.mvvm_backend.model.Todo;
import com.example.mvvm_backend.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("todo")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("get")
    public ResponseEntity<List<Todo>> getAll() {
        return ResponseEntity.ok(todoService.fetchAllTodos());
    }

    @PostMapping("add")
    public ResponseEntity<Void> addTodo(@RequestBody Todo todo) {
        todoService.addTodo(todo);
        return ResponseEntity.ok().build();
    }

    @PostMapping("update")
    public ResponseEntity<Void> updateTodo(@RequestBody Todo todo) {
        System.out.println("To update: " + todo);
        todoService.updateTodo(todo);
        return ResponseEntity.ok().build();
    }
}
