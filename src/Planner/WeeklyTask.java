package Planner;

import java.time.LocalDateTime;
import Exception.IncorrectArgumentException;

public class WeeklyTask extends Task implements Repeatable{
    public WeeklyTask(String title, String description, Type type, LocalDateTime dateTime) throws IncorrectArgumentException {
        super(title, description, type, dateTime);
    }

    @Override
    public boolean checkOccurance(LocalDateTime requstedDate) {
        return getDateTime().getDayOfWeek().equals(requstedDate.getDayOfWeek());
    }
}
