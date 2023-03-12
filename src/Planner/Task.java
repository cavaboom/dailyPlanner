package Planner;

import java.time.LocalDateTime;
import java.util.Objects;
import Exception.IncorrectArgumentException;
import Util.Util;

public abstract class Task {
    private String title;
    private String description;
    private Type type;
    private LocalDateTime dateTime;
    private static Integer counter = 1;
    private Integer id;
    private boolean archived;


    public Task(String title, String description, Type type, LocalDateTime localDateTime) throws IncorrectArgumentException{
        this.title = Util.checkString(title);
        this.description = Util.checkString(description);
        this.type = type;
        this.dateTime = localDateTime;
        this.archived = false;
        id = counter++;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Type getType() {
        return type;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Integer getId() {
        return id;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return archived == task.archived && Objects.equals(title, task.title) && Objects.equals(description, task.description) && type == task.type && Objects.equals(dateTime, task.dateTime) && Objects.equals(id, task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, type, dateTime, id, archived);
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", dateTime=" + dateTime +
                ", id=" + id +
                ", archived=" + archived +
                '}';
    }
}
