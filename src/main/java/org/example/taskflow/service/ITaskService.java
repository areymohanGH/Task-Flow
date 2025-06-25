package org.example.taskflow.service;

import org.example.taskflow.entity.Task;

import java.util.List;

public interface ITaskService {
    Task addTask(Task task);
    List<Task> getTasks();
    Task updateTask(Task task, Long id);
    Task getTaskById(Long id);
    void deleteTask(Long id);
}
