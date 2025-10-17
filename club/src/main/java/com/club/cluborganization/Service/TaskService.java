package com.club.cluborganization.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.club.cluborganization.model.Task;
import com.club.cluborganization.repository.TasksRepository;

@Service
public class TaskService {

    private final TasksRepository tasksRepository;

    public TaskService(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    public List<Task> getAllTasks() {
        return tasksRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return tasksRepository.findById(id);
    }

    public Task saveTask(Task task) {
        return tasksRepository.save(task);
    }

    public void deleteTask(Long id) {
        tasksRepository.deleteById(id);
    }
}
