package cosmo.herik.tasks.controllers;

import cosmo.herik.tasks.dto.request.CreateTaskRequest;
import cosmo.herik.tasks.dto.request.UpdateTaskRequest;
import cosmo.herik.tasks.dto.response.TaskResponse;
import cosmo.herik.tasks.services.TaskService;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.CREATED)
    public TaskResponse create(@RequestBody CreateTaskRequest taskRequest) {
        return taskService.create(taskRequest);
    }

    @GetMapping
    public List<TaskResponse> findAll() {
        return taskService.findAll();
    }

    @GetMapping("/{id}")
    public TaskResponse findById(@PathVariable String id) {
        var taskId = UUID.fromString(id);
        return taskService.findById(taskId);
    }

    @PutMapping(path = "/{id}", consumes = {"application/json"})
    public TaskResponse update(@PathVariable String id, @RequestBody UpdateTaskRequest taskRequest) {
        var taskId = UUID.fromString(id);
        return taskService.update(taskId, taskRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        taskService.delete(UUID.fromString(id));
    }
}
