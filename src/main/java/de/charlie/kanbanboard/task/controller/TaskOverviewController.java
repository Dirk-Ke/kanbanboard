package de.charlie.kanbanboard.task.controller;

import de.charlie.kanbanboard.task.repository.Task;
import de.charlie.kanbanboard.task.service.TaskService;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller(value = "taskOverviewController")
@Scope("session")
public class TaskOverviewController {

    private final TaskService taskOverviewService;

    private String name;
    private String description;
    private List<Task> tasks;

    @Autowired
    public TaskOverviewController(TaskService taskOverviewService) {
        this.taskOverviewService = taskOverviewService;
    }

    @PostConstruct
    public void init() {
        tasks = taskOverviewService.loadAllTasks();
    }

    public void saveTask() {
        PrimeFaces.current().executeScript("PF('editDialog').hide();");
        // TODO update tasks
    }

    public void action() {
        System.out.println("Action!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}