package Planner;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.time.LocalDateTime;
import Exception.IncorrectArgumentException;
import Util.Util;

public class TaskService{
    Map<Integer, Task> tasks = new HashMap<Integer, Task>();

    int idGenerator = 0;

    public void generateId() {
        if(tasks.isEmpty()) {
            idGenerator = 1;
        } else {
            idGenerator = tasks.size() + 1;
        }
    }
    public void addTask(Scanner scanner) {
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("Введите название задачи");
            String title = in.nextLine();
            System.out.println("Введите описание задачи");
            String description = in.nextLine();
            if (tasks.isEmpty()) {
                idGenerator = 1;
            } else {
                idGenerator = tasks.size() + 1;
            }
            int id = idGenerator;
            Task tempTask = new Task(title, description, id);
            tasks.put(1, tempTask);
            tasks.put(2, tempTask);
            for (Map.Entry<Integer, Task> item : tasks.entrySet()) {
                System.out.println(tempTask.getTitle() + tempTask.getDescription() + tempTask.getId());
            }
        } while (tasks.size()<=10);
        return;
    }

    public void viewTasks() {

    }

    public void taskExistenceCheck() {
        if (tasks.isEmpty()) {

        }
    }
}
