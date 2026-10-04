package cosmo.herik.tasks.dto.request;

import cosmo.herik.tasks.entities.Task;
import cosmo.herik.tasks.entities.TaskStatus;

public record UpdateTaskRequest(
        String title,
        String description,
        TaskStatus status
) {
    public Task toEntity() {
        return new Task(
                null,
                title,
                description,
                status,
                null,
                null
        );
    }
}
