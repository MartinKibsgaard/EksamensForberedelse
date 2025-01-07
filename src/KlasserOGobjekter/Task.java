package KlasserOGobjekter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {
    private final String name;
    private final Date deadline;

    public Task(String name, Date deadline) throws IllegalAccessException {
        if (name == null || name.isEmpty()) {
            throw new IllegalAccessException("Må ikke være tom.");
        }
        this.name = name;
        this.deadline = deadline;
    }

    public String getName() {
        return name;
    }

    public Date getDeadline() {
        return deadline;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return name + " (Deadline: " + sdf.format(deadline) + ")";
    }
}