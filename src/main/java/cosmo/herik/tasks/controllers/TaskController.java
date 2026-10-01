package cosmo.herik.tasks.controllers;

import cosmo.herik.tasks.entities.Task;
import cosmo.herik.tasks.services.TaskService;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public void create(@RequestBody Task task) {
        taskService.create(task);
    }
}
