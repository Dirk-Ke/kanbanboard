package de.charlie.kanbanboard.task.repository;


import de.charlie.kanbanboard.base.repository.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

@Entity
public class Task extends BaseEntity {

    public static final int MAX_NAME_LENGTH = 40;
    public static final int MAX_DESCRIPTION_LENGTH = 400;

    @Column(length = MAX_NAME_LENGTH, nullable = false)
    private String name;

    @Column(length = MAX_DESCRIPTION_LENGTH, nullable = false)
    private String description;

    protected Task() {}

    private Task(final String name, final String description) {
        this.name = name;
        this.description = description;
    }

    public static Task getInstance(final String name, final String description) {
        checkNotNull(name, "Name cannot be null");
        checkArgument(name.length() <= MAX_NAME_LENGTH, "Max length for field 'name' is 40 characters.");
        checkNotNull(description, "Description cannot be null");
        checkArgument(description.length() <= MAX_DESCRIPTION_LENGTH, "Max length for field 'description' is 400 characters.");
        return new Task(name, description);
    }

    public static void update(final Task task, final String name, final String description) {
        checkNotNull(task, "Task cannot be null");
        if (name != null) {
            checkArgument(name.length() <= MAX_NAME_LENGTH, "Max length for field 'name' is 40 characters.");
            task.name = name;
        }
        if (description != null) {
            checkArgument(description.length() <= MAX_DESCRIPTION_LENGTH, "Max length for field 'description' is 400 characters.");
            task.description = description;
        }
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + " name=" + name + '}';
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return description;
    }
}