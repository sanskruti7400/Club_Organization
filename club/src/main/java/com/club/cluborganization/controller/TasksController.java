package com.club.cluborganization.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.club.cluborganization.model.Task;
import com.club.cluborganization.repository.TasksRepository;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    private final TasksRepository tasksRepository;

    public TasksController(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return tasksRepository.findAll();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return tasksRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return tasksRepository.save(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task details) {
        Task task = tasksRepository.findById(id).orElse(null);
        if (task != null) {
            task.setTaskName(details.getTaskName());
            task.setDescription(details.getDescription());
            task.setStatus(details.getStatus());
            task.setEvent(details.getEvent());
            task.setAssignedTo(details.getAssignedTo());
            return tasksRepository.save(task);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        tasksRepository.deleteById(id);
    }
}
