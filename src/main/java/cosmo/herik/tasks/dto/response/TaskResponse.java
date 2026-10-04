package cosmo.herik.tasks.dto.response;

import cosmo.herik.tasks.entities.Task;
import cosmo.herik.tasks.entities.TaskStatus;

import java.util.UUID;

public record TaskResponse(
        UUID id,
        String name,
        String description,
        TaskStatus status
) {
    public static TaskResponse fromEntity(Task task) {
        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus()
        );
    }
}
