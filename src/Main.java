import Planner.Task;
import Planner.TaskService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        TaskService den = new TaskService();
        den.addTask(in);
    }
}