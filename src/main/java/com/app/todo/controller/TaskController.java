package com.app.todo.controller;

import com.app.todo.models.Task;
import com.app.todo.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TaskController {

    @Autowired
    private final TaskService service;


    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping()
    public String getTasks(Model model) {
        List<Task> tasks = service.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @PostMapping()
    public String createTasks(@RequestParam String title) {
        service.createTasks(title);
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String deleteTasks(@PathVariable Long id) {
        service.deleteTasks(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/toggle")
    public String toggleTasks(@PathVariable Long id) {
        service.toggleTasks(id);
        return "redirect:/";
    }

}
