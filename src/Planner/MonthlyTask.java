package Planner;

import java.time.LocalDateTime;

import Exception.IncorrectArgumentException;
public class MonthlyTask extends Task implements Repeatable {
    public MonthlyTask(String title, String description, Type type, LocalDateTime dateTime) throws IncorrectArgumentException {
        super(title, description, type, dateTime);
    }

    @Override
    public boolean checkOccurance(LocalDateTime requestedDate) {
        return getDateTime().getDayOfMonth() == (requestedDate.getDayOfMonth());
    }
}
