package Planner;

import java.time.LocalDateTime;
import java.util.Objects;
import Exception.IncorrectArgumentException;
import Util.Util;

public class Task {
    private String title;
    private String description;
    //private Type type;
    private int id;

    //private LocalDateTime dateTime;

    public Task(String title, String description, int id){
        this.title = title;
        this.description = description;
        //this.type = type;
        //this.dateTime = dateTime;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

//    public Type getType() {
//        return type;
//    }

    public int getId() {
        return id;
    }

    /*public LocalDateTime getDateTime() {
        return dateTime;
    }*/

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Task task = (Task) o;
//        return id == task.id && Objects.equals(title, task.title) && Objects.equals(description, task.description) && type == task.type && Objects.equals(dateTime, task.dateTime);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(title, description, type, id, dateTime);
//    }
//
//    @Override
//    public String toString() {
//        return "Task{" +
//                "title='" + title + '\'' +
//                ", description='" + description + '\'' +
//                ", type=" + type +
//                ", id=" + id +
//                ", dateTime=" + dateTime +
//                '}';
//    }
}
