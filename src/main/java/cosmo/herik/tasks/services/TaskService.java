package cosmo.herik.tasks.services;

import cosmo.herik.tasks.entities.Task;
import cosmo.herik.tasks.repositories.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void create(Task task) {
        taskRepository.save(task);
    }
}
