package com.korit.korit_gov_spring_boot_study.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
class Todo{
    private int todoId;
    private String title;
    private String content;
}

@Controller
public class TodoController {
    List<Todo> todoList = new ArrayList<>();

    @GetMapping("/todo")
    public String todo() {
        return "todo";
    }

    @PostMapping("/todo")
    public String addTodo(@RequestParam String title, @RequestParam String content, Model model) {
        Todo todo = new Todo(todoList.size() + 1, title, content);
        todoList.add(todo);
        model.addAttribute("message", title + "가 등록되었습니다.");
        return "todo-result";
    }

    @GetMapping("/todos")
    public String todos(Model model) {
        model.addAttribute("todos", todoList);
        return "todos";
    }
}
