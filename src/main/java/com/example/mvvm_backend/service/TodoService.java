package com.example.mvvm_backend.service;

import com.example.mvvm_backend.model.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> fetchAllTodos();
    void addTodo(Todo todo);
    void updateTodo(Todo todo);
}
