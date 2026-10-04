package cosmo.herik.tasks.services;

import cosmo.herik.tasks.dto.request.CreateTaskRequest;
import cosmo.herik.tasks.dto.request.UpdateTaskRequest;
import cosmo.herik.tasks.dto.response.TaskResponse;
import cosmo.herik.tasks.exceptions.TaskNotFoundException;
import cosmo.herik.tasks.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskResponse create(CreateTaskRequest taskRequest) {
        var task = taskRequest.toEntity();
        var taskSaved = taskRepository.save(task);

        return TaskResponse.fromEntity(taskSaved);
    }

    public List<TaskResponse> findAll() {
        return taskRepository.findAll().stream().map(TaskResponse::fromEntity).toList();
    }

    public TaskResponse findById(UUID id) {
        var task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));

        return TaskResponse.fromEntity(task);
    }

    public TaskResponse update(UUID id, UpdateTaskRequest taskRequest) {
        var task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));

        task.setTitle(taskRequest.title());
        task.setDescription(taskRequest.description());
        task.setStatus(taskRequest.status());

        return TaskResponse.fromEntity(taskRepository.save(task));
    }

    public void delete(UUID id) {
        var task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));

        taskRepository.delete(task);
    }
}
