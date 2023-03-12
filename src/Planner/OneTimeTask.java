package Planner;
import Exception.IncorrectArgumentException;
import java.time.LocalDateTime;


public  class OneTimeTask extends Task implements Repeatable{
    public OneTimeTask (String title, String description, Type type, LocalDateTime date) throws IncorrectArgumentException {
        super(title, description, type, date);
    }

    @Override
    public boolean checkOccurance(LocalDateTime requstedDate) {
        return getDateTime().toLocalDate().equals(requstedDate.toLocalDate());
    }
}
