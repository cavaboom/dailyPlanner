package Planner;

import java.time.LocalDateTime;
import Exception.IncorrectArgumentException;

public class YearlyTask extends Task implements Repeatable{
    public YearlyTask(String title, String description, Type type, LocalDateTime dateTime) throws IncorrectArgumentException {
        super(title, description, type, dateTime);
    }

    @Override
    public boolean checkOccurance(LocalDateTime requstedDate) {
        return getDateTime().getYear() == requstedDate.getYear();
    }
}
