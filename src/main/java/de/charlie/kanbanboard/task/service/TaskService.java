package de.charlie.kanbanboard.task.service;

import de.charlie.kanbanboard.task.repository.Task;
import de.charlie.kanbanboard.task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;

@Service
@Scope("prototype")
@Transactional(rollbackFor = Throwable.class)
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task saveTask(final Task task) {
        return taskRepository.save(task);
    }

    public Task update(Task task, final String name, final String description) {
        checkArgument(!task.isNew(), "Not persisted Task cannot be updated.");
        Task.update(task, name, description);
        return taskRepository.save(task);
    }

    public void deleteTask(Task task) {
        taskRepository.delete(task);
    }

    public List<Task> loadAllTasks() {
        return taskRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }
}