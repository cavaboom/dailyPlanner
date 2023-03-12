package Planner;

import java.time.LocalDateTime;
import Exception.IncorrectArgumentException;

public class DailyTask extends Task implements Repeatable {
    public DailyTask(String title, String description, Type type, LocalDateTime dateTime) throws IncorrectArgumentException {
        super(title, description, type, dateTime);
    }

    @Override
    public boolean checkOccurance(LocalDateTime requstedDate) {
        return getDateTime().toLocalDate().equals(requstedDate.toLocalDate());
    }
}
