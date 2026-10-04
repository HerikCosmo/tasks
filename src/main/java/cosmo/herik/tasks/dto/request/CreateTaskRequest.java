package cosmo.herik.tasks.dto.request;

import cosmo.herik.tasks.entities.Task;
import cosmo.herik.tasks.entities.TaskStatus;

public record CreateTaskRequest(
        String title,
        String description
) {
    public Task toEntity() {
        return new Task(
                null,
                title,
                description,
                TaskStatus.PENDING,
                null,
                null
        );
    }
}
