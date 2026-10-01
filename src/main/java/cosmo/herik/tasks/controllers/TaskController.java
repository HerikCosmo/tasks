package cosmo.herik.tasks.controllers;

import cosmo.herik.tasks.entities.Task;
import cosmo.herik.tasks.services.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping(consumes = {"application/json"})
    public void create(@RequestBody Task task) {
        taskService.create(task);
    }

    @GetMapping
    public List<Task> findAll() {
        return taskService.findAll();
    }

    @GetMapping("/{id}")
    public Task findById(@PathVariable String id) {
        var taskId = UUID.fromString(id);
        return taskService.findById(taskId);
    }
}
