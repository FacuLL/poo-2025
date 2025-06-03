package Parciales2.R2_2023.Ej_1;

import java.time.LocalDate;

public class Event implements Comparable<Event> {
    private static Integer ID_INDEX = 0;
    private final Integer id;
    private final String file;
    private final LocalDate date;
    private final String user;
    private final EventType type;

    public Event(String file, LocalDate date, String user, EventType type) {
        this.id = ID_INDEX++;
        this.file = file;
        this.date = date;
        this.user = user;
        this.type = type;
    }

    @Override
    public String toString() {
        return "%s Event on file %s of user %s on %s".formatted(type, file, user, date);
    }

    @Override
    public int compareTo(Event o) {
        int cmp = this.date.compareTo(o.date);
        if (cmp == 0) cmp = this.type.compareTo(o.type);
        if (cmp == 0) cmp = this.id.compareTo(o.id);
        return cmp;
    }
}
