package org.example.taskflow.service;

import lombok.RequiredArgsConstructor;
import org.example.taskflow.entity.Task;
import org.example.taskflow.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService implements ITaskService {
    private final TaskRepository taskRepository;

    @Override
    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task updateTask(Task task, Long id) {
        return taskRepository.findById(id).map(tsk -> {
            tsk.setTitle(task.getTitle());
            tsk.setDescription(task.getDescription());
            tsk.setStatus(task.getStatus());
            return taskRepository.save(tsk);
        }).orElse(null);
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
