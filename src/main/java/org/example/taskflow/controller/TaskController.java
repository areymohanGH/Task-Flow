package org.example.taskflow.controller;

import lombok.RequiredArgsConstructor;
import org.example.taskflow.entity.Task;
import org.example.taskflow.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    @PostMapping("/addTask")
    public Task addTask(@RequestBody Task task) {
        return taskService.addTask(task);
    }

    @GetMapping
    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PutMapping("/updateTask/{id}")
    public Task updateTask(@RequestBody Task task,  @PathVariable Long id) {
        return  taskService.updateTask(task, id);
    }

    @DeleteMapping("/deleteTask/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}
