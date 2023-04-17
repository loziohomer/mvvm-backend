package com.example.mvvm_backend.service;

import com.example.mvvm_backend.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    private final List<Todo> todoList = new ArrayList<>(Arrays.asList(
            new Todo(1L, "Spesa", "Pane, latte, uova", false),
            new Todo(2L, "Meccanico", "Sostituzione led fanale", false),
            new Todo(3L, "Assistenza pc", "Portare il PC in assistenza", false)
    ));

    @Override
    public List<Todo> fetchAllTodos() {
        System.out.println(todoList);
        return todoList;
    }

    @Override
    public void addTodo(Todo todo) {
        Long max = todoList.parallelStream().mapToLong(Todo::getId).max().orElse(0);
        max++;
        todo.setId(max);
        todoList.add(todo);
        System.out.println(todoList);
    }

    @Override
    public void updateTodo(Todo todo) {
        int index = todoList.indexOf(todo);
        todoList.set(index, todo);
        System.out.println(todoList);
    }
}
