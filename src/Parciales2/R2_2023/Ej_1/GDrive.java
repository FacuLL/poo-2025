package Parciales2.R2_2023.Ej_1;

import java.time.LocalDate;
import java.util.*;

public class GDrive {
    private final Map<String, SortedSet<Event>> events = new HashMap<>();
    private final Map<String, String> files = new HashMap<>();

    public void addFileToWorkArea(String file, String workspace) {
        if (files.get(file) != null) throw new IllegalArgumentException("File already exists");
        files.put(file, workspace);
    }

    public void logEvent(String file, String user, LocalDate date, EventType type) {
        String workspace = files.get(file);
        if (workspace == null) throw new IllegalArgumentException("File does not exist");
        events.putIfAbsent(workspace, new TreeSet<>());
        events.get(workspace).add(new Event(file, date, user, type));
    }

    public Set<Event> events(String workspace) {
        return events.getOrDefault(workspace, new TreeSet<>());
    }

    public Event earliestEvent(String workspace) {
        SortedSet<Event> events = this.events.get(workspace);
        if (events == null || events.isEmpty()) throw new NoSuchElementException();
        return events.getFirst();
    }

    public Event mostRecentEvent(String workspace) {
        SortedSet<Event> events = this.events.get(workspace);
        if (events == null || events.isEmpty()) throw new NoSuchElementException();
        return events.getLast();
    }
}
