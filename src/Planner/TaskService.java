package Planner;


import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import Exception.IncorrectArgumentException;
import Exception.TaskNotFoundException;
import Util.Util;


public class TaskService{
    private static final Map<Integer, Repeatable> actualTasks = new HashMap<>();
    private static final Map<Integer, Repeatable> archivedTasks = new HashMap<>();
    public static void addTask(Scanner scanner) {
        try {
            scanner.nextLine();
            System.out.println("Введите название задачи");
            String title = Util.checkString(scanner.nextLine());
            System.out.println("Введите описание задачи");
            String description = Util.checkString(scanner.nextLine());
            System.out.println("Введите тип задачи: 0 - рабочая, 1 - личная");
            Type type = Type.values()[scanner.nextInt()];
            System.out.println("Выберите повторяемость задачи: 0 - Однократная, 1 - Ежедневная, 2 - Еженедельная, 3 - Ежемесячная, 4 - Ежегодная");
            int occurance = scanner.nextInt();
            System.out.println("Введите дату: dd.MM.yyyy. HH:mm");
            scanner.nextLine();
            createEvent(scanner, title, description, type, occurance);
            System.out.println("Для выхода нажмите Enter\n");
            scanner.nextLine();
        } catch (IncorrectArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void createEvent(Scanner scanner, String title, String description, Type type, int occurance) {
        try {
            LocalDateTime eventDate = LocalDateTime.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
            Repeatable task = null;
            try {
                task = creatTask(occurance, title, description, type, eventDate);
                System.out.println("Создана задача" + task);
            } catch (IncorrectArgumentException e) {
                System.out.println(e.getMessage());
            }
        } catch (DateTimeParseException e) {
            System.out.println("Проверьте формат даты dd.MM.yyyy HH:mm и попробуйте еще раз");
            createEvent(scanner, title, description, type, occurance);
        }
    }

    public static void editTask(Scanner scanner) {
        try {
            System.out.println("Редактирование задачи: введите ID");
            //actualTasks();
            int id = scanner.nextInt();
            if(!actualTasks.containsKey(id)) {
                throw new TaskNotFoundException("Задача не найдена");
            }
            System.out.println("Редактирование 0-заголовок, 1-описание, 2-тип, 3-дата");
            int menuCase = scanner.nextInt();
            switch (menuCase) {
                case 0 -> {
                    scanner.nextLine();
                    System.out.println("Введите название задачи");
                    String title = scanner.nextLine();
                    Task task = (Task)actualTasks.get(id);

                    task.setTitle(title);
                }
                case 1 -> {
                    scanner.nextLine();
                    System.out.println("Введите описание задачи");
                    String descriprion = scanner.nextLine();
                    Repeatable task = actualTasks.get(id);
                    task.setTitle(descriprion);
                }
                case 2 -> {

                }
                case 3 -> {

                }
            }
        } catch (TaskNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteTask(Scanner scanner) {
        System.out.println("Текущие задачи\n");
        //actualTasks();
        try {
            System.out.println("Для удаления введите ID задачи\n");
            int id = scanner.nextInt();
            if(actualTasks.containsKey(id)) {
                Repeatable removedTask = actualTasks.get(id);
                removedTask.setArchived(true);
                archivedTasks.put(id, removedTask);
                System.out.println("Задача " + id + " удалена\n");
            } else {
                throw new TaskNotFoundException();
            }
        } catch (TaskNotFoundException e) {
            e.printStackTrace();
            System.out.println("Такой задачи не существует");
        }

    }

    public static void getTaskByDay(Scanner scanner) {
        System.out.println("Введите дату dd.MM.yyyy");
        try {
            String date = scanner.next();
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate requestedDate = LocalDate.parse(date, dateFormatter);
            List<Repeatable> foundEvents = findTasksByDate(requestedDate);
            System.out.println("События на " + requestedDate + ":");
            for (Repeatable task : foundEvents) {
                System.out.println(task);
            }
        } catch (DateTimeParseException e) {
            System.out.println("Проверьте формат даты dd.MM.yyyy");
        }
        scanner.nextLine();
        System.out.println("Для выхода нажмите Enter");
    }

    public static void printArchivedTasks() {
        for(Repeatable task : archivedTasks.values()) {
            System.out.println(task);
        }
    }


    private static List<Repeatable> findTasksByDate(LocalDate date) {
        List<Repeatable> tasks = new ArrayList<>();
        for (Repeatable task : actualTasks.values()) {
            if(task.checkOccurance(date.atStartOfDay())) {
                tasks.add(task);
            }
        }
        return tasks;
    }

    private static Repeatable creatTask(int occurance, String title, String description, Type type, LocalDateTime localDateTime) throws IncorrectArgumentException {
        return switch(occurance) {
            case 0 -> {
                OneTimeTask oneTimeTask = new OneTimeTask(title, description, type, localDateTime);
                actualTasks.put(oneTimeTask.getId(), oneTimeTask);
                yield oneTimeTask;
            }
            case 1 -> {
                DailyTask task = new DailyTask(title, description, type, localDateTime);
                actualTasks.put(task.getId(), task);
                yield task;
            }
            case 2 -> {
                WeeklyTask task = new WeeklyTask(title, description, type, localDateTime);
                actualTasks.put(task.getId(), task);
                yield task;
            }
            case 3 -> {
                MonthlyTask task = new MonthlyTask(title, description, type, localDateTime);
                actualTasks.put(task.getId(), task);
                yield task;
            }
            case 4 -> {
                YearlyTask task = new YearlyTask(title, description, type, localDateTime);
                actualTasks.put(task.getId(), task);
                yield task;
            }
            default -> null;
        };
    }
    private static void printActualTasks() {
        for(Repeatable task : actualTasks.values()) {
            System.out.println(task);
        }
    }
}
