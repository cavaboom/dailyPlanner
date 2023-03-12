package Planner;
import java.time.LocalDateTime;

public interface Repeatable {
    boolean checkOccurance(LocalDateTime localDateTime);

    void setTitle(String title);


    LocalDateTime getDateTime();

    void setArchived(boolean archived);
}
